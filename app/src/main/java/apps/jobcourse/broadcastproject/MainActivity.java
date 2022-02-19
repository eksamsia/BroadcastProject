package apps.jobcourse.broadcastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CustomReceiver mCustomReceiver = new CustomReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        membuat event" yang akan diterima

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        registerReceiver(mCustomReceiver, intentFilter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mCustomReceiver);
    }
}