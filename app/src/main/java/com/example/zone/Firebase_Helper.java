package com.example.zone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Firebase_Helper {

    private String TAG;
    private boolean result;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public FirebaseUser currentUser = mAuth.getCurrentUser();
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference usersRef = ref.child("Users");


    //Create new User
    public boolean SignUpWithEmailAndPassword (String email, String password){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                           result = true;
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            //Toast.makeText(context.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                           result = false;
                        }

                        // ...
                    }
                });
        return result;
    }

    // sign In With Email And Password
    public boolean signInWithEmailAndPassword(String email,String password){

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
        return true;
    }

    public boolean setUser(UserClass userClass){
        if (userClass!=null){
            // Creating a HashMap For User
            Map<String, String> user = new HashMap<>();

            // Adding key-value pairs to a HashMap
            user.put("FirstName", userClass.getFirstName());
            user.put("LastName", userClass.getLastName());
            user.put("Email", userClass.getUserEmail());
            user.put("Phone", userClass.getPhoneNumber());
            user.put("YourArea", userClass.getLocation());
            user.put("University", userClass.getUniversity());
            user.put("Collage", userClass.getCollage());
            if (userClass.isGender()==true){
                user.put("Gander", "true");
            }
            else {
                user.put("Gander", "false");
            }
            usersRef.child(userClass.getUserId()).setValue(user);
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }


}
