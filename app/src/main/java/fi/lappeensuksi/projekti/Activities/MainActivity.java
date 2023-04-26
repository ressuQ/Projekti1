package fi.lappeensuksi.projekti.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fi.lappeensuksi.projekti.R;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* FOR LOADING LUTEMONS
        context = MainActivity.this;
        Storage.getInstance().loadLutemons();*/
    }

    public void switchToAddNewLutemon(View view) {
        Intent intent = new Intent(this, AddNewActivity.class);
        startActivity(intent);
    }

    public void switchToListAllLutemons(View view) {
        Intent intent = new Intent(this, ListAllActivity.class);
        startActivity(intent);
    }

    public void switchToMoveLutemons(View view) {
        Intent intent = new Intent(this, MoveFromWhereActivity.class);
        startActivity(intent);
    }

    public void switchToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void switchToTraining(View view) {
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }

    public void switchToBattle(View view) {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }
}