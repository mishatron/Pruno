package com.hack.apps.starter.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.model.PlaceModel;
import com.hack.apps.starter.util.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

import static com.hack.apps.starter.util.RatingUtil.calculateRate;

public class PlaceAdapter extends BaseAdapter {
    public static String TAG = "PlaceAdapter";
    private Context context;
    private List<PlaceModel> list;

    public PlaceAdapter(Context context, List<PlaceModel> model) {
        this.context = context;
        this.list = model;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_fragment_dashboard, viewGroup, false);

        ((TextView) itemView.findViewById(R.id.project_name)).setText(list.get(i).getTitle());

        ((TextView) itemView.findViewById(R.id.money_text)).setText(String.valueOf(list.get(i).getPricePerHour()));

        CircleImageView img = (CircleImageView) itemView.findViewById(R.id.project_image);

        if (list.get(i).getIcon() != null) {
            Picasso.with(context)
                    .load(Constants.BASE_URL + list.get(i).getIcon())
                    .resize(50,50)
                    .into(img);
        }
        MaterialRatingBar starBar = itemView.findViewById(R.id.star_bar);
        float rate = calculateRate(list.get(i).getLocationRate(), list.get(i).getServiceRate(), list.get(i).getComfortRate());
        Log.e(TAG, "rate=" + rate);
        starBar.setRating(rate);


        //Todo add tags

        return itemView;
    }


}
