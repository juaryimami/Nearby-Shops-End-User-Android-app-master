package org.nearbyshops.enduserappnew.OrderHistory.SlidingLayerSort;

import android.content.Context;
import android.content.SharedPreferences;
import org.nearbyshops.enduserappnew.R;

import static android.content.Context.MODE_PRIVATE;




public class PrefSortOrders {



    public static void saveSort(Context context, String sort_by)
    {
        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("sort_orders_home_delivery", sort_by);
        editor.apply();
    }





    public static String getSort(Context context)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        String sort_by = sharedPref.getString("sort_orders_home_delivery", SlidingLayerSortOrders.SORT_BY_DATE_TIME);

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
        editor.putString("sort_descending_orders_hd",descending);
        editor.apply();
    }



    public static String getAscending(Context context)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        String descending = sharedPref.getString("sort_descending_orders_hd", SlidingLayerSortOrders.SORT_DESCENDING);

        return descending;
    }




    public static void saveFilterByOrderStatus(Context context, int statusType)
    {
        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("filter_orders_by_status", statusType);
        editor.apply();
    }





    public static int getFilterByOrderStatus(Context context)
    {


        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);

        return sharedPref.getInt("filter_orders_by_status", SlidingLayerSortOrders.CLEAR_FILTERS_ORDER_STATUS);
    }








    public static void saveFilterByDeliveryType(Context context, int statusType)
    {
        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("filter_orders_by_delivery_type", statusType);
        editor.apply();
    }








    public static int getFilterByDeliveryType(Context context)
    {


        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);

        return sharedPref.getInt("filter_orders_by_delivery_type", SlidingLayerSortOrders.CLEAR_FILTERS_DELIVERY_TYPE);
    }





}
