package model;

/**
 * Created by jmjsa on 06/03/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryListInfo {

    @SerializedName("delivery_master_id")
    @Expose
    private Integer deliveryMasterId;
    @SerializedName("delivery_no")
    @Expose
    private String deliveryNo;
    @SerializedName("delivery_date")
    @Expose
    private String deliveryDate;
    @SerializedName("party_id")
    @Expose
    private Integer partyId;
    @SerializedName("party_name")
    @Expose
    private String partyName;
    @SerializedName("total_amount")
    @Expose
    private Double totalAmount;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("requisition_code")
    @Expose
    private String requisitionCode;
    @SerializedName("created_date")
    @Expose
    private String createdDate;

    public Integer getDeliveryMasterId() {
        return deliveryMasterId;
    }

    public void setDeliveryMasterId(Integer deliveryMasterId) {
        this.deliveryMasterId = deliveryMasterId;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequisitionCode() {
        return requisitionCode;
    }

    public void setRequisitionCode(String requisitionCode) {
        this.requisitionCode = requisitionCode;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
