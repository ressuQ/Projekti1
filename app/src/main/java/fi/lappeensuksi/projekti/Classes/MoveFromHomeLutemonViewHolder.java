package fi.lappeensuksi.projekti.Classes;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fi.lappeensuksi.projekti.R;

public class MoveFromHomeLutemonViewHolder extends RecyclerView.ViewHolder {

    TextView nameAndColor;
    Button btnHomeToTraining, btnHomeToBattle;

    public MoveFromHomeLutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        nameAndColor =itemView.findViewById(R.id.txtName);
        btnHomeToTraining = itemView.findViewById(R.id.btnHomeToTraining);
        btnHomeToBattle = itemView.findViewById(R.id.btnHomeToBattle);
    }
}
