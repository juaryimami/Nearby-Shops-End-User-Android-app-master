package org.nearbyshops.enduserappnew.API;

import okhttp3.ResponseBody;
import org.nearbyshops.enduserappnew.Model.ModelEndPoints.ShopReviewEndPoint;
import org.nearbyshops.enduserappnew.Model.ModelReviewShop.ShopReview;
import org.nearbyshops.enduserappnew.Model.ModelReviewShop.ShopReviewStatRow;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;



public interface ShopReviewService {

    @GET("/api/v1/ShopReview")
    Call<ShopReviewEndPoint> getReviews(
            @Query("ShopID") Integer bookID,
            @Query("EndUserID") Integer memberID,
            @Query("GetEndUser") Boolean getMember,
            @Query("SortBy") String sortBy,
            @Query("Limit") Integer limit, @Query("Offset") Integer offset,
            @Query("metadata_only") Boolean metaonly
    );


    @GET("/api/v1/ShopReview/{id}")
    Call<ShopReview> getShopReview(@Path("id") int shopReviewID);

    @POST("/api/v1/ShopReview")
    Call<ShopReview> insertShopReview(@Body ShopReview book);

    @PUT("/api/v1/ShopReview/{id}")
    Call<ResponseBody> updateShopReview(@Body ShopReview shopReview, @Path("id") int id);

    @PUT("/api/v1/ShopReview/")
    Call<ResponseBody> updateShopReviewBulk(@Body List<ShopReview> shopReviewList);

    @DELETE("/api/v1/ShopReview/{id}")
    Call<ResponseBody> deleteShopReview(@Path("id") int id);


    @GET("/api/v1/ShopReview/Stats/{ShopID}")
    Call<List<ShopReviewStatRow>> getStats(@Path("ShopID") int shopID);


}
