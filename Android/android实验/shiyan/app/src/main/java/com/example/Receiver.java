package com.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context,intent.getStringExtra("name"),Toast.LENGTH_LONG).show();

        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))  //开机自启动
        {
            Intent i = new Intent(context, shiyan1Activity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

    }
}
