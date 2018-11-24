package ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.transactionsInfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Transactions {

    @SerializedName("OutcomeSum")
    private String outcomeSum;

    @SerializedName("IncomeSum")
    private String incomeSum;

    @SerializedName("MyOperations")
    private List<Operation> operations;

    public String getOutcomeSum() {
        return outcomeSum;
    }

    public void setOutcomeSum(String outcomeSum) {
        this.outcomeSum = outcomeSum;
    }

    public String getIncomeSum() {
        return incomeSum;
    }

    public void setIncomeSum(String incomeSum) {
        this.incomeSum = incomeSum;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
