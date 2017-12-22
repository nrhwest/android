package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.google.android.gms.internal.zzben.NULL;

public class GetUserInfo extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private EditText userName ;
    private EditText userSex ;
    private EditText  userHeight ;
    private EditText userWeight ;
    private EditText  userWorkout;
    private EditText userAge;
    private FirebaseAuth firebaseAuth;
    View focusView = null;
    String name;
    String sex;
    String height;
    String weight;
    String workout;
    String age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_info);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        userName = (EditText) findViewById(R.id.profileName);
        userSex = (EditText) findViewById(R.id.sexText);
        userHeight = (EditText) findViewById(R.id.heightText);
        userWeight = (EditText) findViewById(R.id.weightText);
        userWorkout = (EditText) findViewById(R.id.workoutText);
        userAge = (EditText) findViewById(R.id.ageText);

    }

    public void saveUserInformation(String name, String sex, String age, String height, String weight, String workout ) {



        UserInformation userInformation = new UserInformation(name, sex, height, weight, workout, age);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child("profile info").child(user.getUid()).setValue(userInformation);



    }

    public void doneClick(View view) {

        name = userName.getText().toString();
        sex = userSex.getText().toString();
        height = userHeight.getText().toString();
        weight = userWeight.getText().toString();
        workout = userWorkout.getText().toString();
        age = userAge.getText().toString();

        if (TextUtils.isEmpty(name)) {
            userName.setError(getString(R.string.error_field_required));
            Toast.makeText(GetUserInfo.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
            focusView = userName;
            return;
        }
        if (TextUtils.isEmpty(sex)) {
            userSex.setError(getString(R.string.error_field_required));
            Toast.makeText(GetUserInfo.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
            focusView = userSex;
            return;
        }
        if (TextUtils.isEmpty(age)) {
            userAge.setError(getString(R.string.error_field_required));
            Toast.makeText(GetUserInfo.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
            focusView = userAge;
            return;
        }
        if (TextUtils.isEmpty(height)) {
            userHeight.setError(getString(R.string.error_field_required));
            Toast.makeText(GetUserInfo.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
            focusView = userHeight;
            return;
        }
        if (TextUtils.isEmpty(weight)) {
            userWeight.setError(getString(R.string.error_field_required));
            Toast.makeText(GetUserInfo.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
            focusView = userWeight;
            return;
        }
        if (TextUtils.isEmpty(workout)) {
            userWorkout.setError(getString(R.string.error_field_required));
            Toast.makeText(GetUserInfo.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
            focusView = userWorkout;
            return;
        }
        saveUserInformation(name, sex, age, height, weight, workout);
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);

    }
}
