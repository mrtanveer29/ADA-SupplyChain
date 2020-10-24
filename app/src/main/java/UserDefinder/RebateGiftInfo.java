package UserDefinder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jmjsa on 05/03/2017.
 */

public class RebateGiftInfo {
    @SerializedName("rebateList")
    @Expose
    private ArrayList<Rebate>  rebateList;
    @SerializedName("giftList")
    @Expose
    private ArrayList<Gift> giftList;

    public ArrayList<Gift> getGiftList() {
        return giftList;
    }

    public void setGiftList(ArrayList<Gift> giftList) {
        this.giftList = giftList;
    }

    public ArrayList<Rebate> getRebateList() {
        return rebateList;
    }

    public void setRebateList(ArrayList<Rebate> rebateList) {
        this.rebateList = rebateList;
    }
}
