package fi.lappeensuksi.projekti.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import fi.lappeensuksi.projekti.Classes.LutemonListAdapter;
import fi.lappeensuksi.projekti.Classes.Storage;
import fi.lappeensuksi.projekti.Lutemons.Lutemon;
import fi.lappeensuksi.projekti.R;

public class BattleActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        storage = Storage.getInstance();

        System.out.println("Battle listan koko: " + storage.getBattleLutemons().size()); //VOI POISTAA

        recyclerView = findViewById(R.id.rvBattleLutemons);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), storage.getBattleLutemons(), R.id.rvBattleLutemons));

    }

    public void battle(View view) {
        Lutemon lutemon1 = storage.getLutemonById(storage.getBattleLutemons(), 0);
        Lutemon lutemon2 = storage.getLutemonById(storage.getBattleLutemons(), 1);
        String battlestring ="";
        int random;
        boolean exit = false;
        while (!exit) {
            random=(int)Math.random()*3;

            battlestring=battlestring+("1: " + lutemon1.getColor() + "(" + lutemon1.getName() + ") att: " + lutemon1.getAttack() + "; def: " + lutemon1.getDefence() + "; exp: " + lutemon1.getExperience() + "; health: " + lutemon1.getHealth() + "/" + lutemon1.getMaxHealth()+"\n");
            battlestring=battlestring+("2: " + lutemon2.getColor() + "(" + lutemon2.getName() + ") att: " + lutemon2.getAttack() + "; def: " + lutemon2.getDefence() + "; exp: " + lutemon2.getExperience() + "; health: " + lutemon2.getHealth() + "/" + lutemon2.getMaxHealth()+"\n");
            battlestring=battlestring+(lutemon1.getColor() + "(" + lutemon1.getName() + ") Attacks " + lutemon2.getColor() + "(" + lutemon2.getName() + ")\n");
            lutemon2.health = lutemon2.getHealth() - lutemon1.getAttack()-random + lutemon2.getDefence();
            if (lutemon2.getHealth() > 0) {
                battlestring=battlestring+(lutemon2.getColor() + "(" + lutemon2.getName() + ") manages to escape death.\n");
            } else {

                battlestring=battlestring+(lutemon2.getColor() + "(" + lutemon2.getName() + ") gets killed.\nThe battle is over.");
                exit = true;
                storage.getBattleLutemons().remove(1);
                break;
            }
            random=(int)Math.random()*3;
            battlestring=battlestring+("2: " + lutemon2.getColor() + "(" + lutemon2.getName() + ") att: " + lutemon2.getAttack() + "; def: " + lutemon2.getDefence() + "; exp: " + lutemon2.getExperience() + "; health: " + lutemon2.getHealth() + "/" + lutemon2.getMaxHealth()+"\n");
            battlestring=battlestring+("1: " + lutemon1.getColor() + "(" + lutemon1.getName() + ") att: " + lutemon1.getAttack() + "; def: " + lutemon1.getDefence() + "; exp: " + lutemon1.getExperience() + "; health: " + lutemon1.getHealth() + "/" + lutemon1.getMaxHealth()+"\n");
            battlestring=battlestring+(lutemon2.getColor() + "(" + lutemon2.getName() + ") Attacks " + lutemon1.getColor() + "(" + lutemon1.getName() + ")\n");

            lutemon1.health = lutemon1.getHealth() - lutemon2.getAttack()-random + lutemon1.getDefence();
            if (lutemon2.getHealth() > 0) {
                battlestring=battlestring+(lutemon1.getColor() + "(" + lutemon1.getName() + ") manages to escape death.\n");
            } else {

                battlestring=battlestring+(lutemon1.getColor() + "(" + lutemon1.getName() + ") gets killed.\nThe battle is over.");
                exit = true;
                storage.getBattleLutemons().remove(0);
            }
        }
        System.out.println(battlestring);
    }
}
