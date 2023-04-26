package fi.lappeensuksi.projekti.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fi.lappeensuksi.projekti.Classes.LutemonListAdapter;
import fi.lappeensuksi.projekti.Classes.Storage;
import fi.lappeensuksi.projekti.R;

public class TrainingActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        storage = Storage.getInstance();

        System.out.println("Treeni listan koko: " + storage.getTrainingLutemons().size());

        recyclerView = findViewById(R.id.rvTrainingLutemons);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), storage.getTrainingLutemons(), R.id.rvTrainingLutemons));
    }
}