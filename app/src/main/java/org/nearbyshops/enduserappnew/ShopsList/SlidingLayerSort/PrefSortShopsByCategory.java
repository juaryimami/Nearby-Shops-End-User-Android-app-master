package org.nearbyshops.enduserappnew.ShopsList.SlidingLayerSort;

import android.content.Context;
import android.content.SharedPreferences;
import org.nearbyshops.enduserappnew.MyApplication;
import org.nearbyshops.enduserappnew.R;

import static android.content.Context.MODE_PRIVATE;



public class PrefSortShopsByCategory {



    public static void saveSort(Context context, String sort_by)
    {
        context = MyApplication.getAppContext();
        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("sort_shops_by_category", sort_by);
        editor.apply();
    }


    public static String getSort(Context context)
    {
        context = MyApplication.getAppContext();

        if(context==null)
        {
            return SlidingLayerSortShops.SORT_BY_DISTANCE;
        }

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        return sharedPref.getString("sort_shops_by_category", SlidingLayerSortShops.SORT_BY_DISTANCE);
    }



    public static void saveAscending(Context context, String descending)
    {
        context = MyApplication.getAppContext();

        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("sort_descending_shops_by_category",descending);
        editor.apply();
    }



    public static String getAscending(Context context)
    {
        context = MyApplication.getAppContext();

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        return sharedPref.getString("sort_descending_shops_by_category", SlidingLayerSortShops.SORT_ASCENDING);
    }





    public static void saveFilterByDeliveryType(Context context, boolean isHomeDelivery)
    {
        context = MyApplication.getAppContext();

        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("filter_shops_by_delivery_type", isHomeDelivery);
        editor.apply();
    }





    public static boolean getFilterByDeliveryType(Context context)
    {
        context = MyApplication.getAppContext();

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        return sharedPref.getBoolean("filter_shops_by_delivery_type", true);
    }


}
