package IRepository;

import UserDefinder.LoginModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jmjsa on 22/03/2017.
 */

public interface ILogin {
    @GET("login/LoginInformationForDealer")
    Call<LoginModel> GetLoginInfo(@Query("username") String username,@Query("password") String password);
}
