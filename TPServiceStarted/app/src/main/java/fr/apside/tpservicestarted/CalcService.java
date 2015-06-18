package fr.apside.tpservicestarted;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class CalcService extends Service {
    public CalcService() {
    }

    public class MyCalcBinder extends Binder {
        CalcService getCalcService() {
            return CalcService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyCalcBinder();
    }

    public int add(int a, int b) {
        return a + b;
    }
}
