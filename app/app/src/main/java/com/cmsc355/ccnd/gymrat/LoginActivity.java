package com.cmsc355.ccnd.gymrat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;

import android.text.TextUtils;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



import static android.Manifest.permission.READ_CONTACTS;

/*
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    /*
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;


    private static final String[] DUMMY_CREDENTIALS = new String[]{
      "jim@rat.com:workout", "j@r.com:12345"
    };

    // UI references.
    private EditText myEmailView;
    private EditText myPasswordView;
    private View myProgressView;
    private View myLoginFormView;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        myEmailView = (EditText) findViewById(R.id.email);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);


        Button myEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        myEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        myLoginFormView = findViewById(R.id.login_form);
        myProgressView = findViewById(R.id.login_progress);

        final Button signUpBtn = (Button) findViewById(R.id.sign_up_button);
        final Intent goToSignUp = new Intent(LoginActivity.this, RegisterActivity.class);
        signUpBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(goToSignUp);
            }
        });
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        EditText userEmail = (EditText) findViewById(R.id.email);
        EditText userPassword = (EditText) findViewById(R.id.password);


        // Store values at the time of the login attempt.
        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            myPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = myPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            myEmailView.setError(getString(R.string.error_field_required));
            focusView = myEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            myEmailView.setError(getString(R.string.error_invalid_email));
            focusView = myEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt
            progressDialog.setMessage("Logging In Please Wait!");
            progressDialog.show();

            firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful() ) {

                                finish();
                                final Intent goToHomeScreen = new Intent(LoginActivity.this, HomeScreen.class);
                                startActivity(goToHomeScreen);
                            } else {
                                Toast.makeText(LoginActivity.this, "Login Failed, Please Try agian!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


}


