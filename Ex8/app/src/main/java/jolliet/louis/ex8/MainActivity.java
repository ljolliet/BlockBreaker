package jolliet.louis.ex8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String NAME = "name";
    final String FIRSTNAME = "firstname";
    final String PHONE = "phone";
    final String NUMBER = "num";
    final String CP = "cp";
    final String CITY = "city";
    final String STREET = "street";

    Button modify1;
    Button modify2;
    TextView name;
    TextView firstName;
    TextView phone;
    TextView num;
    TextView cp;
    TextView city;
    TextView street;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modify1 = findViewById(R.id.Modify1);
        name = findViewById(R.id.Name);
        firstName = findViewById(R.id.FirstName);
        phone = findViewById(R.id.PhoneNumber);
        modify2 = findViewById(R.id.Modify2);
        num = findViewById(R.id.Num);
        cp = findViewById(R.id.CP);
        city = findViewById(R.id.City);
        street = findViewById(R.id.Street);




        Intent intent = getIntent();

        if (intent != null) {
            name.setText(intent.getStringExtra(NAME));
            firstName.setText(intent.getStringExtra(FIRSTNAME));
            phone.setText(intent.getStringExtra(PHONE));
            num.setText(intent.getStringExtra(NUMBER));
            cp.setText(intent.getStringExtra(CP));
            city.setText(intent.getStringExtra(CITY));
            street.setText(intent.getStringExtra(STREET));

        }


        modify1.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                                           intent.putExtra(NAME, name.getText().toString());
                                           intent.putExtra(FIRSTNAME, firstName.getText().toString());
                                           intent.putExtra(PHONE, phone.getText().toString());


                                           startActivity(intent);

                                       }
                                   });

        modify2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            intent.putExtra(NUMBER, num.getText().toString());
                            intent.putExtra(CP, cp.getText().toString());
                            intent.putExtra(CITY, city.getText().toString());
                            intent.putExtra(STREET, street.getText().toString());

                            startActivity(intent);

                        }
                    });
        }

}
