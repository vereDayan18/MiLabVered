const express = require('express');
const fs = require('fs');

// create an instance of express to serve our end points
const app = express();
const path = './Tasks.json'

// create a const variable for the port number
const PORT = 3000;

// read tasks list
app.get('/tasks', (req, res) => {
    console.log('Got request to /tasks')
    fs.readFile(path, (err, data) => {
        if (err) {
            throw err;
        }
        res.send(JSON.parse(data));
    });
});

const readFile = (callback, filePath = path) => {
    fs.readFile(filePath, (err, data) => {
        if (err) {
            throw err;
        }

        callback(JSON.parse(data));
    });
};

const writeFile = (fileData, callback, filePath = path) => {

    fs.writeFile(filePath, fileData, (err) => {
        if (err) {
            throw err;
        }

        callback();
    });
};

// create new task
app.post('/tasks/new', (req, res) => {
    console.log('Got request to /new')

    readFile(data => {
        let newUserId = req.query.id;

        // add the new user
        data[newUserId] = req.query.task;

        writeFile(JSON.stringify(data, null, 2), () => {
            res.status(200).send('new task added');
        });
    });
});

//delete the task specified by task id
app.delete('/tasks/remove', (req, res) => {
    console.log('Got request to /remove')

    readFile(data => {

        // add the new user
        const userId = req.query.id;
        delete data[userId];

        writeFile(JSON.stringify(data, null, 2), () => {
            res.status(200).send(`users id:${userId} removed`);
        });
    });
});

// launch our server on port 3000
const server = app.listen(PORT, () => {
    console.log(`listening on port ${PORT}`);
});