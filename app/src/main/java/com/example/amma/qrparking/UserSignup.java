package com.example.amma.qrparking;

import android.arch.lifecycle.AndroidViewModel;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class UserSignup extends AppCompatActivity {
    EditText username,password,repass,mob;
    adduser adduser;
    DatabaseReference reff;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
        username = (EditText) findViewById(R.id.email);
        repass = (EditText) findViewById(R.id.repass);
        password = (EditText) findViewById(R.id.pass);
        mob = (EditText) findViewById(R.id.mob);
        final Button login = (Button) findViewById(R.id.lin);
        adduser=new adduser();
        reff= FirebaseDatabase.getInstance().getReference().child("user");




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().length()== 0) {
                    username.setError("Username Required");
                    username.requestFocus();
                }
                else if(password.getText().toString().length()== 0) {
                    password.setError("Password Required");
                    password.requestFocus();
                }
                else if(repass.getText().toString().length()== 0) {
                    repass.setError("Password Required");
                    repass.requestFocus();
                }
                else if(mob.getText().toString().length()== 0) {
                    mob.setError("Password Required");
                    mob.requestFocus();
                }
                else {
                    //if(repass.equals("pass")) {
                    int phonenum = Integer.parseInt(mob.getText().toString().trim());
                    adduser.setUsername(username.getText().toString().trim());
                    adduser.setPassword(password.getText().toString().trim());
                    adduser.setConfirmpass(repass.getText().toString().trim());
                    adduser.setPhonenum(phonenum);
                    reff.push().setValue(adduser);
                    Toast.makeText(getApplicationContext(), "Signed up Successfully", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), UserHome.class);
                    startActivity(i);
                    //}
                    //else{
                    //  Toast.makeText(getApplicationContext(), "Something went wrong Try again later", Toast.LENGTH_LONG).show();
                    // Intent i = new Intent(getApplicationContext(), handler.class);
                    // startActivity(i);
                    //}
                }
            }
        });

    }

    }




