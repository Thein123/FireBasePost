package com.globaldroid.app.myfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button postStatus,showStatus ;

    EditText statusEditText;

    public static final String Firebase_Server_URL = "https://thein-cloud-android.firebaseio.com/";


    String statusString;
    Firebase firebase;

    DatabaseReference databaseReference;

    // Root Database Name for Firebase Database.
    public static final String Database_Path = "thein-cloud-android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postStatus = (Button)findViewById(R.id.post);

      statusEditText = (EditText)findViewById(R.id.mystatus);



        showStatus= (Button)findViewById(R.id.btnstatus);


        Firebase.setAndroidContext(MainActivity.this);

        firebase = new Firebase(Firebase_Server_URL);

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);


        postStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                GetDataFromEditText();
                StatusData statusData = new StatusData(statusString);

                // Adding status text into class function object.


                // Getting the ID from firebase database.
                String statusId = databaseReference.push().getKey();

                // Adding status text using status class object using ID.
                databaseReference.child(statusId).setValue(statusData);

                // Showing Toast message after successfully status post
                Toast.makeText(MainActivity.this,"Status is updated to firebase", Toast.LENGTH_LONG).show();

            }
        });

        showStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ShowStatus.class);
                startActivity(intent);

            }
        });

    }

    public void GetDataFromEditText(){

        statusString = statusEditText.getText().toString().trim();


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
