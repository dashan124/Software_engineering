package com.example.campusrecruitment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class loginAdmin extends AppCompatActivity {

    DatabaseHelperAdmin helper = new DatabaseHelperAdmin(loginAdmin.this);
/*    private FirebaseAuth mAuth;
    private DatabaseReference rootRef;*/
    private EditText loginEmailText;
    private EditText loginPasswordText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

//        mAuth = FirebaseAuth.getInstance();
        loginEmailText = (EditText) findViewById(R.id.userEmail);
        loginPasswordText = (EditText) findViewById(R.id.userPassword);
        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginEmail = loginEmailText.getText().toString();
                String loginPassword = loginPasswordText.getText().toString();

                if(loginEmail.isEmpty())
                {
                    loginEmailText.requestFocus();
                    loginEmailText.setError("Email id is required");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(loginEmail).matches())
                {
                    loginEmailText.requestFocus();
                    loginEmailText.setError("Enter a valid email id");
                    return;
                }

                if(loginPassword.isEmpty())
                {
                    loginPasswordText.requestFocus();
                    loginPasswordText.setError("Password is required");
                    return;
                }
                if(loginPassword.length()<6)
                {
                    loginPasswordText.requestFocus();
                    loginPasswordText.setError("Password length must be minimum 6");
                    return;
                }



                String password = helper.searchPassword(loginEmail);
                if(password.equals(loginPassword))
                {
                    /*Intent i = new Intent(login.this, NavBarActivity.class);
                    i.putExtra("EmailId",loginEmail);
*//*                    SharedPreferences prefs = (login.this).getSharedPreferences("com.example.app", Context.MODE_PRIVATE);
                    prefs.edit().putString("EmailId",loginEmail);*//*
                    startActivity(i);
                    finish();*/
                    Intent i = new Intent(loginAdmin.this, AdminNavBarActivity.class);
                    i.putExtra("EmailId",loginEmail);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"password & username doesn't match",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
