package UserDefinder;

/**
 * Created by jmjsa on 19/03/2017.
 */

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class UserCurrentbalanceModel {

    @SerializedName("partyBalance")
    @Expose
    private Double partyBalance;

    public Double getPartyBalance() {
        return partyBalance;
    }

    public void setPartyBalance(Double partyBalance) {
        this.partyBalance = partyBalance;
    }


}
