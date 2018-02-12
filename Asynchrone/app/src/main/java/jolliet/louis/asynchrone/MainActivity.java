package jolliet.louis.asynchrone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button meteo;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meteo = findViewById(R.id.Meteo);
        result = findViewById(R.id.result);

        meteo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String s = "http://www.labri.fr/perso/acasteig/teaching/android/geo.php?city=Talence";
                GetData gt = new GetData();
                try {
                    String jsonData = gt.execute(s).get();
                    result.setText(jsonData);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
