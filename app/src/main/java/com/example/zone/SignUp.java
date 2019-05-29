package com.example.zone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private UserClass user= new UserClass();
    private Validate validate = new Validate();
    private Dialogue dialogue=new Dialogue();
    private GoToAny_Activity goToAny_activity= new GoToAny_Activity();
    private EditText Email,Password;
    private Button btSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.password);
        btSignUp = findViewById(R.id.SignUp);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogue.showDialogue(SignUp.this);
                if (validate.validateString(Email.getText().toString().trim())==false){
                    dialogue.dismissProgressDialog();
                    Email.setError("Email is Empty");
                }
                if (validate.validateString(Password.getText().toString().trim())==false){
                    dialogue.dismissProgressDialog();
                    Password.setError("Password is Empty");
                }
                else if (Password.getText().toString().length()<8){
                    dialogue.dismissProgressDialog();
                    Password.setError("Password is short");
                }
                else {
                    boolean result = user.SignUpWithEmailAndPassword(Email.getText().toString(), Password.getText().toString());
                    if (result) {
                        dialogue.dismissProgressDialog();
                        Toast.makeText(SignUp.this, "createUserWithEmail:success", Toast.LENGTH_LONG).show();
                         goToAny_activity.Go_to_MainActivity(SignUp.this);
                        finish();
                    } else {
                        dialogue.dismissProgressDialog();
                        Toast.makeText(SignUp.this, "createUserWithEmail:failure", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(user.getCurrentUser()==true){
            goToAny_activity.Go_to_MainActivity(getApplicationContext());
            finish();
        }
    }
}
