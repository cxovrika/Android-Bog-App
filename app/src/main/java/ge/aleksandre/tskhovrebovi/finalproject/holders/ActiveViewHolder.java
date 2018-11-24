package ge.aleksandre.tskhovrebovi.finalproject.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ge.aleksandre.tskhovrebovi.finalproject.R;
import ge.aleksandre.tskhovrebovi.finalproject.api.ActiveEntry;

public class ActiveViewHolder extends RecyclerView.ViewHolder {

    private TextView titleText;
    private TextView amountText;
    private TextView blockHeaderText;

    public ActiveViewHolder(@NonNull View itemView) {
        super(itemView);
        titleText = itemView.findViewById(R.id.cell_active_item_title);
        amountText = itemView.findViewById(R.id.cell_active_item_amount);
        blockHeaderText = itemView.findViewById(R.id.cell_active_block_header);

    }

    public void setItemData(ActiveEntry entry) {
        titleText.setText(entry.getTitle() + ":");
        amountText.setText(entry.getValue());
    }

    public void setBlockHeaderData(String text) {
        blockHeaderText.setText(text);
    }
}
