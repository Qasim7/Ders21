package com.example.rrahimli.ders21;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.rrahimli.ders21.controller.MessageController;
import com.example.rrahimli.ders21.model.Message;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RecyclerView recyclerView;
    private ArrayList<Message> messages;
    private MessageController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messages = new ArrayList<>();
        editText = findViewById(R.id.edittext_input);
        recyclerView = findViewById(R.id.recycler);

        controller = new MessageController(messages,this);
        recyclerView.setAdapter(controller);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageButton sendButton = findViewById(R.id.button_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = editText.getText().toString();
        //String a = null;  null
        //String b = "";    is empty

        if (message.isEmpty()) {
            Toast.makeText(this, "Get oyanda oyna", Toast.LENGTH_SHORT).show();
            return;
        }
        Message msg = new Message(message,new Date(),true);
        messages.add(msg);
        controller.notifyDataSetChanged();
    }
}
