
package model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Promotion {

    @SerializedName("promotion_master_id")
    @Expose
    private Integer promotionMasterId;
    @SerializedName("titel")
    @Expose
    private String titel;
    @SerializedName("promotion_description")
    @Expose
    private String promotionDescription;

    public Integer getPromotionMasterId() {
        return promotionMasterId;
    }

    public void setPromotionMasterId(Integer promotionMasterId) {
        this.promotionMasterId = promotionMasterId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getPromotionDescription() {
        return promotionDescription;
    }

    public void setPromotionDescription(String promotionDescription) {
        this.promotionDescription = promotionDescription;
    }

}