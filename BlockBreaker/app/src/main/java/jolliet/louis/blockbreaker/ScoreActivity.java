package jolliet.louis.blockbreaker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreActivity extends AppCompatActivity {

    private static final String SCORE = "SCORE";
    private static final String LEVEL = "LEVEL";
    private ArrayList<String> currentList = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> levelScores = new ArrayList<>();
    ListView listview;
    String[] num = new String[]{"1st - ", "2nd - ", "3rd - ", "4th - ", "5th - "};
    int nbScore =5;
    int numLevel = 5;
    int level;
    TextView levelTextview;
    Button returnButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        listview = findViewById(R.id.listView);
        levelTextview = findViewById(R.id.LevelTextview);
        returnButton = findViewById(R.id.Return);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ScoreActivity.this,
                android.R.layout.simple_list_item_1, currentList);
        listview.setAdapter(adapter);

        for(int i=0;i<=numLevel;i++)
            levelScores.add(new ArrayList<Integer>());
        for(ArrayList a : levelScores)
            for(int i = 0;i<numLevel;i++)
                a.add(0);






        Intent intent = getIntent();
        if (intent != null) {
            String s = intent.getStringExtra(SCORE);
            level = Integer.parseInt(intent.getStringExtra(LEVEL));
            levelScores.get(level).add(Integer.valueOf(s));
        }
        levelTextview.setText(levelTextview.getText()+" "+level);




        SharedPreferences settings = getSharedPreferences("PREF", 0);
        int id=0;
        int allLevel =1;
        while(settings.getString(allLevel+"key"+id, null)!=null){
            levelScores.get(allLevel).add(Integer.valueOf(settings.getString(allLevel+"key"+id, null)));
            id++;
            if(allLevel<numLevel)
                allLevel++;
            else
                break;
        }

        Collections.sort(levelScores.get(level));
        Collections.reverse(levelScores.get(level));
        for(int i=0;i<nbScore;i++)
        {
            currentList.add(num[i]+ levelScores.get(level).get(i));

        }

    }
    @Override
    protected void onStop() {

        super.onStop();
        save();
    }

    private void save() {
        SharedPreferences settings = getSharedPreferences("PREF", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        for(int j = 1; j<=numLevel;j++)
            for(int i=0;i<nbScore;i++)
                editor.putString(j+"key"+i, String.valueOf(levelScores.get(j).get(i)));
        editor.commit();
    }

}
