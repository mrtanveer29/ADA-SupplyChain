package UserDefinder;

/**
 * Created by jmjsa on 07/03/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryChallanReportModel {

    @SerializedName("delivery_no")
    @Expose
    private String deliveryNo;
    @SerializedName("lot_no")
    @Expose
    private String lotNo;
    @SerializedName("delivery_date")
    @Expose
    private String deliveryDate;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("requisition_code")
    @Expose
    private String requisitionCode;
    @SerializedName("party_name")
    @Expose
    private String partyName;
    @SerializedName("from_warehouse_name")
    @Expose
    private String fromWarehouseName;
    @SerializedName("to_warehouse_name")
    @Expose
    private String toWarehouseName;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_category_name")
    @Expose
    private String productCategoryName;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("color_name")
    @Expose
    private String colorName;
    @SerializedName("imei_no")
    @Expose
    private String imeiNo;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("delivery_details_id")
    @Expose
    private Integer deliveryDetailsId;
    @SerializedName("delivered_quantity")
    @Expose
    private Integer deliveredQuantity;
    @SerializedName("deliverable_quantity")
    @Expose
    private Integer deliverableQuantity;
    @SerializedName("unit_price")
    @Expose
    private Double unitPrice;
    @SerializedName("total_amount")
    @Expose
    private Double totalAmount;
    @SerializedName("line_total")
    @Expose
    private Double lineTotal;
    @SerializedName("is_gift")
    @Expose
    private Boolean isGift;
    @SerializedName("gift_type")
    @Expose
    private String giftType;
    @SerializedName("is_live_dummy")
    @Expose
    private Boolean isLiveDummy;
    @SerializedName("party_type_id")
    @Expose
    private Integer partyTypeId;

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRequisitionCode() {
        return requisitionCode;
    }

    public void setRequisitionCode(String requisitionCode) {
        this.requisitionCode = requisitionCode;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getFromWarehouseName() {
        return fromWarehouseName;
    }

    public void setFromWarehouseName(String fromWarehouseName) {
        this.fromWarehouseName = fromWarehouseName;
    }

    public String getToWarehouseName() {
        return toWarehouseName;
    }

    public void setToWarehouseName(String toWarehouseName) {
        this.toWarehouseName = toWarehouseName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getImeiNo() {
        return imeiNo;
    }

    public void setImeiNo(String imeiNo) {
        this.imeiNo = imeiNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDeliveryDetailsId() {
        return deliveryDetailsId;
    }

    public void setDeliveryDetailsId(Integer deliveryDetailsId) {
        this.deliveryDetailsId = deliveryDetailsId;
    }

    public Integer getDeliveredQuantity() {
        return deliveredQuantity;
    }

    public void setDeliveredQuantity(Integer deliveredQuantity) {
        this.deliveredQuantity = deliveredQuantity;
    }

    public Integer getDeliverableQuantity() {
        return deliverableQuantity;
    }

    public void setDeliverableQuantity(Integer deliverableQuantity) {
        this.deliverableQuantity = deliverableQuantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(Double lineTotal) {
        this.lineTotal = lineTotal;
    }

    public Boolean getIsGift() {
        return isGift;
    }

    public void setIsGift(Boolean isGift) {
        this.isGift = isGift;
    }

    public String getGiftType() {
        return giftType;
    }

    public void setGiftType(String giftType) {
        this.giftType = giftType;
    }

    public Boolean getIsLiveDummy() {
        return isLiveDummy;
    }

    public void setIsLiveDummy(Boolean isLiveDummy) {
        this.isLiveDummy = isLiveDummy;
    }

    public Integer getPartyTypeId() {
        return partyTypeId;
    }

    public void setPartyTypeId(Integer partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

}