package com.example.rajeevnagarwal.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class IEFile extends AppCompatActivity {

    Button mInt_button,mExt_button;
    static String TAG="IEFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iefile);
        initialize();
    }
    public void initialize()
    {
        Log.d(TAG,"In initialize()");
        mInt_button = (Button)findViewById(R.id.internal_button);
        mExt_button = (Button)findViewById(R.id.external_button);
    }
    public void onInt(View v)
    {
        Log.d(TAG,"in onInt()");
        startActivity(new Intent(this,InternalActivity.class));
    }
    public void onExt(View v)
    {
        Log.d(TAG,"in onExt()");
        startActivity(new Intent(this,ExternalActivity.class));

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
