package model;

/**
 * Created by jmjsa on 04/03/2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_code")
    @Expose
    private String productCode;
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
    @SerializedName("product_category_name")
    @Expose
    private String productCategoryName;
    @SerializedName("has_serial")
    @Expose
    private Boolean hasSerial;
    @SerializedName("has_warrenty")
    @Expose
    private Boolean hasWarrenty;
    @SerializedName("warrenty_type")
    @Expose
    private String warrentyType;
    @SerializedName("warrenty_value")
    @Expose
    private Double warrentyValue;
    @SerializedName("rp_price")
    @Expose
    private Double rpPrice;
    @SerializedName("md_price")
    @Expose
    private Double mdPrice;
    @SerializedName("mrp_price")
    @Expose
    private Double mrpPrice;
    @SerializedName("bs_price")
    @Expose
    private Double bsPrice;
    @SerializedName("vat_percentage")
    @Expose
    private Double vatPercentage;
    @SerializedName("tax_percentage")
    @Expose
    private Double taxPercentage;

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

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public Boolean getHasSerial() {
        return hasSerial;
    }

    public void setHasSerial(Boolean hasSerial) {
        this.hasSerial = hasSerial;
    }

    public Boolean getHasWarrenty() {
        return hasWarrenty;
    }

    public void setHasWarrenty(Boolean hasWarrenty) {
        this.hasWarrenty = hasWarrenty;
    }

    public String getWarrentyType() {
        return warrentyType;
    }

    public void setWarrentyType(String warrentyType) {
        this.warrentyType = warrentyType;
    }

    public Double getWarrentyValue() {
        return warrentyValue;
    }

    public void setWarrentyValue(Double warrentyValue) {
        this.warrentyValue = warrentyValue;
    }

    public Double getRpPrice() {
        return rpPrice;
    }

    public void setRpPrice(Double rpPrice) {
        this.rpPrice = rpPrice;
    }

    public Double getMdPrice() {
        return mdPrice;
    }

    public void setMdPrice(Double mdPrice) {
        this.mdPrice = mdPrice;
    }

    public Double getMrpPrice() {
        return mrpPrice;
    }

    public void setMrpPrice(Double mrpPrice) {
        this.mrpPrice = mrpPrice;
    }

    public Double getBsPrice() {
        return bsPrice;
    }

    public void setBsPrice(Double bsPrice) {
        this.bsPrice = bsPrice;
    }

    public Double getVatPercentage() {
        return vatPercentage;
    }

    public void setVatPercentage(Double vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    @Override
    public String toString() {
        return productName;
    }
}
