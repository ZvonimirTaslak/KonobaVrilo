package com.taslak.konobavrilo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    private static final String EMAIL_KONOBA_VRILO="zvonimir.taslak@gmail.com";
    private static final String EMAIL_TITLE="Android KONOBA VRILO";

    private EditText etMailMessage;
    private Button btnSend;

    private static final String TEL_PREF="tel:";
    private TextView tvTelNumb;
    private TextView tvMobNumb;
    private String dialNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        initWidges();
        setuplistener();
    }

    private void initWidges() {
        etMailMessage=(EditText)findViewById(R.id.etMailMessage);
        btnSend=(Button)findViewById(R.id.btnSend);
        tvMobNumb=(TextView)findViewById(R.id.tvMobNumb);
        tvTelNumb=(TextView)findViewById(R.id.tvTelNumb);
    }

    private void setuplistener() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(formOK()){
                    sendEmail(etMailMessage.getText().toString());
                }
            }
        });
        tvTelNumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialNumber=TEL_PREF+tvTelNumb.getText().toString();
                Intent intent= new Intent(Intent.ACTION_DIAL, Uri.parse(dialNumber));
                startActivity(intent);
            }
        });
        tvMobNumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialNumber=TEL_PREF+tvMobNumb.getText().toString();
                Intent intent= new Intent(Intent.ACTION_DIAL, Uri.parse(dialNumber));
                startActivity(intent);
            }
        });

    }

    private void sendEmail( String message) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{EMAIL_KONOBA_VRILO});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, EMAIL_TITLE);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(emailIntent, getString(R.string.choose_application)));

    }

    private boolean formOK() {

        if (etMailMessage.getText().toString().length()==0){
            Toast.makeText(ContactActivity.this, R.string.your_message_is_empty, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }




}
