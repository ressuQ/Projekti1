package fi.lappeensuksi.projekti.Classes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fi.lappeensuksi.projekti.R;

public class HomeLutemonViewHolder extends RecyclerView.ViewHolder {

    TextView nameAndColor, attack, defence, experience, health;

    public HomeLutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        nameAndColor =itemView.findViewById(R.id.txtName);
        attack = itemView.findViewById(R.id.txtAttack);
        defence = itemView.findViewById(R.id.txtDefence);
        health = itemView.findViewById(R.id.txtHealth);
        experience = itemView.findViewById(R.id.txtExperience);
    }
}
