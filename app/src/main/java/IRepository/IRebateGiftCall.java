package IRepository;

import UserDefinder.GetRebateAndGiftInfoModel;
import UserDefinder.RebateGiftInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by jmjsa on 05/03/2017.
 */

public interface IRebateGiftCall {
    @POST("Requisition/GetRebateAndGiftInfo")
    Call<RebateGiftInfo> GetRebateGiftInfo(@Body GetRebateAndGiftInfoModel getRebateAndGiftInfoModel);
}
