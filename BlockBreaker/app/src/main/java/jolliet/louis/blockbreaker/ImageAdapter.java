package jolliet.louis.blockbreaker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by loulou on 12/03/18.
 */

class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private Integer[] colorBlocks = {R.drawable.tuile1, R.drawable.tuile2, R.drawable.tuile3, R.drawable.tuile4};
    private Integer whiteBlock = R.drawable.tuile0;
    private List<Integer> blockList = new ArrayList();


    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return blockList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;


        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(blockList.get(position));
        return imageView;
    }


    public void createArray(int numColumn) {
        Random r = new Random();
        int nbBlock = (int) Math.pow(numColumn, 2);
        int valeur;
        for (int i = 0; i < nbBlock; i++) {
            valeur = r.nextInt(4 - 0);
            blockList.add(colorBlocks[valeur]);
        }
        ;
    }

    public void setBlockClicked(int blockClicked) {
        blockList.set(blockClicked, null);
    }

    public int getColor(int position) {
        if (blockList.get(position) != null)
            switch (blockList.get(position)) {
                case R.drawable.tuile0:
                    return 0;
                case R.drawable.tuile1:
                    return 1;
                case R.drawable.tuile2:
                    return 2;
                case R.drawable.tuile3:
                    return 3;
                case R.drawable.tuile4:
                    return 4;
                default:
                    return -1;
            }
        else
            return -1;

    }
}
