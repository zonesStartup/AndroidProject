package com.example.zone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class SignUp2 extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private EditText firstName,lastName,phoneNumber;
    private Spinner location,university,collage;
    private RadioGroup radioGroupGander;
    private Button signUp;
    private Boolean gander;
    private Validate validate = new Validate();
    private UserClass userClass = new UserClass();
    private GoToAny_Activity goToAny_activity =new GoToAny_Activity();
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        phoneNumber = findViewById(R.id.phoneNumber);
        location = findViewById(R.id.spinnerArea);
        university = findViewById(R.id.spinnerUniversity);
        collage = findViewById(R.id.spinnerCollage);
        radioGroupGander = findViewById(R.id.radioGroupGander);
        signUp = findViewById(R.id.signUp);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //adding validation to edit texts
        awesomeValidation.addValidation(this, R.id.firstName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.firstnameerror);
        awesomeValidation.addValidation(this, R.id.lastName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.lastnameerror);
//        awesomeValidation.addValidation(this, R.id.phoneNumber, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);



        radioGroupGander.setOnCheckedChangeListener(this);
        signUp.setOnClickListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        switch (i){
            case R.id.male:
                gander=true;
                break;
            case R.id.female:
                gander=false;
                break;
        }
    }
    @Override
    public void onClick(View view) {

        if(radioGroupGander.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(),"choose your sex",Toast.LENGTH_LONG).show();
        }
        else {
        if(awesomeValidation.validate()) {
            userClass.setUserId(userClass.getCurrentUserId());
            userClass.setFirstName(firstName.getText().toString());
            userClass.setLastName(firstName.getText().toString());
            userClass.setPhoneNumber(phoneNumber.getText().toString());
            userClass.setUserEmail(userClass.getCurrentUserEmail());
            userClass.setLocation(String.valueOf(location.getSelectedItem()));
            userClass.setUniversity(String.valueOf(university.getSelectedItem()));
            userClass.setCollage(String.valueOf(collage.getSelectedItem()));
            userClass.setGender(gander);

            boolean result=userClass.setUser(userClass);
            if (result){
                Toast.makeText(getApplicationContext(),"successfully",Toast.LENGTH_LONG).show();
                goToAny_activity.Go_to_MainActivity(getApplicationContext());
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
            }

        }
        }

    }

}
