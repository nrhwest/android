package com.cmsc355.ccnd.gymrat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class MyProfile extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myRef;
    private TextView userName;
    private TextView userSex;
    private TextView userWeight;
    private TextView userHeight;
    private TextView favWorkout;
    private TextView userAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();
        userName = (TextView) findViewById(R.id.Name);
        userSex = (TextView) findViewById(R.id.Gender);
        userWeight = (TextView) findViewById(R.id.Height);
        userHeight = (TextView) findViewById(R.id.Weight);
        favWorkout = (TextView) findViewById(R.id.FavoriteWorkout);
        userAge = (TextView) findViewById(R.id.Age);
    }




    public void editClick(View view) {

        Intent intent = new Intent(this, GetUserInfo.class);
        startActivity(intent);
    }


    public void logoutClick(View view) {
        firebaseAuth.signOut();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);


    }

    @Override
    protected void onStart() {
        super.onStart();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                String userId = firebaseUser.getUid();
                UserInformation user = new UserInformation();
                user.setProfileName(dataSnapshot.child("profile info").child(userId).getValue(UserInformation.class).getProfileName());
                String profileName = user.getProfileName();
                userName.setText(profileName);
                user.setUserHeight(dataSnapshot.child("profile info").child(userId).getValue(UserInformation.class).getUserHeight());
                user.setUserWeight(dataSnapshot.child("profile info").child(userId).getValue(UserInformation.class).getUserWeight());
                user.setUserSex(dataSnapshot.child("profile info").child(userId).getValue(UserInformation.class).getUserSex());
                user.setWorkout(dataSnapshot.child("profile info").child(userId).getValue(UserInformation.class).getWorkout());
                user.setUserAge(dataSnapshot.child("profile info").child(userId).getValue(UserInformation.class).getUserAge());
                String age = user.getUserAge();
                age = age + " Years Old";
                userAge.setText(age);
                String gender = user.getUserSex();
                gender = "Gender: " + gender;
                userSex.setText(gender);
                String height = user.getUserHeight();
                height = "Height: " + height;
                userHeight.setText(height);
                String weight = user.getUserWeight();
                weight = "Weight: " + weight;
                userWeight.setText(weight);
                String workout = user.getWorkout();
                workout = "Favorite workout: " + workout;
                favWorkout.setText(workout);





            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });
    }
}
