package com.example.mystockapplication;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class StockPriceFetcher {
    private static final String TAG = "STOCK_FETCHER";
    private RequestQueue _queue;

    private final static String REQUEST_URL = "http://10.26.181.52:3000/stockPrice";

    public class StockResponse {
        public boolean isError;
        public String name;
        public double price;


        public StockResponse(boolean isError, String name, double price) {
            this.isError = isError;
            this.name = name;
            this.price = price;
        }

    }

    public interface StockResponseListener {
        public void onResponse(StockResponse response);
    }

    public StockPriceFetcher(Context context) {
        _queue = Volley.newRequestQueue(context);
    }

    private StockResponse createErrorResponse() {
        return new StockResponse(true, null, 0);
    }

    public void dispatchRequest(final String stock, final String token, final StockResponseListener listener) {
        JSONObject getBody = new JSONObject();
        try {
            getBody.put("name", stock);
            getBody.put("token", token);
        }
        catch (JSONException e){
            listener.onResponse(createErrorResponse());
            return;
        }

        Log.d(TAG,"Json object: " + getBody.toString());
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, REQUEST_URL, getBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG,"Response: " + response.toString());
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(createErrorResponse());
            }
        });
        Log.d(TAG, "dispatchRequest: " + req.getBody());

        _queue.add(req);
    }

}






