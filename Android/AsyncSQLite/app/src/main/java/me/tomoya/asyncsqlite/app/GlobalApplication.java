package me.tomoya.asyncsqlite.app;

import android.app.Application;
import android.util.Log;
import com.activeandroid.ActiveAndroid;

/**
 * Created by usr0200379 on 2014/06/03.
 */
public class GlobalApplication extends Application {

    private static final String TAG = "DEBUG-APPLICATION";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG, "--- onCreate() in ---");
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.v(TAG,"--- onTerminate() in ---");
        ActiveAndroid.dispose();
    }
}
