package com.example.zone;

public class Validate {

    private boolean valid=true;

    protected boolean validateString(String string){
        if(string.isEmpty()){
            valid=false;
        }
        return valid;
    }

}
