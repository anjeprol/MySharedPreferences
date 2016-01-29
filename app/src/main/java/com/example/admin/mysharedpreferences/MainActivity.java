package com.example.admin.mysharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String lTag = "PR_Log";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //SharedPreferences
        SharedPreferences prefs =getSharedPreferences("myPreferences",Context.MODE_PRIVATE);
        String infoCollected = prefs.getString("data", "no data");
        EditText dataFromAct = (EditText) findViewById(R.id.textView);
        dataFromAct.setText(infoCollected);
        Log.d(lTag,"DataCollected->"+infoCollected);
    }

    @Override
    protected void onStop() {
        EditText dataFromAct = (EditText) findViewById(R.id.textView);
        SharedPreferences prefs =getSharedPreferences("myPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("data", dataFromAct.getText().toString());
        editor.commit();
        Log.d(lTag, "DataWrote->" + dataFromAct.getText().toString());
        super.onStop();
    }

    public void close(View view) {
        this.finish();
    }
}
