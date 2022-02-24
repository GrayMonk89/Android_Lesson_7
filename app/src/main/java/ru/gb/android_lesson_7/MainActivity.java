package ru.gb.android_lesson_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            Select_Fragment selectFragment = Select_Fragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.list_of_note, selectFragment).commit();
        }
    }
}