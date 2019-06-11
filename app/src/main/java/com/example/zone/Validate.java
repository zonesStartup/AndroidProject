package com.example.zone;

import static android.text.TextUtils.isEmpty;

public class Validate {

    private boolean valid=true;

    protected boolean validateString(String string){
        if(isEmpty(string)){
            valid=false;
        }
        return valid;
    }

}
