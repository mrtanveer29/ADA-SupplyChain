package UserDefinder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;




public class RebateAndGiftModel {
    public class GiftList {

        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("color_name")
        @Expose
        private Object colorName;
        @SerializedName("unit_name")
        @Expose
        private Object unitName;
        @SerializedName("gift_for")
        @Expose
        private String giftFor;
        @SerializedName("gift_quantity_for")
        @Expose
        private Integer giftQuantityFor;
        @SerializedName("gift_quantity")
        @Expose
        private Integer giftQuantity;
        @SerializedName("stock_quantity")
        @Expose
        private Integer stockQuantity;
        @SerializedName("has_serial")
        @Expose
        private Object hasSerial;
        @SerializedName("is_package")
        @Expose
        private Boolean isPackage;
        @SerializedName("requisition_details_id")
        @Expose
        private Integer requisitionDetailsId;
        @SerializedName("requisition_master_id")
        @Expose
        private Object requisitionMasterId;
        @SerializedName("product_category_id")
        @Expose
        private Integer productCategoryId;
        @SerializedName("product_id")
        @Expose
        private Integer productId;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("unit_id")
        @Expose
        private Integer unitId;
        @SerializedName("color_id")
        @Expose
        private Integer colorId;
        @SerializedName("line_total")
        @Expose
        private Integer lineTotal;
        @SerializedName("brand_id")
        @Expose
        private Integer brandId;
        @SerializedName("is_gift")
        @Expose
        private Boolean isGift;
        @SerializedName("delivered_quantity")
        @Expose
        private Object deliveredQuantity;
        @SerializedName("gift_type")
        @Expose
        private Object giftType;
        @SerializedName("is_live_dummy")
        @Expose
        private Object isLiveDummy;
        @SerializedName("vat_pcnt")
        @Expose
        private Object vatPcnt;
        @SerializedName("tax_pcnt")
        @Expose
        private Object taxPcnt;
        @SerializedName("vat_amount")
        @Expose
        private Object vatAmount;
        @SerializedName("tax_amount")
        @Expose
        private Object taxAmount;
        @SerializedName("amount")
        @Expose
        private Object amount;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Object getColorName() {
            return colorName;
        }

        public void setColorName(Object colorName) {
            this.colorName = colorName;
        }

        public Object getUnitName() {
            return unitName;
        }

        public void setUnitName(Object unitName) {
            this.unitName = unitName;
        }

        public String getGiftFor() {
            return giftFor;
        }

        public void setGiftFor(String giftFor) {
            this.giftFor = giftFor;
        }

        public Integer getGiftQuantityFor() {
            return giftQuantityFor;
        }

        public void setGiftQuantityFor(Integer giftQuantityFor) {
            this.giftQuantityFor = giftQuantityFor;
        }

        public Integer getGiftQuantity() {
            return giftQuantity;
        }

        public void setGiftQuantity(Integer giftQuantity) {
            this.giftQuantity = giftQuantity;
        }

        public Integer getStockQuantity() {
            return stockQuantity;
        }

        public void setStockQuantity(Integer stockQuantity) {
            this.stockQuantity = stockQuantity;
        }

        public Object getHasSerial() {
            return hasSerial;
        }

        public void setHasSerial(Object hasSerial) {
            this.hasSerial = hasSerial;
        }

        public Boolean getIsPackage() {
            return isPackage;
        }

        public void setIsPackage(Boolean isPackage) {
            this.isPackage = isPackage;
        }

        public Integer getRequisitionDetailsId() {
            return requisitionDetailsId;
        }

        public void setRequisitionDetailsId(Integer requisitionDetailsId) {
            this.requisitionDetailsId = requisitionDetailsId;
        }

        public Object getRequisitionMasterId() {
            return requisitionMasterId;
        }

        public void setRequisitionMasterId(Object requisitionMasterId) {
            this.requisitionMasterId = requisitionMasterId;
        }

        public Integer getProductCategoryId() {
            return productCategoryId;
        }

