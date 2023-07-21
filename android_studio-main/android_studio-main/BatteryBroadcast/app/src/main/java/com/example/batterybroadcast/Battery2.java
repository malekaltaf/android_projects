package com.example.batterybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

class Battery2 extends BroadcastReceiver {
    TextView tv;
    Battery2(TextView tv){
        this.tv=tv;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
            int percentage = intent.getIntExtra("level",0);
            if(percentage!=0)
            {
                tv.setText(percentage+"%");
            }
    }
}
