package jolliet.louis.code_barre;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.graphics.Bitmap;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by loulou on 05/03/18.
 */

public class GetBookCover extends AsyncTask<String, String, Bitmap>{




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

