package jolliet.louis.blockbreaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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
        final ImageAdapter adapter = new ImageAdapter(this);
        adapter.createArray(numColumn);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GameActivity.this, "" + position,Toast.LENGTH_SHORT).show();
                resultClick(position,adapter);
            }

        });
    }

    private void resultClick(int position, ImageAdapter adapter) {
        System.out.println("_____________________________________________________________"+position+"_____________________________________________________________");
        int color = adapter.getColor(position);
        adapter.setBlockClicked(position);
        if(color==adapter.getColor(position-1)) {
            resultClick(position-1,adapter);
        }
        else if(color==adapter.getColor(position+1)) {
            resultClick(position+1,adapter);
        }
        else if(color==adapter.getColor(position-numColumn)) {
            resultClick(position-numColumn,adapter);
        }
        else if(color==adapter.getColor(position+numColumn)) {
            resultClick(position+numColumn,adapter);
        }
    }
}
