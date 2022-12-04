package com.example.degreeplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.FirebaseFirestore;

public class View2 extends AppCompatActivity implements Contract.View2 {

    private Contract.Presenter presenter;
    EditText email, pass;
    String email_str, pass_str;
    TextView mCreateBtn, forgotTextLink;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    int n;

    public String get_email() {
        EditText email = (EditText) findViewById(R.id.Email);
        return email.getText().toString().trim();
    }

    public String get_pass() {
        EditText pass = (EditText) findViewById(R.id.password);
        return pass.getText().toString().trim();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //EditText email = (EditText) findViewById(R.id.Email);

        //EditText pass = (EditText) findViewById(R.id.password);
        //pass.setOnClickListener(this);

        //Button mLoginBtn = (Button) findViewById(R.id.registerBtn);
        //mLoginBtn.setOnClickListener(this);

        //TextView reg = (TextView) findViewById(R.id.createText);
        //reg.setOnClickListener(this);

        //TextView forgotPass = (TextView) findViewById(R.id.forgotpassword);
        //forgotPass.setOnClickListener(this);

        presenter = new Presenter(new Model(), this, 0);
        email = (EditText) findViewById(R.id.Email);
        pass = (EditText) findViewById(R.id.password);
        email_str = email.getText().toString().trim();
        pass_str = pass.getText().toString().trim();
        onClick2();


    }

    public void on(){
        int status = presenter.login(email_str, pass_str);
        int error= presenter.error_msg(email_str, pass_str);
        if (error == 1) {
            if (status==1) {
                //progressBar.setVisibility(View.VISIBLE);
                System.out.println("lllllllllllllllllllllllllll");
                OnSuccess("Successfully logged in");
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                finish();
            } else if (status == 2) {
                OnSuccess("Successfully logged in");
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
//
        } else {
            presenter.error_msg(email_str,pass_str);
        }
    }

    public void onClick2() {

        TextView but2;
        Button but1;
        but1 = findViewById(R.id.registerBtn);
        but2 = findViewById(R.id.createText);

        email_str = email.getText().toString().trim();
        pass_str = pass.getText().toString().trim();
        on();

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_str = email.getText().toString().trim();
                pass_str = pass.getText().toString().trim();
                int status = presenter.login(email_str, pass_str);
                int error= presenter.error_msg(email_str, pass_str);
                if (error == 1) {
                    if (status==1) {
                        //progressBar.setVisibility(View.VISIBLE);
                        System.out.println("lllllllllllllllllllllllllll");
                        OnSuccess("Successfully logged in");
                        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                        finish();
                    } else if (status == 2) {
                        OnSuccess("Successfully logged in");
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
//
                } else {
                    presenter.error_msg(email_str,pass_str);
                }
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Register.class));
                finish();
            }
        });

    }

//    && presenter.ruthere(email)==true


    public void OnSuccess(String successfully_logged_in) {
        Toast.makeText(this,successfully_logged_in, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick() {

    }

    public void OnError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

//    @Override
//    public void onClick(View view) {
//        EditText email = (EditText) findViewById(R.id.Email);
//        EditText pass = (EditText) findViewById(R.id.password);
//
//        String email_str = email.getText().toString().trim();
//
//        String pass_str = pass.getText().toString().trim();
//        int status = presenter.login(email_str, pass_str);
//        int error= presenter.error_msg(email_str, pass_str);
////        startActivity(new Intent(this, MainActivity2.class));
////        finish();
//
//        switch (view.getId()) {
//            case R.id.createText:
//                startActivity(new Intent(this, Register.class));
//                break;
//            case R.id.forgotpassword:
//                startActivity(new Intent(this, AlertDialog.Builder.class));
//                break;
//
//            case R.id.registerBtn:
//
//                if (error == 1) {
//
//                    if (status==1) {
//                        //progressBar.setVisibility(View.VISIBLE);
//                        System.out.println("lllllllllllllllllllllllllll");
//                        OnSuccess("Successfully logged in");
//                        startActivity(new Intent(this, MainActivity2.class));
//                        finish();
//                    } else if (status == 2) {
//                        OnSuccess("Successfully logged in");
//                        startActivity(new Intent(this, MainActivity.class));
//                        finish();
//                    }
////
//                }
//                else {
//                    presenter.error_msg(email_str,pass_str);
//                }
//        }
//    }
}