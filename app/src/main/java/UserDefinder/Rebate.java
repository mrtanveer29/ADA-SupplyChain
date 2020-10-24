package UserDefinder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jmjsa on 05/03/2017.
 */

public class Rebate {
    @SerializedName("rebate_for")
    @Expose
    private String rebate_for;
    @SerializedName("quantity")
    @Expose
    private int quantity;
    @SerializedName("amount")
    @Expose
    private double amount;
    @SerializedName("rebate")
    @Expose
    private String rebate;
    @SerializedName("rebate_type")
    @Expose
    private String rebate_type;
    @SerializedName("rebate_amount")
    @Expose
    private double rebate_amount;

    public double getRebate_amount() {
        return rebate_amount;
    }

    public void setRebate_amount(double rebate_amount) {
        this.rebate_amount = rebate_amount;
    }

    public String getRebate_for() {
        return rebate_for;
    }

    public void setRebate_for(String rebate_for) {
        this.rebate_for = rebate_for;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRebate() {
        return rebate;
    }

    public void setRebate(String rebate) {
        this.rebate = rebate;
    }

    public String getRebate_type() {
        return rebate_type;
    }

    public void setRebate_type(String rebate_type) {
        this.rebate_type = rebate_type;
    }
}
