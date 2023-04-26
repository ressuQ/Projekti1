package fi.lappeensuksi.projekti.Classes;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fi.lappeensuksi.projekti.R;

public class TrainingLutemonViewHolder extends RecyclerView.ViewHolder{

    TextView nameAndColor;
    Button btnTrainLutemon;

    public TrainingLutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        nameAndColor = itemView.findViewById(R.id.txtName);
        btnTrainLutemon = itemView.findViewById(R.id.btnTrain);
    }
}
