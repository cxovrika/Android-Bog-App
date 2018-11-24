package ge.aleksandre.tskhovrebovi.finalproject.holders;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import ge.aleksandre.tskhovrebovi.finalproject.R;
import ge.aleksandre.tskhovrebovi.finalproject.requestresults.home.transactionsInfo.Operation;

public class TransactionViewHolder extends RecyclerView.ViewHolder {

    TextView transactionDate;
    TextView transactionMerchant;
    TextView transactionType;
    TextView transactionAmount;

    public TransactionViewHolder(@NonNull View itemView) {
        super(itemView);
        transactionDate = itemView.findViewById(R.id.transaction_date_text);
        transactionMerchant = itemView.findViewById(R.id.transaction_merchant_text);
        transactionType = itemView.findViewById(R.id.transaction_type_text);
        transactionAmount = itemView.findViewById(R.id.transaction_amount_change);
    }

    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})
    public void setData(Operation op) {

        if (op.getMerchantName() != null) {
            transactionMerchant.setText(op.getMerchantName());
        } else if (op.getBeneficiary() != null){
            transactionMerchant.setText(op.getBeneficiary());
        } else {
            transactionMerchant.setText("საქართველოს ბანკი");
        }
        transactionType.setText(op.getEntryGroupName());
        transactionAmount.setText("-" + op.getAmount());

        String dateString = op.getPostDate();
        long dataLong = Long.parseLong(dateString);
        Date date = new java.util.Date(dataLong);

        if (DateUtils.isToday(dataLong)) {
            transactionDate.setText("დღეს");
        }
        if (DateUtils.isToday(dataLong + 24*60*60*1000)) {
            transactionDate.setText("გუშინ");
        } else {
            transactionDate.setText(new SimpleDateFormat("dd.MM.yyyy").format(date));
        }
    }

}
