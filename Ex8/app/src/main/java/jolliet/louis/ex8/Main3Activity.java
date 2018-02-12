package jolliet.louis.ex8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    final String NAME = "name";
    final String FIRSTNAME = "firstname";
    final String PHONE = "phone";

    Button modify;
    EditText name;
    TextView firstName;
    TextView phone;
    Button ret;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        modify = findViewById(R.id.ModifyM3);
        ret = findViewById(R.id.ReturnM3);
        name = findViewById(R.id.NameM);
        firstName = findViewById(R.id.FirstNameM);
        phone = findViewById(R.id.PhoneM);

        Intent intent = getIntent();

        if (intent != null) {
            name.setText(intent.getStringExtra(NAME));
            firstName.setText(intent.getStringExtra(FIRSTNAME));
            phone.setText(intent.getStringExtra(PHONE));

        }

        modify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                intent.putExtra(NAME, name.getText().toString());
                intent.putExtra(FIRSTNAME, firstName.getText().toString());
                intent.putExtra(PHONE, phone.getText().toString());


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
