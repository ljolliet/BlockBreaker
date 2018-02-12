package jolliet.louis.ex9;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button sms;
    Button mms;
    Button appel;
    Button web;
    Button map;
    TextView num;
    TextView url;
    TextView longitude;
    TextView latitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sms = findViewById(R.id.SMS);
        mms = findViewById(R.id.MMS);
        appel = findViewById(R.id.Appel);
        web = findViewById(R.id.Web);
        map = findViewById(R.id.Map);
        num = findViewById(R.id.Numero);
        url = findViewById(R.id.EditURL);
        longitude = findViewById(R.id.EditLong);
        latitude = findViewById(R.id.EditLAt);

        sms.setOnClickListener(this);
        mms.setOnClickListener(this);
        appel.setOnClickListener(this);
        web.setOnClickListener(this);
        map.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        System.out.println(view.getId());

        final int a = view.getId();
        String number = num.getText().toString();
        String localisation = latitude.getText().toString()+","+longitude.getText().toString();
        System.out.println(localisation);
        String URL = url.getText().toString();

     switch(view.getId()){
            case R.id.SMS :
                composeSms("", Uri.parse("smsto:" + number));
                break;
            case R.id.MMS :
                composeSms("", Uri.parse("smsto:" + number));
                break;
             case R.id.Appel :
                 phoneCall(Uri.parse("tel:"+number));
                 break;
             case R.id.Web :
                 search("http://"+URL);
                 break;
             case R.id.Map :
                 map(Uri.parse("geo:"+localisation));
                 break;

        }

    }
    public void composeSms(String message, Uri attachement){
        Intent intent = new Intent(Intent.ACTION_SENDTO,attachement);
        intent.putExtra("sms_body",message);
        startActivity(intent);

    }
    public void map(Uri localisation){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(localisation);
        startActivity(intent);
    }
    public void search(String s){
        Uri page = Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(page);
        startActivity(intent);
    }
    public void phoneCall(Uri num){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(num);
        startActivity(intent);


    }
}

