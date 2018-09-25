package com.example.intentlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReceiveMessageActivity extends AppCompatActivity {

    private TextView textViewDisplayMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        wireWidgets();

        textViewDisplayMessage.setText(getIntent().getStringExtra(SendMessageActivity.EXTRA_SENT_MESSAGE));
    }

    private void wireWidgets()
    {
        textViewDisplayMessage = findViewById(R.id.textView_receivemessage_displaymessage);
    }
}
