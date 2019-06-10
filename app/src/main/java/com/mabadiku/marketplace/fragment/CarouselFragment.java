package com.mabadiku.marketplace.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.mabadiku.marketplace.R;

public class CarouselFragment extends Fragment {
    public static final String IMAGE_RESOURCE_ID = "image_resource_id";
    private ImageView ivCarouselImage;
    private int imageResourceid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.carouselfragment,container,false);
        ivCarouselImage=(ImageView) v.findViewById(R.id.iv_carousel_image);
        imageResourceid=getArguments().getInt(IMAGE_RESOURCE_ID , R.drawable.promo1);
        ivCarouselImage.setImageResource(imageResourceid);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "image: " + imageResourceid, Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
