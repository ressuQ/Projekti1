package fi.lappeensuksi.projekti.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fi.lappeensuksi.projekti.R;

public class MoveFromWhereActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_from_where);
    }

    public void switchToMoveFromHome(View view) {
        Intent intent = new Intent(this, MoveFromHomeActivity.class);
        startActivity(intent);
    }

    public void switchToMoveFromTraining(View view) {
        Intent intent = new Intent(this, MoveFromTrainingActivity.class);
        startActivity(intent);
    }

    public void switchToMoveFromBattle(View view) {
        Intent intent = new Intent(this, MoveFromBattleActivity.class);
        startActivity(intent);
    }
}