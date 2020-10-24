package IRepository;

import model.Color;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jmjsa on 04/03/2017.
 */

public interface IColor {
    @GET("Color/GetAllColors")
    Call<Color[]> GetAllColorList();
}
