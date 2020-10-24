package UserDefinder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jmjsa on 10/03/2017.
 */

public class InventoryListModel {
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("color_name")
    @Expose
    private String colorName;
    @SerializedName("color_id")
    @Expose
    private Integer colorId;
    @SerializedName("unit_name")
    @Expose
    private String unitName;
    @SerializedName("stock_quantity")
    @Expose
    private Integer stockQuantity;
    @SerializedName("lineTotalQty")
    @Expose
    private Integer lineTotalQty;

    public InventoryListModel(String productName,int lineTotalQty,String unitName) {
        this.productName=productName;
        this.lineTotalQty=lineTotalQty;
        this.unitName=unitName;
        this.stockQuantity=stockQuantity;
    }
    public InventoryListModel(String productName,int stockQuantity,String unitName,String colorName) {
        this.productName=productName;
        this.colorName=colorName;
        this.unitName=unitName;
        this.stockQuantity=stockQuantity;
    }
    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getLineTotalQty() {
        return lineTotalQty;
    }

    public void setLineTotalQty(Integer lineTotalQty) {
        this.lineTotalQty = lineTotalQty;
    }
}
