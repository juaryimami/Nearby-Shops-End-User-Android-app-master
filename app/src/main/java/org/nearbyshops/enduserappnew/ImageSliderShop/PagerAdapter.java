package org.nearbyshops.enduserappnew.ImageSliderShop;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import org.nearbyshops.enduserappnew.Model.ModelImages.ItemImage;
import org.nearbyshops.enduserappnew.Preferences.UtilityFunctions;

import java.util.List;



public class PagerAdapter extends FragmentPagerAdapter {



    private List<Object> imagesList;


    public PagerAdapter(FragmentManager fm, List<Object> imagesList) {
        super(fm);

        this.imagesList = imagesList;
    }

    @Override
    public Fragment getItem(int position) {

        FragmentShopImage fragment = new FragmentShopImage();

        Bundle bundle = new Bundle();
        ItemImage taxiData = (ItemImage) imagesList.get(position);
        String jsonString = UtilityFunctions.provideGson()
                .toJson(taxiData);


        bundle.putString("shop_image",jsonString);
        fragment.setArguments(bundle);




        showLogMessage("List Size : " + String.valueOf(imagesList.size()));

        return fragment;
    }



    void showLogMessage(String string)
    {
        Log.d("image_slider",string);
    }




    @Override
    public int getCount() {
        return imagesList.size();
    }




}
