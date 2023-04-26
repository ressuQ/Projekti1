package fi.lappeensuksi.projekti.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fi.lappeensuksi.projekti.Classes.LutemonListAdapter;
import fi.lappeensuksi.projekti.Classes.Storage;
import fi.lappeensuksi.projekti.R;

public class MoveFromHomeActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_from_home);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvMoveFromHome);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), storage.getHomeLutemons(), R.id.rvMoveFromHome));
    }


}