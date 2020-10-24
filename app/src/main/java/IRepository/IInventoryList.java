package IRepository;

import model.Inventory;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jmjsa on 10/03/2017.
 */

public interface IInventoryList {
    @GET("Inventory/PartyWiseStock")
    Call<Inventory[]> GetAllInventoryList(@Query("role_id")int role_id,@Query("party_id") int party_id);
}
