package jolliet.louis.blockbreaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ScoreActivity extends AppCompatActivity {

    private static final String SCORE = "SCORE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();
        if (intent != null) {
            String s = intent.getStringExtra(SCORE);
            System.out.println("_________________________________"+s+"_______________________________");
        }
    }
}
