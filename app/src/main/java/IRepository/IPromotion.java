package IRepository;

import model.Promotion;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jmjsa on 04/03/2017.
 */

public interface IPromotion {
    @GET("PromotionActivity/GetAvailablePromotions")
    Call<Promotion[]> GetAllPromotion();
}
