package jolliet.louis.ex11;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_OPEN = 1;
    private static final int FLIP_VERTICAL = 1;
    private static final int FLIP_HORIZONTAL = 2;

    LinearLayout layout;

    Uri imageUri;
    Bitmap imageBitmap;
    ImageView imageView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContextMenu(v);
            }
        });
        registerForContextMenu(layout);



        imageView = findViewById(R.id.imageView);

    }

    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_IMAGE_OPEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_OPEN && resultCode == RESULT_OK) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
            try {
                imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    //SOURCZ : https://stackoverflow.com/questions/29061523/android-flip-imageview-vertically

    public Bitmap flipImage(Bitmap src, int type) {
        if (src != null) {
            Matrix matrix = new Matrix();
            if (type == FLIP_VERTICAL) {
                matrix.preScale(1.0f, -1.0f);
            } else if (type == FLIP_HORIZONTAL) {
                matrix.preScale(-1.0f, 1.0f);
            } else {
                return null;
            }
            return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
        }

        return null;
    }

    // SOURCE : http://android-er.blogspot.fr/2015/02/invert-bitmap-using-colormatrix.html

    public Bitmap createInvertedBitmap(Bitmap src) {
        if (src != null) {
            ColorMatrix colorMatrix_Inverted =
                    new ColorMatrix(new float[]{
                            -1, 0, 0, 0, 255,
                            0, -1, 0, 0, 255,
                            0, 0, -1, 0, 255,
                            0, 0, 0, 1, 0});

            ColorFilter ColorFilter_Sepia = new ColorMatrixColorFilter(
                    colorMatrix_Inverted);

            Bitmap bitmap = Bitmap.createBitmap(src.getWidth(), src.getHeight(),
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);

            Paint paint = new Paint();

            paint.setColorFilter(ColorFilter_Sepia);
            canvas.drawBitmap(src, 0, 0, paint);

            return bitmap;
        }
        return null;
    }

    //SOURCE : http://android-code-space.blogspot.fr/2010/08/convert-image-to-black-and-white.html
    public Bitmap ConvertToBlackAndWhite(Bitmap src){
        if (src != null) {
            ColorMatrix bwMatrix = new ColorMatrix();
            bwMatrix.setSaturation(0);
            final ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(bwMatrix);

            Bitmap rBitmap = src.copy(Bitmap.Config.ARGB_8888, true);
            Paint paint = new Paint();
            paint.setColorFilter(colorFilter);
            Canvas myCanvas = new Canvas(rBitmap);
            myCanvas.drawBitmap(rBitmap, 0, 0, paint);

            return rBitmap;
        }
        return null;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View vue, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, vue, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu, menu);
        menu.setHeaderTitle("Choose an option");
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                selectImage();
                break;
            case R.id.flipH:
                imageBitmap = flipImage(imageBitmap, FLIP_HORIZONTAL);
                imageView.setImageBitmap(imageBitmap);
                break;
            case R.id.flipV:
                imageBitmap = flipImage(imageBitmap, FLIP_VERTICAL);
                imageView.setImageBitmap(imageBitmap);
                break;
            case R.id.invertC:
                imageBitmap = createInvertedBitmap(imageBitmap);
                imageView.setImageBitmap(imageBitmap);
                break;
            case R.id.flipBW:
                imageBitmap = ConvertToBlackAndWhite(imageBitmap);
                imageView.setImageBitmap(imageBitmap);
                break;

        }
        return super.onContextItemSelected(item);

    }
}
