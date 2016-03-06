package com.adlabsbd.anup.contacts;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    ImageView profileImage;
    TextView profileName,profilePhoneNo;

    ImageButton callBtn,msgBtn;
    String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        profileImage = (ImageView) findViewById(R.id.contactDetailImgID);
        profileName = (TextView) findViewById(R.id.contactDetailNameID);
        profilePhoneNo = (TextView) findViewById(R.id.contactDetailPhoneID);
        callBtn = (ImageButton) findViewById(R.id.callBtnID);
        msgBtn = (ImageButton) findViewById(R.id.msgBtnID);

        profileImage.setImageResource(getIntent().getIntExtra("imageKey", 0));
        profileName.setText(getIntent().getStringExtra("nameKey"));
        phoneNo = getIntent().getStringExtra("phoneNoKey");
        profilePhoneNo.setText(phoneNo);


    }

    public void callNumber(View view){
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNo));
        startActivity(callIntent);

    }

    public void msgNumber(View view){
        Intent msgIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + phoneNo));
        startActivity(msgIntent);
    }
}
