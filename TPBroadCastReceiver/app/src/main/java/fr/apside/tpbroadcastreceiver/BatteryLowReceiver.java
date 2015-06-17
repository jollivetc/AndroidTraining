package fr.apside.tpbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by christophe on 17/06/15.
 */
public class BatteryLowReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "J'ai faim!!!!!!!", Toast.LENGTH_LONG).show();
    }
}
