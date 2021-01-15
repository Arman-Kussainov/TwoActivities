package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;


    private TextView FirstPassage;
    private TextView SecondPassage;
    private TextView ThirdPassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

        Intent intent_scroll = getIntent();
        message = intent_scroll.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView = findViewById(R.id.text_message);
        textView.setText(message);

        int button_number = 0;

        try {
            button_number = Integer.parseInt(message);
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

        if(button_number==1){
            FirstPassage = findViewById(R.id.textView_1);
            FirstPassage.setVisibility(View.VISIBLE);
        }
        if(button_number==2){
            SecondPassage = findViewById(R.id.textView_2);
            SecondPassage.setVisibility(View.VISIBLE);
        }
        if(button_number==3){
            ThirdPassage = findViewById(R.id.textView_3);
            ThirdPassage.setVisibility(View.VISIBLE);
        }
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}