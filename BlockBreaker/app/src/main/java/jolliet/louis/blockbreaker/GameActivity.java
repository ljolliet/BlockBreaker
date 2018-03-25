package jolliet.louis.blockbreaker;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private static final String STARS = "STARS";
    private static final String SCORE = "SCORE";
    private static final String LEVEL = "LEVEL";
    int numStars =1;
    int numColumn = 10;
    int currentNmColumn =10;
    GridView gridview;
    int score = 0;
    TextView scoreTextview;
    Button scoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Intent intent = getIntent();
        if (intent != null) {
            String l = intent.getStringExtra(STARS);
            numStars = Integer.parseInt(l);
            numColumn = 5*numStars;
            currentNmColumn = numColumn;
        }
        gridview = findViewById(R.id.gridview);
        scoreTextview = findViewById(R.id.scoreResult);
        scoreButton = findViewById(R.id.scoreButton);
        gridview.setNumColumns(numColumn);

        final ImageAdapter adapter = new ImageAdapter(this);
        adapter.createArray(numColumn);
        gridview.setAdapter(adapter);

        updateScore();

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                resultClick(position,adapter,0, true);
            }

        });
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, ScoreActivity.class);
                intent.putExtra(SCORE, String.valueOf(score));
                intent.putExtra(LEVEL, String.valueOf(numStars));
                startActivity(intent);
            }
        });
    }

    private void resultClick(int position, ImageAdapter adapter,int num,boolean init) {
        int color = adapter.getColor(position);


        if(color!=0)
            if (init)
            {
                if(!alone(position,adapter))
                    click(position, color, adapter, num);

                else {
                    score -= 100;
                    updateScore();
                }

            }
            else
                click(position, color, adapter,num);


    }


    private void offset(int position,ImageAdapter adapter) {
        if (position % numColumn != numColumn - 1 && position > 0 && position % numColumn != 0) {
            adapter.setColor(position, adapter.getColor(position + 1));
            adapter.setColor(position + 1, 0);
            offset(position - numColumn, adapter);
            adapter.notifyDataSetChanged();
            if (position + 1 >= Math.pow(numColumn, 2) - numColumn && adapter.getColor(position + 1) == 0)
                offset(position + 1, adapter);

          /*  if(position-1 >= Math.pow(numColumn, 2) - numColumn && adapter.getColor(position-1)==0)
                offset(position-1,adapter);*/

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
    private  void click(int position, int color, ImageAdapter adapter, int num){
        adapter.setBlockClicked(position);
        num++;
        if (position % numColumn != 0) {
            if (color == adapter.getColor(position - 1)) {
                resultClick(position - 1, adapter, num, false);
            }
        }
        if (position % numColumn != numColumn - 1) {
            if (color == adapter.getColor(position + 1)) {
                resultClick(position + 1, adapter, num, false);
            }
        }
        if (position > numColumn) {
            if (color == adapter.getColor(position - numColumn)) {
                resultClick(position - numColumn, adapter, num, false);
            }
        }
        if (position < Math.pow(numColumn, 2) - numColumn) {
            if (color == adapter.getColor(position + numColumn)) {
                resultClick(position + numColumn, adapter, num, false);
            }
        }
        gravity(position, adapter);
        if (position >= Math.pow(numColumn, 2) - numColumn && adapter.getColor(position) == 0)
        {
            offset(position, adapter);
            checkOffSet(position, adapter);
        }

            adapter.notifyDataSetChanged();
        score = score+(num*10);
        updateScore();
        if(isFinished(adapter)){
            Toast toast = Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_SHORT);
            toast.show();

        }
    }

    private void checkOffSet(int position, ImageAdapter adapter) {
        if(adapter.getColor(position)==0 && adapter.getColor(position-numColumn)!=0)
            gravity(position,adapter);
        if(adapter.getColor(position)==0 && adapter.getColor(position+1)!=0)
            offset(position,adapter);
    }

    private boolean isFinished(ImageAdapter adapter) {
        for(int i = 0;i<numColumn*numColumn;i++)
            if(!(alone(i,adapter)))
                return false;



        return true;
    }

    private boolean alone(int position, ImageAdapter adapter) {
        if (adapter.getColor(position) != 0) {
            int color = adapter.getColor(position);
            if (position % numColumn != 0) {
                if (color == adapter.getColor(position - 1)) {
                    return false;
                }
            }
            if (position % numColumn != numColumn - 1) {
                if (color == adapter.getColor(position + 1)) {
                    return false;
                }
            }
            if (position > numColumn) {
                if (color == adapter.getColor(position - numColumn)) {
                    return false;
                }
            }
            if (position < Math.pow(numColumn, 2) - numColumn) {
                if (color == adapter.getColor(position + numColumn)) {
                    return false;
                }
            }
        }
        return true;

    }

    private void updateScore(){
        scoreTextview.setText(String.valueOf(score));
    }
}


