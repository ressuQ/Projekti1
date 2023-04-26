package fi.lappeensuksi.projekti.Classes;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fi.lappeensuksi.projekti.R;

public class MoveFromTrainingLutemonViewHolder extends RecyclerView.ViewHolder{

    TextView nameAndColor;
    Button btnTrainingToHome, btnTrainingToBattle;

    public MoveFromTrainingLutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        nameAndColor =itemView.findViewById(R.id.txtName);
        btnTrainingToHome = itemView.findViewById(R.id.btnTrainingToHome);
        btnTrainingToBattle = itemView.findViewById(R.id.btnTrainingToBattle);

    }
}
