package jolliet.louis.ex7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    final String INFO = "info";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        TextView InfoDisplay = (TextView) findViewById(R.id.textView);

        if (intent != null) {
            InfoDisplay.setText(intent.getStringExtra(INFO));
        }

    }
}
