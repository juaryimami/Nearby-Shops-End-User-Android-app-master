package org.nearbyshops.enduserappnew.ItemsInShopByCategory.SlidingLayerSort;

import android.content.Context;
import android.content.SharedPreferences;
import org.nearbyshops.enduserappnew.MyApplication;
import org.nearbyshops.enduserappnew.R;

import static android.content.Context.MODE_PRIVATE;


public class PrefSortItemsInShop {



    public static void saveSort(Context context, String sort_by)
    {
        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("sort_shop_items_by_shop", sort_by);
        editor.apply();
    }


    public static String getSort(Context context)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        String sort_by = sharedPref.getString("sort_shop_items_by_shop", SlidingLayerSortItemsInShop.SORT_BY_SHOP_COUNT);

        return sort_by;
    }



    public static void saveAscending(Context context, String descending)
    {

        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("sort_descending_shop_items_by_shop",descending);
        editor.apply();
    }



    public static String getAscending(Context context)
    {

        if(context==null)
        {
            context = MyApplication.getAppContext();
        }

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        String descending = sharedPref.getString("sort_descending_shop_items_by_shop", SlidingLayerSortItemsInShop.SORT_ASCENDING);

        return descending;
    }

}
