package fr.apside.tpbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyMessageReceiver extends BroadcastReceiver {
    public MyMessageReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        Toast.makeText(context, "message : " + bundle.getString("message"), Toast.LENGTH_LONG).show();
    }
}