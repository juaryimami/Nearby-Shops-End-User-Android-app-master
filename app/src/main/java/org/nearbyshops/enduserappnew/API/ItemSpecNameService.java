package org.nearbyshops.enduserappnew.API;


import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.nearbyshops.enduserappnew.Model.Image;
import org.nearbyshops.enduserappnew.Model.ModelItemSpecs.EndPoints.ItemSpecNameEndPoint;
import org.nearbyshops.enduserappnew.Model.ModelItemSpecs.ItemSpecificationName;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;



public interface ItemSpecNameService {


    @POST("/api/v1/ItemSpecificationName")
    Call<ItemSpecificationName> saveItemSpecName(@Header("Authorization") String headers,
                                                 @Body ItemSpecificationName itemSpecName);




    @PUT("/api/v1/ItemSpecificationName/{ImageID}")
    Call<ResponseBody> updateItemSpec(@Header("Authorization") String headers,
                                      @Body ItemSpecificationName itemSpecName,
                                      @Path("ImageID") int imageID);




    @DELETE("/api/v1/ItemSpecificationName/{ItemSpecNameID}")
    Call<ResponseBody> deleteItemSpecName(@Header("Authorization") String headers,
                                          @Path("ItemSpecNameID") int itemSpecNameID);




    @GET("/api/v1/ItemSpecificationName/OuterJoin")
    Call<ItemSpecNameEndPoint> getItemSpecName(
            @Query("ItemCatID") Integer itemCatID,
            @Query("SortBy") String sortBy,
            @Query("Limit") Integer limit, @Query("Offset") Integer offset,
            @Query("GetRowCount") Boolean getRowCount);




    @GET("/api/v1/ItemSpecificationName")
    Call<List<ItemSpecificationName>> getItemSpecName(
            @Query("ItemID") Integer itemID,
            @Query("ItemCatID") Integer itemCatID);



    @GET("/api/v1/ItemSpecificationName/SpecsForFilters")
    Call<List<ItemSpecificationName>> getItemSpecsForFilters(
            @Query("ItemCatID") Integer itemCatID,
            @Query("ShopID") Integer shopID,
            @Query("latCenter") Double latCenter, @Query("lonCenter") Double lonCenter,
            @Query("SearchString") String searchString);



    // Image Calls

    @POST("/api/v1/ItemSpecificationName/Image")
    Call<Image> uploadItemImage(@Header("Authorization") String headers,
                                @Body RequestBody image);


    @DELETE("/api/v1/ItemSpecificationName/Image/{name}")
    Call<ResponseBody> deleteItemImage(@Header("Authorization") String headers,
                                       @Path("name") String fileName);



}
