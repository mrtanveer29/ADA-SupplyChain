package IRepository;

import model.Product;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jmjsa on 04/03/2017.
 */

public interface IProductList {
    @GET("Product/GetAllProducts")
    Call<Product[]> GetAllProduct();
}
