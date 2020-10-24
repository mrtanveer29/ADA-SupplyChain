package IRepository;

import UserDefinder.ReceivedDeliveryModel;
import model.DeliveryListInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jmjsa on 06/03/2017.
 */

public interface IdeliveryListInfo {
    @GET("Delivery/GetAllDeliveryByPartyId")
    Call<DeliveryListInfo[]> GetAllDeliveryListInfo(@Query("party_id") int party_id);
    @GET("Delivery/UpdateApproveStatus")
    Call<ReceivedDeliveryModel> ReceivedDelivery(@Query("delivery_master_id") int delivery_master_id, @Query("userid") int userid);
}
