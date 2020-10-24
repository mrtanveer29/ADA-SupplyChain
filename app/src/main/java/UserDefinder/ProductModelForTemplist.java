package UserDefinder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jmjsa on 04/03/2017.
 */

public class ProductModelForTemplist {
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("unit_id")
    @Expose
    private Integer unitId;
    @SerializedName("unit_name")
    @Expose
    private String unitName;
    @SerializedName("brand_id")
    @Expose
    private Integer brandId;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("product_category_id")
    @Expose
    private Integer productCategoryId;
    @SerializedName("product_code")
    @Expose
    private String productCode;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("color_id")
    @Expose
    private Integer colorId;
    @SerializedName("color_name")
    @Expose
    private String colorName;
    @SerializedName("line_total")
    @Expose
    private Double line_total;
    @SerializedName("is_live_dummy")
    @Expose
    private boolean is_live_dummy;

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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getLine_total() {
        return line_total;
    }

    public void setLine_total(Double line_total) {
        this.line_total = line_total;
    }

    public boolean is_live_dummy() {
        return is_live_dummy;
    }

    public void setIs_live_dummy(boolean is_live_dummy) {
        this.is_live_dummy = is_live_dummy;
    }
}
