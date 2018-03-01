package jolliet.louis.asynchrone;

import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.graphics.Bitmap;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.*;

public class MainActivity extends AppCompatActivity {

    Button search;
    Button delete;
    Spinner spinner;
    TextView temperature;
    TextView description;
    ImageView icon;

    EditText ville;
    List<String> list = new ArrayList<String>();

    Date d = new Date();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add("Bordeaux");

        SharedPreferences settings = getSharedPreferences("PREF", 0);
        int id=0;
        while(settings.getString("key"+id, null)!=null){
            list.add(settings.getString("key"+id, null));
            id++;
        }


        search = findViewById(R.id.Search);
        temperature = findViewById(R.id.Temperature);
        description = findViewById(R.id.Description);
        icon = findViewById(R.id.Icon);
        ville = findViewById(R.id.Ville);
        spinner = findViewById(R.id.Spinner);
        delete = findViewById(R.id.Delete);

        ArrayAdapter<String> adaptater = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        adaptater.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adaptater);

        search.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(ville.getText()!=null) {
                    String s = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=ce2bf8939d8348009e1151408182402&q=" + ville.getText()+"&format=json&num_of_days=1&date="+d.getYear()+"-"+d.getMonth()+"-"+d.getDay();
                    if(!list.contains(ville.getText().toString()))
                        list.add(ville.getText().toString());
                    GetData gt = new GetData();
                    try {
                        String jsonData = gt.execute(s).get();
                        parseJson(jsonData);
                    } catch (InterruptedException | ExecutionException | JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            private void parseJson(String jsonData) throws JSONException {
                JSONObject obj = new JSONObject(jsonData);
                JSONObject data = obj.getJSONObject("data");
                JSONArray currentOCnditionArray = data.getJSONArray("current_condition");
                JSONObject  currentCondition = currentOCnditionArray.getJSONObject(0);
                String t =currentCondition.getString("temp_C");

                JSONArray descArray=currentCondition.getJSONArray("weatherDesc");
                JSONObject desc = descArray.getJSONObject(0);
                String descValue = desc.getString("value");

                JSONArray iconArray=currentCondition.getJSONArray("weatherIconUrl");
                JSONObject  iconjson = iconArray.getJSONObject(0);
                String iconValue = iconjson.getString("value");

                getIcon gi = new getIcon();
                try {
                    icon.setImageBitmap(gi.execute(iconValue).get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }


                temperature.setText("Température : " + t +"°C");
                description.setText("Description : " + descValue);

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ville.setText(spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        delete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                list.clear();
            }
        });
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
