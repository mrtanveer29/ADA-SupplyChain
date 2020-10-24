package IRepository;

import UserDefinder.DeliveryChallanReportModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jmjsa on 07/03/2017.
 */

public interface IDeliveryChallanReport {
    @GET("Delivery/GetDeliveryReportById")
    Call<DeliveryChallanReportModel[]> GetAllDeliveryReportData(@Query("delivery_master_id") int delivery_master_id);
}
