package com.hack.apps.starter.filter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.appyvet.materialrangebar.RangeBar;
import com.hack.apps.starter.MainActivity;
import com.hack.apps.starter.R;
import com.hack.apps.starter.filter.entity.Filter;
import com.hack.apps.starter.util.Constants;
import com.hack.apps.starter.util.Tag;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterActivity extends AppCompatActivity {

    private Integer minPrice, maxPrice;


    @BindView(R.id.comfortLabel)
    TextView comfortLabel;

    @BindView(R.id.serviceLabel)
    TextView serviceLabel;

    @BindView(R.id.locationLabel)
    TextView locationLabel;

    @BindView(R.id.comfortSlider)
    RangeBar comfortSlider;

    @BindView(R.id.serviceSlider)
    RangeBar serviceSlider;

    @BindView(R.id.locationSlider)
    RangeBar locationSlider;

    @BindView(R.id.work_at_night)
    CheckBox workAtNight;

    @BindView(R.id.priceSlider)
    RangeBar priceSlider;

    @BindView(R.id.leftPrice)
    TextView leftPrice;

    @BindView(R.id.rightPrice)
    TextView rightPrice;

    @BindView(R.id.bWork)
    LinearLayout bWork;

    @BindView(R.id.bRest)
    LinearLayout bRest;

    @BindView(R.id.bFood)
    LinearLayout bFood;

    @BindView(R.id.bWiFi)
    LinearLayout bWiFi;


    @BindView(R.id.apply)
    RippleView apply;

    @BindView(R.id.reset)
    RippleView reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        ButterKnife.bind(this);

        setTitle("Фільтр");

        minPrice = getIntent().getIntExtra(Constants.MIN_PRICE, 0);
        maxPrice = getIntent().getIntExtra(Constants.MAX_PRICE, 0);


        if (MainActivity.filter == null) {
            MainActivity.filter = new Filter(minPrice, maxPrice);
        }

        Log.e("PRICES", minPrice + " " + maxPrice);

        // init
        {

            if (MainActivity.filter.getTags().contains(Tag.WORK))
                bWork.setBackgroundResource(R.drawable.tag_background);

            if (MainActivity.filter.getTags().contains(Tag.FOOD))
                bFood.setBackgroundResource(R.drawable.tag_background);

            if (MainActivity.filter.getTags().contains(Tag.REST))
                bRest.setBackgroundResource(R.drawable.tag_background);

            if (MainActivity.filter.getTags().contains(Tag.WIFI))
                bWiFi.setBackgroundResource(R.drawable.tag_background);

            leftPrice.setText(MainActivity.filter.getMinPrice() + "");
            rightPrice.setText(MainActivity.filter.getMaxPrice() + "");

            comfortSlider.setLeft(MainActivity.filter.getMinComfortRate().intValue());
            comfortSlider.setRight(MainActivity.filter.getMaxComfortRate().intValue());
            comfortLabel.setText("Комфорт [" + MainActivity.filter.getMinComfortRate().intValue()
                    + "-" + MainActivity.filter.getMaxComfortRate().intValue() + "]");


            serviceSlider.setLeft(MainActivity.filter.getMinServiceRate().intValue());
            serviceSlider.setRight(MainActivity.filter.getMaxServiceRate().intValue());
            serviceLabel.setText("Якість [" + MainActivity.filter.getMinServiceRate().intValue()
                    + "-" + MainActivity.filter.getMaxServiceRate().intValue() + "]");

            locationSlider.setLeft(MainActivity.filter.getMinLocationRate().intValue());
            locationSlider.setRight(MainActivity.filter.getMaxLocationRate().intValue());
            locationLabel.setText("Розміщення [" + MainActivity.filter.getMinLocationRate().intValue()
                    + "-" + MainActivity.filter.getMaxLocationRate().intValue() + "]");

            workAtNight.setChecked(MainActivity.filter.getWorkAtNight());

        }

        priceSlider.setTickStart(minPrice);
        priceSlider.setTickEnd(maxPrice);

        leftPrice.setText(minPrice + "");
        rightPrice.setText(maxPrice + "");

        priceSlider.setOnRangeBarChangeListener((rangeBar, leftPinIndex, rightPinIndex, leftPinValue, rightPinValue) -> {

            leftPrice.setText(leftPinValue);
            rightPrice.setText(rightPinValue);

            MainActivity.filter.setMinPrice((float) leftPinIndex);
            MainActivity.filter.setMaxPrice((float) rightPinIndex);

        });


        workAtNight.setOnCheckedChangeListener(
                (buttonView, isChecked) -> MainActivity.filter.setWorkAtNight(isChecked));


        comfortSlider.setOnRangeBarChangeListener((rangeBar, leftPinIndex, rightPinIndex, leftPinValue, rightPinValue) -> {

            comfortLabel.setText("Комфорт [" + leftPinValue + "-" + rightPinValue + "]");

            MainActivity.filter.setMinComfortRate((float) leftPinIndex);
            MainActivity.filter.setMaxComfortRate((float) rightPinIndex);

        });

        serviceSlider.setOnRangeBarChangeListener((rangeBar, leftPinIndex, rightPinIndex, leftPinValue, rightPinValue) -> {

            serviceLabel.setText("Якість [" + leftPinValue + "-" + rightPinValue + "]");

            MainActivity.filter.setMinServiceRate((float) leftPinIndex);
            MainActivity.filter.setMaxServiceRate((float) rightPinIndex);

        });

        locationSlider.setOnRangeBarChangeListener((rangeBar, leftPinIndex, rightPinIndex, leftPinValue, rightPinValue) -> {

            locationLabel.setText("Розташування [" + leftPinValue + "-" + rightPinValue + "]");

            MainActivity.filter.setMinLocationRate((float) leftPinIndex);
            MainActivity.filter.setMaxLocationRate((float) rightPinIndex);

        });


        bWork.setOnClickListener(v -> {
            List<String> tags = MainActivity.filter.getTags();

            if (tags.contains(Tag.WORK.getTitle())) {
                v.setBackgroundResource(R.drawable.tag_background_clear);
                tags.remove(Tag.WORK.getTitle());
                MainActivity.filter.setTags(tags);
            } else {
                v.setBackgroundResource(R.drawable.tag_background);
                tags.add(Tag.WORK.getTitle());
                MainActivity.filter.setTags(tags);
            }
        });

        bRest.setOnClickListener(v -> {
            List<String> tags = MainActivity.filter.getTags();

            if (tags.contains(Tag.REST.getTitle())) {
                v.setBackgroundResource(R.drawable.tag_background_clear);
                tags.remove(Tag.REST.getTitle());
                MainActivity.filter.setTags(tags);
            } else {
                v.setBackgroundResource(R.drawable.tag_background);
                tags.add(Tag.REST.getTitle());
                MainActivity.filter.setTags(tags);
            }
        });

        bFood.setOnClickListener(v -> {
            List<String> tags = MainActivity.filter.getTags();

            if (tags.contains(Tag.FOOD.getTitle())) {
                v.setBackgroundResource(R.drawable.tag_background_clear);
                tags.remove(Tag.FOOD.getTitle());
                MainActivity.filter.setTags(tags);
            } else {
                v.setBackgroundResource(R.drawable.tag_background);
                tags.add(Tag.FOOD.getTitle());
                MainActivity.filter.setTags(tags);
            }
        });


        bWiFi.setOnClickListener(v -> {
            List<String> tags = MainActivity.filter.getTags();

            if (tags.contains(Tag.WIFI.getTitle())) {
                v.setBackgroundResource(R.drawable.tag_background_clear);
                tags.remove(Tag.WIFI.getTitle());
                MainActivity.filter.setTags(tags);
            } else {
                v.setBackgroundResource(R.drawable.tag_background);
                tags.add(Tag.WIFI.getTitle());
                MainActivity.filter.setTags(tags);
            }
        });


        apply.setOnClickListener(rippleView -> close());

        reset.setOnClickListener(rippleView -> {

            MainActivity.filter = null;
            close();
        });

    }


    private void close() {

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();

    }

}
