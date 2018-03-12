package jolliet.louis.blockbreaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private static final String STARS = "STARS";
    int numStars =1;
    int numColumn = 5;
    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        if (intent != null) {
            String l = intent.getStringExtra(STARS);
            numStars = Integer.parseInt(l);
            numColumn = 5*numStars;
        }
        gridview = findViewById(R.id.gridview);
        gridview.setNumColumns(numColumn);
        final ImageAdapter adaptater = new ImageAdapter(this);
        adaptater.createArray(numColumn);
        gridview.setAdapter(adaptater);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GameActivity.this, "" + position,Toast.LENGTH_SHORT).show();
                adaptater.setBlockClicked(position);
            }

        });
    }
}
