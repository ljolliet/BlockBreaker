package jolliet.louis.blockbreaker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by loulou on 12/03/18.
 */

class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private Integer[] mThumbIds={ R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4,
            R.drawable.tuile1,R.drawable.tuile2,R.drawable.tuile3,R.drawable.tuile4
    };
    private List<Integer> l = new ArrayList();


    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
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




        Random r = new Random();
        int valeur;
        for(int i=0;i<mThumbIds.length;i++){
            valeur = r.nextInt(4 - 0);
            l.add(mThumbIds[valeur]);
        };





        imageView.setImageResource(l.get(position));
        return imageView;
    }



}
