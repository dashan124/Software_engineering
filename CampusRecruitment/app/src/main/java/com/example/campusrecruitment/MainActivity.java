package com.example.campusrecruitment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    //private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button alogin =(Button) findViewById(R.id.admin_login_button);
        Button slogin = (Button) findViewById(R.id.student_login_button);
        Button clogin = (Button) findViewById(R.id.company_login_button);
        Button newaccount = (Button) findViewById(R.id.new_account_button);

        alogin.setTranslationX(-1000f);
        slogin.setTranslationX(1000f);
        clogin.setTranslationX(-1000f);
        newaccount.setTranslationX(1000f);
        alogin.animate().translationX(0f).setDuration(600);
        slogin.animate().translationX(0f).setDuration(1200);
        clogin.animate().translationX(0f).setDuration(1800);
        newaccount.animate().translationX(0f).setDuration(2400);
        //mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void goToLogin(View v)
    {
        Intent i = new Intent(this, login.class);
        startActivity(i);
        finish();
    }

    public void goToSignup(View v)
    {
        Intent i = new Intent(this, doSignUp.class);
        startActivity(i);
        finish();
    }
    public void goToCompanyLogin(View v)
    {
        startActivity(new Intent(getApplicationContext(),loginCompany.class));
        finish();
    }

    public void goToAdminLogin(View v)
    {
        startActivity(new Intent(getApplicationContext(),loginAdmin.class));
        finish();
    }
}
