package UserDefinder;

        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class RequisitionAddModel {
    public class RequisitionDetailsModelForApp {

        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("color_name")
        @Expose
        private String colorName;
        @SerializedName("unit_name")
        @Expose
        private String unitName;
        @SerializedName("gift_for")
        @Expose
        private Object giftFor;
        @SerializedName("gift_quantity_for")
        @Expose
        private Object giftQuantityFor;
        @SerializedName("gift_quantity")
        @Expose
        private Integer giftQuantity;
        @SerializedName("stock_quantity")
        @Expose
        private Integer stockQuantity;
        @SerializedName("has_serial")
        @Expose
        private Boolean hasSerial;
        @SerializedName("is_package")
        @Expose
        private Boolean isPackage;
        @SerializedName("party_type_id")
        @Expose
        private Integer partyTypeId;
        @SerializedName("party_id")
        @Expose
        private Integer partyId;
        @SerializedName("warehouse_from")
        @Expose
        private Integer warehouseFrom;
        @SerializedName("total_amount")
        @Expose
        private Integer totalAmount;
        @SerializedName("requisition_details_id")
        @Expose
        private Integer requisitionDetailsId;
        @SerializedName("requisition_master_id")
        @Expose
        private Integer requisitionMasterId;
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
        private Integer deliveredQuantity;
        @SerializedName("gift_type")
        @Expose
        private Object giftType;
        @SerializedName("is_live_dummy")
        @Expose
        private Boolean isLiveDummy;
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
        private Integer amount;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getColorName() {
            return colorName;
        }

        public void setColorName(String colorName) {
            this.colorName = colorName;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public Object getGiftFor() {
            return giftFor;
        }

        public void setGiftFor(Object giftFor) {
            this.giftFor = giftFor;
        }

        public Object getGiftQuantityFor() {
            return giftQuantityFor;
        }

        public void setGiftQuantityFor(Object giftQuantityFor) {
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

        public Boolean getHasSerial() {
            return hasSerial;
        }

        public void setHasSerial(Boolean hasSerial) {
            this.hasSerial = hasSerial;
        }

        public Boolean getIsPackage() {
            return isPackage;
        }

        public void setIsPackage(Boolean isPackage) {
            this.isPackage = isPackage;
        }

        public Integer getPartyTypeId() {
            return partyTypeId;
        }

        public void setPartyTypeId(Integer partyTypeId) {
            this.partyTypeId = partyTypeId;
        }

        public Integer getPartyId() {
            return partyId;
        }

        public void setPartyId(Integer partyId) {
            this.partyId = partyId;
        }

        public Integer getWarehouseFrom() {
            return warehouseFrom;
        }

        public void setWarehouseFrom(Integer warehouseFrom) {
            this.warehouseFrom = warehouseFrom;
        }

        public Integer getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Integer totalAmount) {
            this.totalAmount = totalAmount;
        }

        public Integer getRequisitionDetailsId() {
            return requisitionDetailsId;
        }

        public void setRequisitionDetailsId(Integer requisitionDetailsId) {
            this.requisitionDetailsId = requisitionDetailsId;
        }

        public Integer getRequisitionMasterId() {
            return requisitionMasterId;
        }

        public void setRequisitionMasterId(Integer requisitionMasterId) {
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

        public Integer getDeliveredQuantity() {
            return deliveredQuantity;
        }

        public void setDeliveredQuantity(Integer deliveredQuantity) {
            this.deliveredQuantity = deliveredQuantity;
        }

        public Object getGiftType() {
            return giftType;
        }

        public void setGiftType(Object giftType) {
            this.giftType = giftType;
        }

        public Boolean getIsLiveDummy() {
            return isLiveDummy;
        }

        public void setIsLiveDummy(Boolean isLiveDummy) {
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

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

    }

    @SerializedName("RequisitionDetailsModelForApps")
    @Expose
    private List<RequisitionDetailsModelForApp> requisitionDetailsModelForApps = null;

    public List<RequisitionDetailsModelForApp> getRequisitionDetailsModelForApps() {
        return requisitionDetailsModelForApps;
    }

    public void setRequisitionDetailsModelForApps(List<RequisitionDetailsModelForApp> requisitionDetailsModelForApps) {
        this.requisitionDetailsModelForApps = requisitionDetailsModelForApps;
    }

}

