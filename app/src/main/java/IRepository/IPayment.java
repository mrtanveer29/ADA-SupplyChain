package IRepository;

import UserDefinder.PaymentListModel;
import UserDefinder.PaymentREquestDeleteModel;
import UserDefinder.ReceivedDeliveryModel;
import model.Bank;
import model.PaymentMethod;
import model.SalesRepresentative;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jmjsa on 12/03/2017.
 */

public interface IPayment {
        @GET("PaymentMethod/GetAllPaymentMethod")
    Call<PaymentMethod[]> GetAllPaymentMethod();

    @GET("Bank/GetAllBank")
    Call<Bank[]> GetAllBank();
    @GET("Employee/GetDropdownForPaymentRequest")
    Call<SalesRepresentative[]> GetAllSalesRepresentative(@Query("party_type_name") String party_type_name);
    @GET("Delivery/UpdateApproveStatus")
    Call<ReceivedDeliveryModel> ReceivedDelivery(@Query("delivery_master_id") int delivery_master_id, @Query("userid")int userid);
    @GET("PaymentRequest/GetAllPaymentRequest")
    Call<PaymentListModel[]> GetAllPaymentList(@Query("party_id")  int party_id);
    @DELETE("PaymentRequest/Delete")
    Call<PaymentREquestDeleteModel> PaymentRequestDelete(@Query("payment_req_id") int payment_req_id);

}
