package jolliet.louis.blockbreaker;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    private static final String STARS = "STARS";
    Button playButton;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        playButton = findViewById(R.id.buttonPlay);
        ratingBar = findViewById(R.id.ratingBar);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                float a = ratingBar.getRating();
                int b  = Math.round(a);
                intent.putExtra(STARS, String.valueOf(Math.round(a)));
                startActivity(intent);
            }

        });


    }
}
