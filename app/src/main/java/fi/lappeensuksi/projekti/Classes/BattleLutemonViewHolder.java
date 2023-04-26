package fi.lappeensuksi.projekti.Classes;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fi.lappeensuksi.projekti.R;

public class BattleLutemonViewHolder extends RecyclerView.ViewHolder{

    TextView nameAndColor;
    CheckBox cbChooseForBattle;

    public BattleLutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        nameAndColor = itemView.findViewById(R.id.txtName);
        cbChooseForBattle = itemView.findViewById(R.id.cbChooseForBattle);
    }
}
