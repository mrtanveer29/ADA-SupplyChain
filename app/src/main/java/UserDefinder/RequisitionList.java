package UserDefinder;

/**
 * Created by jmjsa on 17/03/2017.
 */

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class RequisitionList {

    @SerializedName("requisition_master_id")
    @Expose
    private Integer requisitionMasterId;
    @SerializedName("requisition_code")
    @Expose
    private String requisitionCode;
    @SerializedName("created_by")
    @Expose
    private Integer createdBy;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("party_id")
    @Expose
    private Integer partyId;
    @SerializedName("requisition_date")
    @Expose
    private String requisitionDate;
    @SerializedName("delivery_status")
    @Expose
    private String deliveryStatus;
    @SerializedName("party_name")
    @Expose
    private String partyName;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("expected_receiving_date")
    @Expose
    private String expectedReceivingDate;
    @SerializedName("warehouse_from")
    @Expose
    private Integer warehouseFrom;
    @SerializedName("warehouse_name")
    @Expose
    private String warehouseName;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("finance_status")
    @Expose
    private String financeStatus;

    public Integer getRequisitionMasterId() {
        return requisitionMasterId;
    }

    public void setRequisitionMasterId(Integer requisitionMasterId) {
        this.requisitionMasterId = requisitionMasterId;
    }

    public String getRequisitionCode() {
        return requisitionCode;
    }

    public void setRequisitionCode(String requisitionCode) {
        this.requisitionCode = requisitionCode;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public String getRequisitionDate() {
        return requisitionDate;
    }

    public void setRequisitionDate(String requisitionDate) {
        this.requisitionDate = requisitionDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getExpectedReceivingDate() {
        return expectedReceivingDate;
    }

    public void setExpectedReceivingDate(String expectedReceivingDate) {
        this.expectedReceivingDate = expectedReceivingDate;
    }

    public Integer getWarehouseFrom() {
        return warehouseFrom;
    }

    public void setWarehouseFrom(Integer warehouseFrom) {
        this.warehouseFrom = warehouseFrom;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFinanceStatus() {
        return financeStatus;
    }

    public void setFinanceStatus(String financeStatus) {
        this.financeStatus = financeStatus;
    }

}