package UserDefinder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jmjsa on 05/03/2017.
 */

public class Gift {
    @SerializedName("gift_for")
    @Expose
    private String gift_for;
    @SerializedName("gift_quantity_for ")
    @Expose
    private int gift_quantity_for ;
    @SerializedName("gift_quantity  ")
    @Expose
    private int gift_quantity  ;

    public String getGift_for() {
        return gift_for;
    }

    public void setGift_for(String gift_for) {
        this.gift_for = gift_for;
    }

    public int getGift_quantity_for() {
        return gift_quantity_for;
    }

    public void setGift_quantity_for(int gift_quantity_for) {
        this.gift_quantity_for = gift_quantity_for;
    }

    public int getGift_quantity() {
        return gift_quantity;
    }

    public void setGift_quantity(int gift_quantity) {
        this.gift_quantity = gift_quantity;
    }
}
