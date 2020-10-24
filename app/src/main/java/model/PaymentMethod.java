package model;

/**
 * Created by jmjsa on 12/03/2017.
 */

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class PaymentMethod {

    @SerializedName("payment_method_id")
    @Expose
    private Integer paymentMethodId;
    @SerializedName("payment_method_name")
    @Expose
    private String paymentMethodName;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("company_id")
    @Expose
    private Integer companyId;

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return getPaymentMethodName().toString();
    }
}