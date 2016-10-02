package com.example.rajeevnagarwal.assignment3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sqlitedb extends AppCompatActivity {

    Button mAdd_button,mUpdate_button,mDelete_button,mPrint_button;
    static String TAG="Sqlitedb";
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlitedb);
        Log.d(TAG,"In onCreate()");
        initialize();
    }
    public void initialize()
    {
        Log.d(TAG,"In initialize()");
        mAdd_button = (Button)findViewById(R.id.addp);
        mUpdate_button = (Button)findViewById(R.id.updatep);
        mDelete_button = (Button)findViewById(R.id.deletep);
        mPrint_button = (Button)findViewById(R.id.printp);
    }
    // This function will create a dialog box to add new entry into the table
    public void addP(View v)
    {
        Log.d(TAG,"in addP()");
        LayoutInflater li = LayoutInflater.from(Sqlitedb.this);
        View promptview = li.inflate(R.layout.addperson_view, null);
        AlertDialog.Builder form = new AlertDialog.Builder(this);
        form.setTitle("Enter your Details");
        form.setView(promptview);
        final EditText first_text = (EditText)promptview.findViewById(R.id.first_edit);
        final EditText last_text = (EditText)promptview.findViewById(R.id.last_edit);
        form.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface arg0,int arg1){
                if(first_text.length()>0&&last_text.length()>0)
                {
                    db.addPerson(first_text.getText().toString(),last_text.getText().toString());
                    Toast.makeText(getApplicationContext(),"Record added successfully in table",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Record insertion failed",Toast.LENGTH_SHORT).show();
                }

            }
        });
        AlertDialog dialog = form.create();
        dialog.show();
    }
    // This function will create a dialog box to update an existing entry into the table
    public void updateP(View v)
    {
        Log.d(TAG,"in updateP()");
        LayoutInflater li = LayoutInflater.from(Sqlitedb.this);
        View promptview = li.inflate(R.layout.updateperson_view, null);
        AlertDialog.Builder form = new AlertDialog.Builder(this);
        form.setTitle("Enter Details");
        form.setView(promptview);
        final EditText id_text = (EditText)promptview.findViewById(R.id.uid);
        final EditText last_text = (EditText)promptview.findViewById(R.id.ulast);
        final EditText first_text = (EditText)promptview.findViewById(R.id.ufirst);
        form.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface arg0,int arg1){
                if(first_text.length()>0&&last_text.length()>0&&id_text.length()>0)
                {
                    db.updatePerson(Integer.parseInt(id_text.getText().toString()),first_text.getText().toString(),last_text.getText().toString());
                    Toast.makeText(getApplicationContext(),"Modification Successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Modification failed",Toast.LENGTH_SHORT).show();
                }

            }
        });
        AlertDialog dialog = form.create();
        dialog.show();
    }
    // This function will create a dialog box to delete an existing entry into the table
    public void deleteP(View v)
    {
        Log.d(TAG,"in deleteP()");
        LayoutInflater li = LayoutInflater.from(Sqlitedb.this);
        View promptview = li.inflate(R.layout.deleteperson_view, null);
        AlertDialog.Builder form = new AlertDialog.Builder(this);
        form.setTitle("Enter Details");
        form.setView(promptview);
        final EditText did = (EditText)promptview.findViewById(R.id.did);
        form.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface arg0,int arg1){
                if(did.getText().length()>0)
                {
                    db.deletePerson(Integer.parseInt(did.getText().toString()));
                    Toast.makeText(getApplicationContext(),"Deletion Successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Deletion failed",Toast.LENGTH_SHORT).show();
                }

            }
        });
        AlertDialog dialog = form.create();
        dialog.show();
    }
    // This function will create a dialog box to print all the records in the table
    public void printP(View v)
    {
        Log.d(TAG,"in printP()");
        LayoutInflater li = LayoutInflater.from(Sqlitedb.this);
        View promptview = li.inflate(R.layout.records_view, null);
        AlertDialog.Builder form = new AlertDialog.Builder(this);
        form.setTitle("Records in Table: Person");
        form.setView(promptview);
        final TextView records_text = (TextView)promptview.findViewById(R.id.records_view);
        records_text.setText(db.print());
        form.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface arg0,int arg1){

            }
        });
        AlertDialog dialog = form.create();
        dialog.show();

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
