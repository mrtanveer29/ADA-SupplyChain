package UserDefinder;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;



public class RequisitionGiftAndRebate {
    public class RequisitionDetailsList {

        @SerializedName("brand_id")
        @Expose
        private Integer brandId;
        @SerializedName("color_id")
        @Expose
        private Integer colorId;
        @SerializedName("is_live_dummy")
        @Expose
        private Boolean isLiveDummy;
        @SerializedName("line_total")
        @Expose
        private Integer lineTotal;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("product_category_id")
        @Expose
        private Integer productCategoryId;
        @SerializedName("product_id")
        @Expose
        private Integer productId;
        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;

        public Integer getBrandId() {
            return brandId;
        }

        public void setBrandId(Integer brandId) {
            this.brandId = brandId;
        }

        public Integer getColorId() {
            return colorId;
        }

        public void setColorId(Integer colorId) {
            this.colorId = colorId;
        }

        public Boolean getIsLiveDummy() {
            return isLiveDummy;
        }

        public void setIsLiveDummy(Boolean isLiveDummy) {
            this.isLiveDummy = isLiveDummy;
        }

        public Integer getLineTotal() {
            return lineTotal;
        }

        public void setLineTotal(Integer lineTotal) {
            this.lineTotal = lineTotal;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
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

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

    }

    @SerializedName("RequisitionDetailsList")
    @Expose
    private List<RequisitionDetailsList> requisitionDetailsList = new ArrayList<>();
    @SerializedName("IsActivePromo")
    @Expose
    private Boolean isActivePromo;

    public List<RequisitionDetailsList> getRequisitionDetailsList() {
        return requisitionDetailsList;
    }

    public void setRequisitionDetailsList(List<RequisitionDetailsList> requisitionDetailsList) {
        this.requisitionDetailsList = requisitionDetailsList;
    }

    public Boolean getIsActivePromo() {
        return isActivePromo;
    }

    public void setIsActivePromo(Boolean isActivePromo) {
        this.isActivePromo = isActivePromo;
    }

}