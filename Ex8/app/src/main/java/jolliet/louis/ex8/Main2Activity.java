package jolliet.louis.ex8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    final String NUMBER = "num";
    final String CP = "cp";
    final String CITY = "city";
    final String STREET = "street";

    Button modify;
    TextView num;
    TextView cp;
    TextView city;
    TextView street;
    Button ret;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        modify = findViewById(R.id.ModifyM2);
        num = findViewById(R.id.NumM);
        cp = findViewById(R.id.CPM);
        city = findViewById(R.id.CityM);
        street = findViewById(R.id.StreetM);
        ret = findViewById(R.id.ReturnM2);


        Intent intent = getIntent();

        if (intent != null) {
            num.setText(intent.getStringExtra(NUMBER));
            cp.setText(intent.getStringExtra(CP));
            city.setText(intent.getStringExtra(CITY));
            street.setText(intent.getStringExtra(STREET));


        }

        modify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.putExtra(NUMBER, num.getText().toString());
                intent.putExtra(CP, cp.getText().toString());
                intent.putExtra(CITY, city.getText().toString());
                intent.putExtra(STREET, street.getText().toString());


                startActivity(intent);
            }

        });
        ret.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }

        });
    }
}
