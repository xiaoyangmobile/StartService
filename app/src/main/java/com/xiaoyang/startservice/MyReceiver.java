package com.xiaoyang.startservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == Intent.ACTION_BOOT_COMPLETED || intent.getAction() == "com.xiaoyang.service.destroy") {
            Intent myServiceIntent = new Intent(context, MyService.class);
            context.startService(myServiceIntent);
        }
    }
}