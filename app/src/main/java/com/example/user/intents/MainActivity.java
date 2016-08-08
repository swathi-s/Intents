package com.example.user.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("steps","onCreate called");
        setContentView(R.layout.activity_main);

        final Button sendMailBtn = (Button) findViewById(R.id.button);

        sendMailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("events","send Mail button clicked inside listner");
                Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL,"swathi.ehr@gmail.com");
                email.putExtra(Intent.EXTRA_SUBJECT,"test mail");
                email.putExtra(Intent.EXTRA_TEXT,"This is just a test mail");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"select from ..."));
            }
        });

        final Button sendMsgBtn = (Button) findViewById(R.id.button2);
        assert sendMsgBtn != null;
        sendMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("events","send message button is clicked");
                
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("phoneNo", null, "sms message", null, null);

            }
        });
    }


}
