package fi.lappeensuksi.projekti.Classes;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fi.lappeensuksi.projekti.R;

public class MoveFromBattleLutemonViewHolder extends RecyclerView.ViewHolder {

    TextView nameAndColor;
    Button btnBattleToHome, btnBattleToTraining;

    public MoveFromBattleLutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        nameAndColor =itemView.findViewById(R.id.txtName);
        btnBattleToHome = itemView.findViewById(R.id.btnBattleToHome);
        btnBattleToTraining = itemView.findViewById(R.id.btnBattleToTraining);
    }
}
