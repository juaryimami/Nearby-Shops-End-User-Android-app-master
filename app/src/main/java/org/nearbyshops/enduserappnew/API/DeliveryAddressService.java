package org.nearbyshops.enduserappnew.API;

import okhttp3.ResponseBody;
import org.nearbyshops.enduserappnew.Model.ModelStats.DeliveryAddress;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface DeliveryAddressService {

    @GET("/api/DeliveryAddress")
    Call<List<DeliveryAddress>> getAddresses(@Query("EndUserID") int endUserID);

    @GET("/api/DeliveryAddress/{id}")
    Call<DeliveryAddress> getAddress(@Path("id") int address_id);

    @POST("/api/DeliveryAddress")
    Call<DeliveryAddress> postAddress(@Body DeliveryAddress address);

    @PUT("/api/DeliveryAddress/{id}")
    Call<ResponseBody> putAddress(@Body DeliveryAddress address, @Path("id") int address_id);

    @DELETE("/api/DeliveryAddress/{id}")
    Call<ResponseBody> deleteAddress(@Path("id") int address_id);

}
