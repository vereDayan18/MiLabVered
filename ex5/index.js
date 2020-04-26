const express = require('express');
const bodyParser = require('body-parser');
const request = require('request');
const admin = require("firebase-admin");
const serviceAccount = require("./stockprice-e8515-firebase-adminsdk.json");

const PORT = 3000;
const API_KEY = 'V87ZM7HTV1FZS6IE';

const DEFULT_STOCK = 'SAP';

var registrationToken = "";

var app = express();
app.use(express.json());

admin.initializeApp({
    credential: admin.credential.cert(serviceAccount),
    databaseURL: "https://stockprice-e8515.firebaseio.com"
  });
  
app.post('/stockPrice', (req, res, next) => {
    console.log("got POST request")
    let stockName = req.body.name;
    console.log('The stock name is: ' + stockName);

    if(!stockName){
        stockName = DEFULT_STOCK;
    }

    registrationToken = req.body.token;
    console.log('The token is: ' + registrationToken);

    var url = `https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=${stockName}&apikey=${API_KEY}`;

    var firstTime = 1;

    var globalQuote;
    var price = 0;

    function timeout(){
        setTimeout(function () {            
            firstTime = 0;
            request(url, function (err, response, body){
                if(err){
                    console.log('error:', error);
                    response.status(400).json({err: "Failed sending request to AlphaVantage"});
                } else {
                    let stockDetails = JSON.parse(body);
                    if(stockDetails){
                        let globalQuote = stockDetails["Global Quote"];
                        if(globalQuote != undefined) {
                            price = globalQuote["05. price"];
                        }
                        let message = `Stock ${stockName} current price is: ${price}`;
                        console.log(message);

                        sendDataToFireBase(registrationToken, stockName, price);

                    }
                }
            })
            timeout();
        }, firstTime? 1 : 15000)}
        timeout();
});


function sendDataToFireBase(token, stockName, price){
    var payload = {
        data: {
            name: stockName,
            price: price
        },
        notification: {
            body: `The price of ${stockName} is ${price}`
        }  
    };
    admin.messaging().sendToDevice(token, payload)
        .then(function(response) {
        console.log("Successfully sent message:", response);
    })
        .catch(function(error) {
        console.log("Error sending message:", error);
    });
}


const server = app.listen(PORT, () => {
    console.log(`listening on port ${PORT}`);
});

