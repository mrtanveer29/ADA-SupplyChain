package UserDefinder;

/**
 * Created by jmjsa on 20/03/2017.
 */

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class PaymentListModel {

    @SerializedName("payment_req_id")
    @Expose
    private Integer paymentReqId;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("deposite_date")
    @Expose
    private String depositeDate;
    @SerializedName("payment_method_id")
    @Expose
    private Integer paymentMethodId;
    @SerializedName("payment_method_name")
    @Expose
    private String paymentMethodName;
    @SerializedName("cheque_no")
    @Expose
    private String chequeNo;
    @SerializedName("approved")
    @Expose
    private Boolean approved;
    @SerializedName("document_attachment")
    @Expose
    private String documentAttachment;
    @SerializedName("party_id")
    @Expose
    private Integer partyId;
    @SerializedName("party_name")
    @Expose
    private String partyName;
    @SerializedName("party_type_id")
    @Expose
    private Integer partyTypeId;
    @SerializedName("party_type_name")
    @Expose
    private String partyTypeName;
    @SerializedName("sales_representative")
    @Expose
    private String salesRepresentative;

    public Integer getPaymentReqId() {
        return paymentReqId;
    }

    public void setPaymentReqId(Integer paymentReqId) {
        this.paymentReqId = paymentReqId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDepositeDate() {
        return depositeDate;
    }

    public void setDepositeDate(String depositeDate) {
        this.depositeDate = depositeDate;
    }

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

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getDocumentAttachment() {
        return documentAttachment;
    }

    public void setDocumentAttachment(String documentAttachment) {
        this.documentAttachment = documentAttachment;
    }

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Integer getPartyTypeId() {
        return partyTypeId;
    }

    public void setPartyTypeId(Integer partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    public String getPartyTypeName() {
        return partyTypeName;
    }

    public void setPartyTypeName(String partyTypeName) {
        this.partyTypeName = partyTypeName;
    }

    public String getSalesRepresentative() {
        return salesRepresentative;
    }

    public void setSalesRepresentative(String salesRepresentative) {
        this.salesRepresentative = salesRepresentative;
    }

}
