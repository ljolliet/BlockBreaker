package jolliet.louis.code_barre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Bitmap;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    private static final String STATE_YEAR = "YEAR";
    private static final String STATE_TITLE = "TITLE";
    private static final String STATE_AUTEUR = "AUTEUR";
    private static final String STATE_LANG = "LANG";
    private static final String STATE_COVER = "COVER";
    private static final String STATE_EDITOR = "EDIT";
    private static final String STATE_ASIN = "ASIN";
    private static final String STATE_COL = "COL";


    Button scan;
    TextView titre;
    TextView annee;
    TextView auteurs;
    TextView langue;
    TextView editeur;
    TextView collection;
    TextView asin;
    ImageView cover;
    Spinner spinner;

    String url;
    List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = "";
        list = new ArrayList();
        list.add("Livres");

        scan = findViewById(R.id.Scan);
        titre = findViewById(R.id.TitreValue);
        annee = findViewById(R.id.AnneeValue);
        langue = findViewById(R.id.LangueValue);
        cover = findViewById(R.id.Cover);
        editeur = findViewById(R.id.EditeurValue);
        auteurs = findViewById(R.id.AuteurValue);
        collection = findViewById(R.id.CollectionValue);
        asin = findViewById(R.id.AsinValue);
        spinner = findViewById(R.id.Spinner);
        final MainActivity that = this;


        ArrayAdapter<String> adaptater = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        adaptater.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adaptater);

        scan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new IntentIntegrator(that).initiateScan();

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                GetData gt = new GetData();
                //String s = "https://www.googleapis.com/books/v1/volumes?q=isbn:"+result.getContents();
                String s = "https://www.googleapis.com/books/v1/volumes?q=isbn:9787508508405";
                String jsonData = null;
                try {
                    jsonData = gt.execute(s).get();
                    parseJson(jsonData);

                } catch (InterruptedException | JSONException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void parseJson(String jsonData) throws JSONException, ExecutionException, InterruptedException {
        JSONObject obj = new JSONObject(jsonData);
        JSONArray items = obj.getJSONArray("items");
        JSONObject  item = items.getJSONObject(0);
        JSONObject volumeInfo =item.getJSONObject("volumeInfo");
        String title = volumeInfo.getString("title");
        titre.setText(title);

        String publisher = volumeInfo.getString("publisher");
        editeur.setText(publisher);

        String colection = volumeInfo.getString("collection");
        collection.setText(colection);

        String ASIN = volumeInfo.getString("ASIN");
        asin.setText(ASIN);

        String language = volumeInfo.getString("language");
        langue.setText(language);

        JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
        String Cover = imageLinks.getString("thumbnail");

        GetBookCover gc = new GetBookCover();
        url = Cover;
        cover.setImageBitmap(gc.execute(Cover).get());

        String publishedDate = volumeInfo.getString("publishedDate");
        annee.setText(publishedDate);

        JSONArray authors = volumeInfo.getJSONArray("authors");
        ArrayList<String> listdata = new ArrayList<>();
        if (authors != null) {
            for (int i=0;i<authors.length();i++){
                listdata.add(authors.getString(i));
            }
        }
        String finalAuthors ="";
        for(String a : listdata)
            if(finalAuthors!="")
                finalAuthors= finalAuthors+","+a;

        auteurs.setText(finalAuthors);








    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        // Save the user's current game state
        savedInstanceState.putString(STATE_YEAR, annee.getText().toString());
        savedInstanceState.putString(STATE_LANG, langue.getText().toString());
        savedInstanceState.putString(STATE_ASIN, asin.getText().toString());
        savedInstanceState.putString(STATE_COL, collection.getText().toString());
        savedInstanceState.putString(STATE_TITLE, titre.getText().toString());
        savedInstanceState.putString(STATE_AUTEUR, auteurs.getText().toString());
        savedInstanceState.putString(STATE_EDITOR, editeur.getText().toString());
        savedInstanceState.putString(STATE_COVER, url);


        // Always call the superclass so it can save the view hierarchy state
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);


        // Restore state members from saved instance
        editeur.setText(savedInstanceState.getString(STATE_EDITOR));
        annee.setText(savedInstanceState.getString(STATE_YEAR));
        collection.setText(savedInstanceState.getString(STATE_COL));
        asin.setText(savedInstanceState.getString(STATE_ASIN));
        titre.setText(savedInstanceState.getString(STATE_TITLE));
        langue.setText(savedInstanceState.getString(STATE_LANG));
        auteurs.setText(savedInstanceState.getString(STATE_AUTEUR));
        String urlState = savedInstanceState.getString(STATE_COVER);
        GetBookCover gc = new GetBookCover();
        try {
            cover.setImageBitmap(gc.execute(urlState).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        url = urlState;

    }


}
