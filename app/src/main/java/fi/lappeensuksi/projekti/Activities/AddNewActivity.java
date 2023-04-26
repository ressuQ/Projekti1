package fi.lappeensuksi.projekti.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import fi.lappeensuksi.projekti.Lutemons.Black;
import fi.lappeensuksi.projekti.Lutemons.Green;
import fi.lappeensuksi.projekti.Lutemons.Orange;
import fi.lappeensuksi.projekti.Lutemons.Pink;
import fi.lappeensuksi.projekti.Lutemons.White;
import fi.lappeensuksi.projekti.R;
import fi.lappeensuksi.projekti.Classes.Storage;

public class AddNewActivity extends AppCompatActivity {

    EditText editLutemonName;
    int id = 0;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        context = this;
    }

    public void addLutemon(View view) {

        editLutemonName = findViewById(R.id.editLutemonName);

        String name = editLutemonName.getText().toString();

        RadioGroup rgLutemonColor = findViewById(R.id.rgChooseColor);

        switch(rgLutemonColor.getCheckedRadioButtonId()) {
            case R.id.rbBlack:
                Storage.getInstance().addLutemon(new Black(name, id++));
                break;
            case R.id.rbGreen:
                Storage.getInstance().addLutemon(new Green(name, id++));
                break;
            case R.id.rbOrange:
                Storage.getInstance().addLutemon(new Orange(name, id++));
                break;
            case R.id.rbPink:
                Storage.getInstance().addLutemon(new Pink(name, id++));
                break;
            case R.id.rbWhite:
                Storage.getInstance().addLutemon(new White(name, id++));
                break;
        }

        //FOR SAVING AND LOADING LUTEMONS:
        //Storage.getInstance().saveLutemons(context);
    }
}