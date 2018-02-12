package jolliet.louis.ex7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button send;
    EditText editText;
    final String INFO = "info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("__________________"+editText.getText().toString()+"__________________");

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(INFO, editText.getText().toString());
                startActivity(intent);

            }
        });
    }


}
