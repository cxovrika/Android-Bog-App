package ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.profileinfo;

import com.google.gson.annotations.SerializedName;

public class ClientAddress {

    @SerializedName("AddressType")
    private String addressType;

    @SerializedName("ClientKey")
    private String clientKey;

    @SerializedName("CountryCode")
    private String countryCode;

    @SerializedName("RegionCode")
    private String regionCode;

    @SerializedName("Street")
    private String street;

    @SerializedName("Building")
    private String building;

    @SerializedName("Appartment")
    private String appartment;

    @SerializedName("District")
    private String district;

    @SerializedName("NonCity")
    private String nonCity;

    @SerializedName("UrbanType")
    private String urbanType;

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getAppartment() {
        return appartment;
    }

    public void setAppartment(String appartment) {
        this.appartment = appartment;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNonCity() {
        return nonCity;
    }

    public void setNonCity(String nonCity) {
        this.nonCity = nonCity;
    }

    public String getUrbanType() {
        return urbanType;
    }

    public void setUrbanType(String urbanType) {
        this.urbanType = urbanType;
    }
}
