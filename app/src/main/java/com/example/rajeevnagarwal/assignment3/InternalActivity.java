package com.example.rajeevnagarwal.assignment3;

import android.os.Environment;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InternalActivity extends AppCompatActivity {

    Button mInt_read,mInt_write;
    EditText mInt_edit;
    TextView mInt_view;
    static String TAG="InternalActivity";
    String text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"In OnCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        initialize();
        if(savedInstanceState!=null)
        {
            text = savedInstanceState.getString("text","");
            mInt_view.setText(text);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG,"in onSaveInstanceState()");
        super.onSaveInstanceState(outState);
        outState.putString("text",mInt_view.getText().toString());
    }

    public void initialize()
    {
        Log.d(TAG,"In initialize()");
        mInt_read = (Button)findViewById(R.id.int_read);
        mInt_write = (Button)findViewById(R.id.int_write);
        mInt_edit = (EditText)findViewById(R.id.int_edit);
        mInt_view = (TextView)findViewById(R.id.readint_txt);
    }
    /*Writing text to data.txt in internal memory*/
    public void onWrite(View v)
    {
        Log.d(TAG,"in onWrite()");
        String text = mInt_edit.getText().toString();
        try
        {
            File file = new File(getAlbumStorageDir("Assign"),"data.txt");
            FileWriter out = new FileWriter(file,true);
            out.append(text);
            out.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            Toast.makeText(this,"Text Appended to Data.txt",Toast.LENGTH_SHORT).show();
            mInt_view.setText("");

        }
    }
    /* Returning the internal storage directory*/
    public File getAlbumStorageDir(String name)
    {
        Log.d(TAG,"in getAlbumStorageDir()");
        File file = new File(getFilesDir(),name);
        if(!file.exists())
            if(!file.mkdirs())
            {
                Log.e(TAG,"Directory not created");
            }
        return file;
    }
    /* Reading text from data.txt*/
    public void onRead(View v)
    {
        Log.d(TAG,"in onRead()");
        if(mInt_view.getText().toString().equals("")) {
            File file = new File(getFilesDir(), "Assign");
            if (!file.exists()) {
                mInt_view.setText("Directory does not exist");
            } else {
                File f = new File(file, "data.txt");
                try {

                    BufferedReader buff = new BufferedReader(new FileReader(f));
                    String sentence = "";
                    while ((sentence = buff.readLine()) != null) {
                        mInt_view.append(sentence);
                    }
                } catch (FileNotFoundException e) {
                    mInt_view.setText("File Not Found");
                } catch (IOException e) {
                    mInt_view.setText("Error");
                }
            }
        }
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
