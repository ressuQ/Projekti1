package fi.lappeensuksi.projekti.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fi.lappeensuksi.projekti.Lutemons.Lutemon;
import fi.lappeensuksi.projekti.R;

public class LutemonListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    private int recyclerViewId;
    private static final int moveFromHomeView = 0;
    private static final int standardView = 1;
    private static final int trainingView = 2;
    private static final int battleView = 3;
    private static final int moveFromTrainingView = 4;
    private static final int moveFromBattleView = 5;

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons, int recyclerViewId) {
        this.context = context;
        this.lutemons = lutemons;
        this.recyclerViewId = recyclerViewId;
    }

    @Override
    public int getItemViewType(int position) {
        if(recyclerViewId == R.id.rvHomeLutemons) {
            return standardView;
        } else if(recyclerViewId == R.id.rvListAll){
            return standardView;
        } else if(recyclerViewId == R.id.rvMoveFromHome) {
            return moveFromHomeView;
        } else if(recyclerViewId == R.id.rvTrainingLutemons) {
            return trainingView;
        } else if(recyclerViewId == R.id.rvBattleLutemons) {
            return battleView;
        } else if(recyclerViewId == R.id.rvMoveFromTraining) {
            return moveFromTrainingView;
        } else if(recyclerViewId == R.id.rvMoveFromBattle) {
            return moveFromBattleView;
        }
        return super.getItemViewType(position);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == standardView) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lutemon_view, parent, false);
            return new HomeLutemonViewHolder(itemView);
        } else if(viewType == moveFromHomeView) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.move_from_home_view, parent, false);
            return new MoveFromHomeLutemonViewHolder(itemView);
        } else if(viewType == moveFromTrainingView) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.move_from_training_view, parent, false);
            return new MoveFromTrainingLutemonViewHolder(itemView);
        } else if(viewType == moveFromBattleView) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.move_from_battle_view, parent, false);
            return new MoveFromBattleLutemonViewHolder(itemView);
        } else if(viewType == trainingView) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lutemon_training_view, parent, false);
            return new TrainingLutemonViewHolder(itemView);
        } else if(viewType == battleView) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lutemon_battle_view, parent, false);
            return new BattleLutemonViewHolder(itemView);
        } else {
            return null;
        }
    }
    
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(getItemViewType(position) == standardView) {
            HomeLutemonViewHolder homeLutemonViewHolder = (HomeLutemonViewHolder) holder;
            homeLutemonViewHolder.nameAndColor.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
            homeLutemonViewHolder.attack.setText("Attack: " + String.valueOf(lutemons.get(position).getAttack()));
            homeLutemonViewHolder.defence.setText("Defence: " + String.valueOf(lutemons.get(position).getDefence()));
            homeLutemonViewHolder.health.setText("Health: " + String.valueOf(lutemons.get(position).getHealth()) + "/" + String.valueOf(lutemons.get(position).getMaxHealth()));
            homeLutemonViewHolder.experience.setText("Experience: " + String.valueOf(lutemons.get(position).getExperience()));

        } else if(getItemViewType(position) == moveFromHomeView) {
            MoveFromHomeLutemonViewHolder moveFromHomeLutemonViewHolder = (MoveFromHomeLutemonViewHolder) holder;
            moveFromHomeLutemonViewHolder.nameAndColor.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
            moveFromHomeLutemonViewHolder.btnHomeToTraining.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = moveFromHomeLutemonViewHolder.getAdapterPosition();
                    Storage.getInstance().moveLutemon(lutemons.get(pos).getId(), "home", "training");
                    notifyItemRemoved(pos);
                }
            });
            moveFromHomeLutemonViewHolder.btnHomeToBattle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = moveFromHomeLutemonViewHolder.getAdapterPosition();
                    Storage.getInstance().moveLutemon(lutemons.get(pos).getId(), "home", "battle");
                    notifyItemRemoved(pos);
                }
            });

        } else if(getItemViewType(position) == moveFromTrainingView) {
            MoveFromTrainingLutemonViewHolder moveFromTrainingLutemonViewHolder = (MoveFromTrainingLutemonViewHolder) holder;
            moveFromTrainingLutemonViewHolder.nameAndColor.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
            moveFromTrainingLutemonViewHolder.btnTrainingToHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = moveFromTrainingLutemonViewHolder.getAdapterPosition();
                    Storage.getInstance().moveLutemon(lutemons.get(pos).getId(), "training", "home");
                    notifyItemRemoved(pos);
                }
            });
            moveFromTrainingLutemonViewHolder.btnTrainingToBattle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = moveFromTrainingLutemonViewHolder.getAdapterPosition();
                    Storage.getInstance().moveLutemon(lutemons.get(pos).getId(), "training", "battle");
                    notifyItemRemoved(pos);
                }
            });

        } else if(getItemViewType(position) == moveFromBattleView) {
            MoveFromBattleLutemonViewHolder moveFromBattleLutemonViewHolder = (MoveFromBattleLutemonViewHolder) holder;
            moveFromBattleLutemonViewHolder.nameAndColor.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
            moveFromBattleLutemonViewHolder.btnBattleToHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = moveFromBattleLutemonViewHolder.getAdapterPosition();
                    Storage.getInstance().moveLutemon(lutemons.get(pos).getId(), "battle", "home");
                    notifyItemRemoved(pos);
                }
            });
            moveFromBattleLutemonViewHolder.btnBattleToTraining.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = moveFromBattleLutemonViewHolder.getAdapterPosition();
                    Storage.getInstance().moveLutemon(lutemons.get(pos).getId(), "battle", "training");
                    notifyItemRemoved(pos);
                }
            });

        } else if(getItemViewType(position) == trainingView) {
            TrainingLutemonViewHolder trainingLutemonViewHolder = (TrainingLutemonViewHolder) holder;
            trainingLutemonViewHolder.nameAndColor.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
            trainingLutemonViewHolder.btnTrainLutemon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = trainingLutemonViewHolder.getAdapterPosition();
                    Storage.getInstance().trainLutemon(lutemons.get(pos).getId());
                }
            });

        } else if(getItemViewType(position) == battleView) {
            BattleLutemonViewHolder battleLutemonViewHolder = (BattleLutemonViewHolder) holder;
            battleLutemonViewHolder.nameAndColor.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
            /*IIKKA: SELVITÄ MITEN SAA TARKISTETTUA ONKO CHECKBOX TIKATTUNA: VEIKKAAN ETTÄ
            HIEMAN SAMAAN TYYLIIN KUIN ONCLOCK LISTENER ELI JOTENKIN NÄIN:

            battleLutemonViewHolder.cbChooseForBattle.isChecked()

             */
        }
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
