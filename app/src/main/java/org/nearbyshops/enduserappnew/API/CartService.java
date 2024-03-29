package org.nearbyshops.enduserappnew.API;

import okhttp3.ResponseBody;
import org.nearbyshops.enduserappnew.Model.ModelCartOrder.Cart;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface CartService {

    @GET("/api/Cart")
    Call<List<Cart>> getCarts(@Query("EndUserID") int endUserID, @Query("ShopID") int shopID);

    @GET("/api/Cart/{id}")
    Call<Cart> getCart(@Path("id") int cart_id);

    @POST("/api/Cart")
    Call<Cart> postCart(@Body Cart cart);

    @PUT("/api/Cart/{id}")
    Call<ResponseBody> putCart(@Body Cart cart, @Path("id") int cart_id);

    @DELETE("/api/Cart/{id}")
    Call<ResponseBody> deleteCart(@Path("id") int cart_id);

}
