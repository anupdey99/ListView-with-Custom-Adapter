package com.adlabsbd.anup.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.EditText;


import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nameET;
    EditText phoneNoET;
    ListView contactsLV;

    String name, phoneNo;

    ArrayList<ContactModel> contactList = new ArrayList<>();
    ContactAdapter adapter;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsLV = (ListView) findViewById(R.id.contactsLVID);
        nameET = (EditText) findViewById(R.id.nameETID);
        phoneNoET = (EditText) findViewById(R.id.phoneETID);

        adapter = new ContactAdapter(getApplicationContext(),contactList);
        contactsLV.setAdapter(adapter);

        contactsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("nameKey",contactList.get(position).getName());
                intent.putExtra("phoneNoKey",contactList.get(position).getPhoneNo());
                intent.putExtra("imageKey",contactList.get(position).getImageID());
                startActivity(intent);
            }
        });

    }

    public void addContact(View view){

        name = nameET.getText().toString();
        phoneNo = phoneNoET.getText().toString();

        if(name.isEmpty()||phoneNo.isEmpty()){
            Toast.makeText(getBaseContext(),"Please input valid info",Toast.LENGTH_SHORT).show();
        }else {

            // object create & store
            ContactModel newContact = new ContactModel(name,phoneNo,R.drawable.man);
            contactList.add(newContact);
            adapter.notifyDataSetChanged();
            nameET.setText("");
            phoneNoET.setText("");

        }


    }

}
