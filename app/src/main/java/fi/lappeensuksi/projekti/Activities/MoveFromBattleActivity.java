package fi.lappeensuksi.projekti.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fi.lappeensuksi.projekti.Classes.LutemonListAdapter;
import fi.lappeensuksi.projekti.Classes.Storage;
import fi.lappeensuksi.projekti.R;

public class MoveFromBattleActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_from_battle);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvMoveFromBattle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), storage.getBattleLutemons(), R.id.rvMoveFromBattle));
    }
}