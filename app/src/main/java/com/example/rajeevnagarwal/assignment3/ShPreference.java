package com.example.rajeevnagarwal.assignment3;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class ShPreference extends AppCompatActivity {

    EditText mpref_edit;
    static String TAG="ShPreference";
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"in onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sh_preference);
        initialize();
        pref = getApplication().getSharedPreferences("mydata",MODE_PRIVATE);
        if(pref.getString("mydata","").length()>=1)
        {
            mpref_edit.append(pref.getString("mydata",""));

        }

    }
    public void initialize()
    {
        Log.d(TAG,"in initialize()");
        mpref_edit = (EditText)findViewById(R.id.pref_text);

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
        /*Saving data in Shared Preference*/
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("mydata",mpref_edit.getText().toString());
        edit.commit();

    }
}
