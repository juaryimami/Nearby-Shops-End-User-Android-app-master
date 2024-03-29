package org.nearbyshops.enduserappnew.ItemsByCategory.SlidingLayerSort;

import android.content.Context;
import android.content.SharedPreferences;
import org.nearbyshops.enduserappnew.MyApplication;
import org.nearbyshops.enduserappnew.R;

import static android.content.Context.MODE_PRIVATE;



public class PrefSortItemsByCategory {



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
        editor.putString("sort_items_by_category", sort_by);
        editor.apply();
    }


    public static String getSort(Context context)
    {
        context = MyApplication.getAppContext();


        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        return sharedPref.getString("sort_items_by_category", SlidingLayerSortItems.SORT_BY_ITEM_RATING);
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
        editor.putString("sort_descending_items_by_category",descending);
        editor.apply();
    }



    public static String getAscending(Context context)
    {
        context = MyApplication.getAppContext();

        if(context==null)
        {
            context = MyApplication.getAppContext();
        }

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        String descending = sharedPref.getString("sort_descending_items_by_category", SlidingLayerSortItems.SORT_DESCENDING);

        return descending;
    }

}
