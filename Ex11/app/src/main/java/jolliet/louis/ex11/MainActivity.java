package jolliet.louis.ex11;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_OPEN = 1;
    private static final int FLIP_VERTICAL = 1;
    private static final int FLIP_HORIZONTAL =2;

    boolean alreadyFlipH;
    boolean alreadyFlipV;

    Button search;
    Button flipH;
    Button flipV;
    Uri imageUri;
    Bitmap imageBitmap;
    ImageView imageView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alreadyFlipH=false;
        alreadyFlipV=false;

        search = findViewById(R.id.button);
        flipH = findViewById(R.id.flipH);
        flipV = findViewById(R.id.flipV);
        imageView = findViewById(R.id.imageView);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });
        flipH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageBitmap= flipImage(imageBitmap, FLIP_HORIZONTAL);
                imageView.setImageBitmap(imageBitmap);


            }
        });
        flipV.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View view) {
                imageBitmap= flipImage(imageBitmap, FLIP_VERTICAL);
                imageView.setImageBitmap(imageBitmap);

            }
        });
    }

    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_IMAGE_OPEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_IMAGE_OPEN && resultCode == RESULT_OK) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri );
            try {
                imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
    public Bitmap flipImage(Bitmap src, int type) {
        Matrix matrix = new Matrix();
        if(type == FLIP_VERTICAL) {
                 matrix.preScale(1.0f, -1.0f);
        }
        else if(type == FLIP_HORIZONTAL) {
                matrix.preScale(-1.0f, 1.0f);
        } else {
            return null;
        }
        return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
    }

}
