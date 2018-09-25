package com.example.intentlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    private Button buttonSendMessage;
    private EditText editTextMessage;
    private Button buttonShareMessage;

    public static final String EXTRA_SENT_MESSAGE = "the message";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        wireWidgets();

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text from the edittext
                String message = editTextMessage.getText().toString();
                //create an intent
                //arguments are where you are coming form and where you are going like on a piece of mail
                Intent intentSendMessage = new Intent(SendMessageActivity.this, ReceiveMessageActivity.class);
                //package the text into the intent
                intentSendMessage.putExtra(EXTRA_SENT_MESSAGE, message);
                //start the new activity
                startActivity(intentSendMessage);
            }
        });

        buttonShareMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make an intent with the desired action
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                //set the data type of the stuff we are packaging away
                //look up the type online
                intentShare.setType("text/plain");
                //put the extra wiht the message
                intentShare.putExtra(EXTRA_SENT_MESSAGE, editTextMessage.getText().toString());
                //launch activity
                startActivity(intentShare);
            }
        });
    }

    private void wireWidgets()
    {
        buttonSendMessage = findViewById(R.id.button_sendmessage_send);
        editTextMessage = findViewById(R.id.editText_sendmessage_msg);
        buttonShareMessage = findViewById(R.id.button_sendmessage_share);
    }




//    public void sendMessage(View view)
//    {
//
//
//    }
}
