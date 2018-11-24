package ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.transactionsInfo;

import com.google.gson.annotations.SerializedName;

public class Operation {
    @SerializedName("AcctKey")
    private String acctKey;

    @SerializedName("EntryId")
    private String entryId;

    @SerializedName("Nomination")
    private String nomination;

    @SerializedName("EntryGroup")
    private String entryGroup;

    @SerializedName("MerchantId")
    private String merchantId;

    @SerializedName("Date")
    private String date;

    @SerializedName("Amount")
    private String amount;

    @SerializedName("Ccy")
    private String ccy;

    @SerializedName("DocNomination")
    private String docNomination;

    @SerializedName("Beneficiary")
    private String beneficiary;

    @SerializedName("DstAcc")
    private String dstAcc;

    @SerializedName("SrcAcc")
    private String srcAcc;

    @SerializedName("MerchantName")
    private String merchantName;

    @SerializedName("MerchantNameInt")
    private String merchantNameInt;

    @SerializedName("AmountBase")
    private String amountBase;

    @SerializedName("EntryGroupName")
    private String entryGroupName;

    @SerializedName("EntryGroupNameId")
    private String entryGroupNameId;

    @SerializedName("ServiceId")
    private String serviceId;

    @SerializedName("PostDate")
    private String postDate;

    public String getAcctKey() {
        return acctKey;
    }

    public void setAcctKey(String acctKey) {
        this.acctKey = acctKey;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }

    public String getEntryGroup() {
        return entryGroup;
    }

    public void setEntryGroup(String entryGroup) {
        this.entryGroup = entryGroup;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getDocNomination() {
        return docNomination;
    }

    public void setDocNomination(String docNomination) {
        this.docNomination = docNomination;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getDstAcc() {
        return dstAcc;
    }

    public void setDstAcc(String dstAcc) {
        this.dstAcc = dstAcc;
    }

    public String getSrcAcc() {
        return srcAcc;
    }

    public void setSrcAcc(String srcAcc) {
        this.srcAcc = srcAcc;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantNameInt() {
        return merchantNameInt;
    }

    public void setMerchantNameInt(String merchantNameInt) {
        this.merchantNameInt = merchantNameInt;
    }

    public String getAmountBase() {
        return amountBase;
    }

    public void setAmountBase(String amountBase) {
        this.amountBase = amountBase;
    }

    public String getEntryGroupName() {
        return entryGroupName;
    }

    public void setEntryGroupName(String entryGroupName) {
        this.entryGroupName = entryGroupName;
    }

    public String getEntryGroupNameId() {
        return entryGroupNameId;
    }

    public void setEntryGroupNameId(String entryGroupNameId) {
        this.entryGroupNameId = entryGroupNameId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }
}