        public void setProductCategoryId(Integer productCategoryId) {
            this.productCategoryId = productCategoryId;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getUnitId() {
            return unitId;
        }

        public void setUnitId(Integer unitId) {
            this.unitId = unitId;
        }

        public Integer getColorId() {
            return colorId;
        }

        public void setColorId(Integer colorId) {
            this.colorId = colorId;
        }

        public Integer getLineTotal() {
            return lineTotal;
        }

        public void setLineTotal(Integer lineTotal) {
            this.lineTotal = lineTotal;
        }

        public Integer getBrandId() {
            return brandId;
        }

        public void setBrandId(Integer brandId) {
            this.brandId = brandId;
        }

        public Boolean getIsGift() {
            return isGift;
        }

        public void setIsGift(Boolean isGift) {
            this.isGift = isGift;
        }

        public Object getDeliveredQuantity() {
            return deliveredQuantity;
        }

        public void setDeliveredQuantity(Object deliveredQuantity) {
            this.deliveredQuantity = deliveredQuantity;
        }

        public Object getGiftType() {
            return giftType;
        }

        public void setGiftType(Object giftType) {
            this.giftType = giftType;
        }

        public Object getIsLiveDummy() {
            return isLiveDummy;
        }

        public void setIsLiveDummy(Object isLiveDummy) {
            this.isLiveDummy = isLiveDummy;
        }

        public Object getVatPcnt() {
            return vatPcnt;
        }

        public void setVatPcnt(Object vatPcnt) {
            this.vatPcnt = vatPcnt;
        }

        public Object getTaxPcnt() {
            return taxPcnt;
        }

        public void setTaxPcnt(Object taxPcnt) {
            this.taxPcnt = taxPcnt;
        }

        public Object getVatAmount() {
            return vatAmount;
        }

        public void setVatAmount(Object vatAmount) {
            this.vatAmount = vatAmount;
        }

        public Object getTaxAmount() {
            return taxAmount;
        }

        public void setTaxAmount(Object taxAmount) {
            this.taxAmount = taxAmount;
        }

        public Object getAmount() {
            return amount;
        }

        public void setAmount(Object amount) {
            this.amount = amount;
        }

    }
    public class RebateList {

        @SerializedName("requisition_rebate_id")
        @Expose
        private Integer requisitionRebateId;
        @SerializedName("requisition_master_id")
        @Expose
        private Object requisitionMasterId;
        @SerializedName("rebate_for")
        @Expose
        private String rebateFor;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("amount")
        @Expose
        private Integer amount;
        @SerializedName("rebate")
        @Expose
        private Integer rebate;
        @SerializedName("rebate_type")
        @Expose
        private String rebateType;
        @SerializedName("rebate_amount")
        @Expose
        private Integer rebateAmount;
        @SerializedName("product_id")
        @Expose
        private Integer productId;
        @SerializedName("promotion_master_id")
        @Expose
        private Integer promotionMasterId;

        public Integer getRequisitionRebateId() {
            return requisitionRebateId;
        }

        public void setRequisitionRebateId(Integer requisitionRebateId) {
            this.requisitionRebateId = requisitionRebateId;
        }

        public Object getRequisitionMasterId() {
            return requisitionMasterId;
        }

        public void setRequisitionMasterId(Object requisitionMasterId) {
            this.requisitionMasterId = requisitionMasterId;
        }

        public String getRebateFor() {
            return rebateFor;
        }

        public void setRebateFor(String rebateFor) {
            this.rebateFor = rebateFor;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public Integer getRebate() {
            return rebate;
        }

        public void setRebate(Integer rebate) {
            this.rebate = rebate;
        }

        public String getRebateType() {
            return rebateType;
        }

        public void setRebateType(String rebateType) {
            this.rebateType = rebateType;
        }

        public Integer getRebateAmount() {
            return rebateAmount;
        }

        public void setRebateAmount(Integer rebateAmount) {
            this.rebateAmount = rebateAmount;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getPromotionMasterId() {
            return promotionMasterId;
        }

        public void setPromotionMasterId(Integer promotionMasterId) {
            this.promotionMasterId = promotionMasterId;
        }

    }

    @SerializedName("rebateList")
    @Expose
    private List<RebateList> rebateList = new ArrayList<>();
    @SerializedName("giftList")
    @Expose
    private List<GiftList> giftList = new ArrayList<>();

    public List<RebateList> getRebateList() {
        return rebateList;
    }

    public void setRebateList(List<RebateList> rebateList) {
        this.rebateList = rebateList;
    }

    public List<GiftList> getGiftList() {
        return giftList;
    }

    public void setGiftList(List<GiftList> giftList) {
        this.giftList = giftList;
    }

}


