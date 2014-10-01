package com.example.taylor.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MyActivity extends ActionBarActivity {

    Button button;
    EditText editText;

    public final static String EXTRA_MESSAGE = "com.example.taylor.helloworld.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        button= (Button) findViewById(R.id.button);
        editText= (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("hello You made it");
                editText.setText("hello");
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void clearMessage(View view){
        editText = (EditText) findViewById(R.id.editText);
        editText.setText("");
    }
    public void sendMessage(View view){
         editText = (EditText) findViewById(R.id.editText);
        String typeStr= String.valueOf(editText.getText());
         editText.setText("hello "+typeStr);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = String.valueOf(editText.getText());
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
