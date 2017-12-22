package com.cmsc355.ccnd.gymrat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    View focusView = null;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void registerUser() {
        email = (EditText) findViewById(R.id.emailText);
        password = (EditText) findViewById(R.id.passwordText);

        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        //Check is Email is empty
        if (TextUtils.isEmpty(userEmail)) {
            email.setError(getString(R.string.error_invalid_email));
            focusView = email;
            return;
        }
        //Check if Pasword is Empty
        if (TextUtils.isEmpty(userPassword) ||  (userPassword.length() < 6 )  ) {
            password.setError(getString(R.string.error_invalid_password));
            focusView = password;
            return;
        }

        progressDialog.setMessage("Registering Please Wait!");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() ) {
                            progressDialog.dismiss();

                            final Intent goToInfoGather = new Intent(RegisterActivity.this, GetUserInfo.class);
                                startActivity(goToInfoGather);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Registration Failed, Please Try agian!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    public void signUpClick(View view) {
        registerUser();

    }

}
