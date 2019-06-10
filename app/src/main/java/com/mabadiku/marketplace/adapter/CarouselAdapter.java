package com.mabadiku.marketplace.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mabadiku.marketplace.fragment.CarouselFragment;

public class CarouselAdapter extends FragmentStatePagerAdapter {
    public int[] imageResourceIds;

    public CarouselAdapter(FragmentManager fm, int[] imageResourceIds) {
        super(fm);
        this.imageResourceIds = imageResourceIds;
    }

    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(CarouselFragment.IMAGE_RESOURCE_ID, imageResourceIds[i]);
        CarouselFragment frag = new CarouselFragment();
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public int getCount() {
        return (imageResourceIds == null)? 0:imageResourceIds.length;
    }
}
