package com.example.zone;

import android.content.Context;
import android.content.Intent;

public class GoToAny_Activity {

    protected   void Go_to_MainActivity(Context context){
        Intent intent=new Intent(context,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
