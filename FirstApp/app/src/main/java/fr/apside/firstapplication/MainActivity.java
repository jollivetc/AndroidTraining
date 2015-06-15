package fr.apside.firstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    private final String TAG = getClass().getSimpleName();
    private static final int RQ = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(getClickListener());
        button2.setOnClickListener(getClickListenerForButton2());
        Log.i(TAG, "on create");

    }

    private View.OnClickListener getClickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "HELLO", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("name", "Durand");
                i.putExtra("firstName", "Robert");
                startActivity(i);
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RQ) {
            String name = data.getStringExtra("name");
            String firstname = data.getStringExtra("firstName");
            Toast.makeText(this, name + " " + firstname, Toast.LENGTH_SHORT).show();
        }
    }

    private View.OnClickListener getClickListenerForButton2() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("name", "Durand");
                i.putExtra("firstName", "Robert");
                startActivityForResult(i, RQ);
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "on start");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "on restart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "on resume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "on pause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "on stop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "on destroy");

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
