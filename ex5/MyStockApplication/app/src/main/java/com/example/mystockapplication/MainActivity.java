package com.example.mystockapplication;

        import android.app.ProgressDialog;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.iid.FirebaseInstanceId;
        import com.google.firebase.iid.InstanceIdResult;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static String TOKEN = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getToken();
    }


    public void fetchStockPrice(final View view) {
        Log.d(TAG, "button pressed");
        final StockPriceFetcher fetcher = new StockPriceFetcher(view.getContext());
        final String stock = ((EditText)findViewById(R.id.edit_stock)).getText().toString();


        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Fetching stock's price for " + stock + "...");
        progressDialog.show();




        fetcher.dispatchRequest(stock, MainActivity.TOKEN, new StockPriceFetcher.StockResponseListener() {
            @Override
            public void onResponse(StockPriceFetcher.StockResponse response) {
                progressDialog.dismiss();

                if (response.isError) {
                    Toast.makeText(view.getContext(), "Error while fetching price", Toast.LENGTH_LONG);
                    return;
                }
            }
        });

    }

    public void getToken(){
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        MainActivity.TOKEN = task.getResult().getToken();

                        Log.d(TAG, "The token is:" + MainActivity.TOKEN);
                    }
                });
    }

    protected void onResume(){
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.mystockapplication.onMessageReceived");
        MyBroadcastReceiver receiver = new MyBroadcastReceiver();
        registerReceiver(receiver, intentFilter);
    }

    private class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String name = extras.getString("name");
            Log.d(TAG, "name got from firebase: " + name);
            String price = extras.getString("price");
            Log.d(TAG, "price got from FireBase: " + price);

            updateView(name, price);// update your textView in the main layout
        }

        private void updateView(String stockName, String stockPrice) {
            ((TextView) MainActivity.this.findViewById(R.id.stockName)).setText(stockName);
            ((TextView) MainActivity.this.findViewById(R.id.price)).setText(stockPrice + '$');
        }
    }

}