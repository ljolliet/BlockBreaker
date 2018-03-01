package jolliet.louis.asynchrone;


import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.graphics.Bitmap;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


/**
 * Created by loulou on 26/02/18.
 */

public class getIcon extends AsyncTask<String, String, Bitmap>{

ImageView image;

    protected Bitmap doInBackground(String... uri) {
        Bitmap imageBitmap = null;
        try {
            InputStream is = new URL(uri[0]).openStream();
            imageBitmap = BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageBitmap;
    }
    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
    }
}
