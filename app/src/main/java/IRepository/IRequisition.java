package IRepository;

import UserDefinder.GetRebateAndGiftInfoModel;
import UserDefinder.RebateAndGiftModel;
import UserDefinder.RequisitionAddModel;
import UserDefinder.RequisitionAddReturnDataModel;
import UserDefinder.RequisitionDeleteModel;
import UserDefinder.RequisitionGiftAndRebate;
import UserDefinder.RequisitionList;
import UserDefinder.UserCurrentbalanceModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by jmjsa on 17/03/2017.
 */

public interface IRequisition {
    @GET("Requisition/GetAllRequisitionByPartyId")
    Call<RequisitionList[]> GetAllRequisiTionByPartyId(@Query("party_id") int party_id);
    @GET("PartyJournal/GetPartyBalance")
   Call<UserCurrentbalanceModel> GetCurrentbalanceofParty(@Query("party_id")int party_id);
    @GET("Requisition/cancelRequisition")
    Call<RequisitionDeleteModel> DeleteReuisitionFromList(@Query("requisition_master_id") int requisition_master_id, @Query("userid")int userid);
    @POST("requisition/AddRequisitionForApp")
    Call<RequisitionAddReturnDataModel> RequisitionAdd(@Body() RequisitionAddModel requisitionAddModel);
    @POST("Requisition/GetRebateAndGiftInfo")
    Call<RebateAndGiftModel> getGiftAndRebate(@Body()RequisitionGiftAndRebate giftInfoModel);
}
