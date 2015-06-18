package fr.apside.tpservicestarted;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private boolean run = true;
    private Handler handler;
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        handler = new Handler(Looper.getMainLooper());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (run) {
                    Log.i("My TAG", "#################################Plop from service################################");
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_SHORT).show();
                        }
                    });
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        this.run = false;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
