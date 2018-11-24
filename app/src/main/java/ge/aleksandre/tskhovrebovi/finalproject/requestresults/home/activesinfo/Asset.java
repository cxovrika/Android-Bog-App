package ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.activesinfo;

import com.google.gson.annotations.SerializedName;

import ge.aleksandre.tskhovrebovi.finalproject.api.ActiveEntry;

public class Asset implements ActiveEntry {

    @SerializedName("ProductType")
    private String productType;

    @SerializedName("AmountBase")
    private String amountBase;

    @SerializedName("ProductName")
    private String productName;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getAmountBase() {
        return amountBase;
    }

    public void setAmountBase(String amountBase) {
        this.amountBase = amountBase;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String getTitle() {
        return productName;
    }

    @Override
    public String getValue() {
        return amountBase;
    }
}
