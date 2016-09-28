package com.example.rajeevnagarwal.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button mpref_button,mfile_button,mdb_button;
    private static String TAG="HomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"In onCreate()");
        super.onCreate(savedInstanceState);
        initialize();
        setContentView(R.layout.activity_home);
    }
    public void initialize()
    {
        Log.d(TAG,"In initialize()");
        mpref_button = (Button)findViewById(R.id.pref);
        mfile_button = (Button)findViewById(R.id.file);
        mdb_button = (Button)findViewById(R.id.db);
    }

    public void onStart()
    {
        Log.d(TAG,"In onStart()");
        super.onStart();
    }
    public void onResume()
    {
        Log.d(TAG,"In onResume()");
        super.onResume();
    }
    public void onDestroy()
    {
        Log.d(TAG,"In onDestroy()");
        super.onDestroy();
    }
    public void onStop()
    {
        Log.d(TAG,"In onStop()");
        super.onStop();
    }


}
