package org.nearbyshops.enduserappnew.API;

import okhttp3.ResponseBody;
import org.nearbyshops.enduserappnew.Model.ModelReviewItem.ItemReview;
import org.nearbyshops.enduserappnew.Model.ModelReviewItem.ItemReviewEndPoint;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;



public interface ItemReviewService {

    @GET("/api/v1/ItemReview")
    Call<ItemReviewEndPoint> getReviews(
            @Query("ItemID") Integer itemID,
            @Query("EndUserID") Integer endUserID,
            @Query("GetEndUser") Boolean getEndUser,
            @Query("SortBy") String sortBy,
            @Query("Limit") Integer limit, @Query("Offset") Integer offset,
            @Query("metadata_only") Boolean metaonly
    );


    @GET("/api/v1/ItemReview/{id}")
    Call<ItemReview> getItemReview(@Path("id") int itemReviewID);

    @POST("/api/v1/ItemReview")
    Call<ItemReview> insertItemReview(@Body ItemReview book);

    @PUT("/api/v1/ItemReview/{id}")
    Call<ResponseBody> updateItemReview(@Body ItemReview itemReview, @Path("id") int id);

    @PUT("/api/v1/ItemReview/")
    Call<ResponseBody> updateItemReviewBulk(@Body List<ItemReview> itemReviewList);

    @DELETE("/api/v1/ItemReview/{id}")
    Call<ResponseBody> deleteItemReview(@Path("id") int id);

}
