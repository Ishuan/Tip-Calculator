package com.example.ishanagarwal.hw01;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.sql.SQLSyntaxErrorException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button exitBtn;
    private EditText enterAmount;
    private TextView tipNumeric;
    private RadioGroup radGrp;
    private RadioButton radBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setting up the tip icon in action bar
        ActionBar ab = getSupportActionBar();
        //ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayShowTitleEnabled(true);
        ab.setIcon(R.drawable.tips);

        setTitle("Tip Calculator");

        //Setting the progress of the seekbar
        final SeekBar sBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView progressView = (TextView) findViewById(R.id.textView16);
        radGrp = findViewById(R.id.radioGroup);
        int val = radGrp.getCheckedRadioButtonId();
        radBtn = findViewById(val);

        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressView.setText(i + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        exitBtn = findViewById(R.id.button2);
        exitBtn.setOnClickListener(this);

        //Setting error on amount field
        enterAmount = findViewById(R.id.editText2);
        //final String str = enterAmount.getText().toString();
        enterAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String radBtnVal = radBtn.getText().toString();
                if (radBtnVal.equalsIgnoreCase("Custom")) {
                    Log.d("Demo", "Ishan");
                } else if(enterAmount.getText().toString().length()!=0){
                    String rad_val[] = radBtnVal.split("%");
                    String tipPercent = rad_val[0];
                    tipNumeric  = findViewById(R.id.textView14);
                    float calTip = (((Float.parseFloat(tipPercent))*Float.parseFloat(enterAmount.getText().toString())))/100+Float.parseFloat(enterAmount.getText().toString());
                    tipNumeric.setText(Float.toString(calTip)+"");


                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (enterAmount.getText().toString().length() == 0) {
                    enterAmount.setError("Enter Bill Total");
                }
            }
        });
    }



    @Override
    public void onClick(View view) {
        finish();
    }
}