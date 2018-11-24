package ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.activesinfo;

import com.google.gson.annotations.SerializedName;

import ge.aleksandre.tskhovrebovi.finalproject.api.ActiveEntry;

public class Pointt implements ActiveEntry {

    @SerializedName("Id")
    private String id;

    @SerializedName("ProductName")
    private String productName;

    @SerializedName("OrderNo")
    private String orderNo;

    @SerializedName("Amount")
    private String amount;

    @SerializedName("ProdType")
    private String prodType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    @Override
    public String getTitle() {
        return productName;
    }

    @Override
    public String getValue() {
        return amount;
    }
}
