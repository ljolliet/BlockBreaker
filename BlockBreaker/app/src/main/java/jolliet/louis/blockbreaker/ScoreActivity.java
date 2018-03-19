package jolliet.louis.blockbreaker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    private static final String SCORE = "SCORE";
    private ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();
        if (intent != null) {
            String s = intent.getStringExtra(SCORE);
            list.add(s);
            System.out.println("_________________________________"+s+"_______________________________");
        }

        SharedPreferences settings = getSharedPreferences("PREF", 0);
        int id=0;
        while(settings.getString("key"+id, null)!=null){
            list.add(settings.getString("key"+id, null));
            id++;
        }
    }
    @Override
    protected void onStop() {

        super.onStop();


        SharedPreferences settings = getSharedPreferences("PREF", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        for(int i=0;i<list.size();i++)
            editor.putString("key"+i, list.get(i));

        editor.commit();
    }

}
