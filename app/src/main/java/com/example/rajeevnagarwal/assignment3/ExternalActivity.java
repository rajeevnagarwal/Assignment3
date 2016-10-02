package com.example.rajeevnagarwal.assignment3;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class ExternalActivity extends AppCompatActivity {

    Button mExt_read,mExt_write;
    EditText mExt_edit;
    TextView mExt_view;
    static String TAG="ExternalActivity";
    String text="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"In OnCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);
        initialize();
        if(savedInstanceState!=null)
        {
            text = savedInstanceState.getString("text","");
            mExt_view.setText(text);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG,"In onSavedInstanceState()");
        super.onSaveInstanceState(outState);
        outState.putString("text",mExt_view.getText().toString());
    }
    public void initialize()
    {
        Log.d(TAG,"In initialize()");
        mExt_read = (Button)findViewById(R.id.ext_read);
        mExt_write = (Button)findViewById(R.id.ext_write);
        mExt_edit = (EditText)findViewById(R.id.ext_edit);
        mExt_view = (TextView)findViewById(R.id.read_txt);
    }
    /*Writing text to data.txt in external storage*/
    public void onWrite(View v)
    {
        Log.d(TAG,"in onWrite()");
        String text = mExt_edit.getText().toString();
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
            mExt_view.setText("");

        }
    }
    /* Returning the external storage directory*/
    public File getAlbumStorageDir(String name)
    {
        Log.d(TAG,"in getAlbumStorageDir()");
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),name);
        if(!file.exists())
        if(!file.mkdirs())
        {
            Log.e(TAG,"Directory not created");
        }
        return file;
    }
    /* Reading text from data.txt in external storage directory*/
    public void onRead(View v)
    {
        Log.d(TAG,"in onRead()");
        if(mExt_view.getText().toString().equals("")) {
            File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "Assign");
            if (!file.exists()) {
                mExt_view.setText("Directory does not exist");
            } else {
                File f = new File(file, "data.txt");
                try {

                    BufferedReader buff = new BufferedReader(new FileReader(f));
                    String sentence = "";
                    while ((sentence = buff.readLine()) != null) {
                        mExt_view.append(sentence);
                    }
                } catch (FileNotFoundException e) {
                    mExt_view.setText("File Not Found");
                } catch (IOException e) {
                    mExt_view.setText("Error");
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
