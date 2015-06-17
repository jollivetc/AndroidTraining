package fr.apside.tpasycn;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends Activity {


    private Button button;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyDownloadTask().execute();
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent pref = new Intent(this, SettingsActivity.class);
            startActivity(pref);
        }

        return super.onOptionsItemSelected(item);
    }

    class MyDownloadTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            button.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.INVISIBLE);
            button.setVisibility(View.VISIBLE);

            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, i, PendingIntent.FLAG_ONE_SHOT);

            Notification.Builder notifBuilder = new Notification.Builder(MainActivity.this)
                            .setSmallIcon(R.drawable.ic_launcher)
                            .setContentTitle("Un content title")
                            .setTicker("un Ticker")
                            .setContentText("un content texte")
                            .setAutoCancel(true)
                            .setVibrate(new long[]{0,500, 500, 500})
                            .setLights(0xff0000ff, 500, 500)
                            .setContentIntent(pendingIntent);

            ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).notify(2, notifBuilder.build());
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0] * 10);
        }

        @Override
        protected String doInBackground(String... params) {
            for(int i =0; i<10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i+1);
            }
            return null;
        }
    }
}
