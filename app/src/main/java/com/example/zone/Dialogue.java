package com.example.zone;

import android.app.ProgressDialog;
import android.content.Context;

public class Dialogue {


    private  ProgressDialog progressdialogue;

    protected void showDialogue(Context context){
        if(progressdialogue==null){
            progressdialogue=new ProgressDialog(context);
            progressdialogue.setTitle("loading...");
            progressdialogue.setMessage("please wait...");

        }
        progressdialogue.show();
    }
    protected void dismissProgressDialog() {
        if (progressdialogue != null && progressdialogue.isShowing()) {
            progressdialogue.dismiss();
        }
    }
}
