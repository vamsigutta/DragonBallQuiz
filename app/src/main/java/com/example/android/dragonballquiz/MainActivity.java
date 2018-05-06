package com.example.android.dragonballquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSubmit(View view) {
        EditText seriesName = (EditText) findViewById(R.id.answer_one);
        String series = seriesName.getText().toString();
        int score = 0;
        if (series.contains("super") || series.contains("Super")) {
            score++;
        }
        EditText gohanName = (EditText) findViewById(R.id.answer_four);
        String gohan = gohanName.getText().toString();
        if (gohan == "gohan" || gohan == "Gohan" || gohan.contains("gohan") || gohan.contains("Gohan")) {
            score++;
        }
        EditText bardockName = (EditText) findViewById(R.id.answer_five);
        String bardock = bardockName.getText().toString();
        if (bardock == "bardock" || bardock == "Bardock" || bardock.contains("bardock") || bardock.contains("Bardock")) {
            score++;
        }
        score += maleCheckbox();
//        score += femaleRadio ();

        TextView result = (TextView) findViewById(R.id.result);
        if (score > 2) {
            result.setText("True Fan");
        } else {
            result.setText("Normal Fan");
        }

    }

    private int maleCheckbox() {
        CheckBox vegetabox = (CheckBox) findViewById(R.id.vegeta_box);
        CheckBox gokubox = (CheckBox) findViewById(R.id.goku_box);
        CheckBox androidbox = (CheckBox) findViewById(R.id.android_box);
        CheckBox gohanbox = (CheckBox) findViewById(R.id.gohan_box);
        int sum = 0;

        if (vegetabox.isChecked()) {
            sum += 3;
        }
        if (gokubox.isChecked()) {
            sum += 5;
        }
        if (androidbox.isChecked()) {
            sum-= 2;
        }
        if (gohanbox.isChecked()) {
            sum+= 2;
        }

        if (sum > 2) {
            return 1;
        }
        return 0;
    }

    public void femaleRadio(View view){
        RadioGroup radioDefaultGroup = (RadioGroup) findViewById(R.id.radio_id);
        radioDefaultGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group1,int checkedID) {
                if (checkedID == R.id.bulma_button) {
                    Toast.makeText(getApplicationContext(),"Checked: Bulma", Toast.LENGTH_LONG).show();

                } else if(checkedID == R.id.chichi_button) {
                    Toast.makeText(getApplicationContext(), "Checked: Chi Chi", Toast.LENGTH_SHORT).show();

                } else if(checkedID == R.id.Android_button) {
                    Toast.makeText(getApplicationContext(),"Checked: Andorid 18",Toast.LENGTH_LONG).show();

                } else if (checkedID == R.id.videl_button) {
                    Toast.makeText(getApplicationContext(),"Checked: Videl",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
