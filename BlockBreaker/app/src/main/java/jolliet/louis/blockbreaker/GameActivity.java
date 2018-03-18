package jolliet.louis.blockbreaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private static final String STARS = "STARS";
    int numStars =1;
    int numColumn = 10;
    int currentNmColumn =10;
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
            currentNmColumn = numColumn;
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
        if(color!=0) {
            if(position % numColumn != 0) {
                if (color == adapter.getColor(position - 1)) {
                    resultClick(position - 1, adapter);
                }
            }
            if(position % numColumn != numColumn - 1) {
                if (color == adapter.getColor(position + 1)) {
                    resultClick(position + 1, adapter);
                }
            }
            if(position>numColumn) {
                if (color == adapter.getColor(position - numColumn)) {
                    resultClick(position - numColumn, adapter);
                }
            }
            if (position < Math.pow(numColumn, 2) - numColumn) {
                if (color == adapter.getColor(position + numColumn)) {
                    resultClick(position + numColumn, adapter);
                }
            }
            gravity(position, adapter);
            if(position >= Math.pow(numColumn, 2) - numColumn && adapter.getColor(position)==0)
                offset(position,adapter);
            adapter.notifyDataSetChanged();
        }
    }

    private void offset(int position,ImageAdapter adapter) {
        if(position % numColumn != numColumn - 1 && position > 0 && position % numColumn != 0){
            adapter.setColor(position, adapter.getColor(position + 1));
            adapter.setColor(position+1, 0);
            offset(position - numColumn, adapter);
            adapter.notifyDataSetChanged();
            if(position-1 >= Math.pow(numColumn, 2) - numColumn && adapter.getColor(position-1)==0)
                offset(position-1,adapter);
            if(position+1 >= Math.pow(numColumn, 2) - numColumn && adapter.getColor(position+1)==0) {
                offset(position+1,adapter);
            }
        }

    }

    private void gravity(int position,ImageAdapter adapter) {
        if(position<numColumn)
            adapter.setColor(position, 0);
        else{
            adapter.setColor(position,adapter.getColor(position-numColumn));
            gravity(position-numColumn,adapter);
            if(adapter.getColor(position)==0)
                adapter.setColor(position,adapter.getColor(position-numColumn));
        }


    }
}
