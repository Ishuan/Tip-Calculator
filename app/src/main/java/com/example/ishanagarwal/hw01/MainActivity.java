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
    private RadioButton tenBtn;
    private RadioButton fifteenBtn;
    private RadioButton eighteenBtn;
    private RadioButton custBtn;
    private TextView total;
    private String tenPer;
    private String fifteenPer;
    private String eighteenPer;
    private String tipPercent;
    private String[] percentage={};
    private String amt;
    private float progBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.mipmap.ic_tips);

        ab.setTitle("Tip Calculator");

        final SeekBar sBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView progressView = (TextView) findViewById(R.id.textView16);
        radGrp = findViewById(R.id.radioGroup);
        int val = radGrp.getCheckedRadioButtonId();
        radBtn = findViewById(val);
        String s=radBtn.getText().toString();
        percentage = s.split("%");
        tipPercent = percentage[0];
        custBtn = findViewById(R.id.radioButton3);


        tenBtn = findViewById(R.id.radioButton);
        fifteenBtn = findViewById(R.id.radioButton4);
        eighteenBtn = findViewById(R.id.radioButton2);

        tenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenPer = tenBtn.getText().toString();
                percentage = tenPer.split("%");
                tipPercent = percentage[0];
                Log.d("name", tipPercent);
                amt = enterAmount.getText().toString();
                if (enterAmount.getText().toString().length() != 0) {
                    tipNumeric = findViewById(R.id.textView14);
                    tipNumeric.setText(tipPercent);
                    total = findViewById(R.id.textView15);
                    if (tipPercent != null) {
                        float calTip = (((Float.parseFloat(tipPercent)) *
                                Float.parseFloat(enterAmount.getText().toString()))) / 100 +
                                Float.parseFloat(enterAmount.getText().toString());
                        total.setText(Float.toString(calTip));
                    }
                }
            }
        });

        fifteenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fifteenPer = fifteenBtn.getText().toString();
                percentage = fifteenPer.split("%");
                tipPercent = percentage[0];
                Log.d("name",tipPercent);
                if(enterAmount.getText().toString().length()!=0) {
                    tipNumeric = findViewById(R.id.textView14);
                    tipNumeric.setText(tipPercent);
                    total = findViewById(R.id.textView15);
                    if (tipPercent != null) {
                        float calTip = (((Float.parseFloat(tipPercent)) *
                                Float.parseFloat(enterAmount.getText().toString()))) / 100 +
                                Float.parseFloat(enterAmount.getText().toString());
                        total.setText(Float.toString(calTip));
                    }}
            }
        });

        eighteenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 eighteenPer = eighteenBtn.getText().toString();
                percentage = eighteenPer.split("%");
                tipPercent = percentage[0];
                Log.d("name",tipPercent);
                if(enterAmount.getText().toString().length()!=0) {
                    tipNumeric = findViewById(R.id.textView14);
                    tipNumeric.setText(tipPercent);
                    total = findViewById(R.id.textView15);
                    if (tipPercent != null) {
                        float calTip = (((Float.parseFloat(tipPercent)) *
                                Float.parseFloat(enterAmount.getText().toString()))) / 100 +
                                Float.parseFloat(enterAmount.getText().toString());
                        total.setText(Float.toString(calTip));
                    }
                }
            }
        });

        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressView.setText(i + "%");
                custBtn.setChecked(true);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                progBar = seekBar.getProgress();
                if(enterAmount.getText().toString().length()!=0) {
                    tipNumeric = findViewById(R.id.textView14);
                    tipNumeric.setText(Float.toString(progBar));
                    total = findViewById(R.id.textView15);
                    if (Float.toString(progBar) != null) {
                        float calTip = ((progBar * Float.parseFloat(enterAmount.getText().toString()
                        ))) / 100 + Float.parseFloat(enterAmount.getText().toString());
                        total.setText(Float.toString(calTip));
                    }
                }

            }
        });

        custBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = progressView.getText().toString();
                percentage = str.split("%");
                tipPercent = percentage[0];
                if (enterAmount.getText().toString().length() != 0) {
                    tipNumeric = findViewById(R.id.textView14);
                    tipNumeric.setText(str);
                    total = findViewById(R.id.textView15);
                    if (tipPercent != null) {
                        float calTip = ((Float.parseFloat(tipPercent) *
                                Float.parseFloat(enterAmount.getText().toString()))) / 100 +
                                Float.parseFloat(enterAmount.getText().toString());
                        total.setText(Float.toString(calTip));
                    }
                }
            }
        });


        exitBtn = findViewById(R.id.button2);
        exitBtn.setOnClickListener(this);

        //Setting error on amount field
        enterAmount = findViewById(R.id.editText2);
        enterAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if(enterAmount.getText().toString().length()!=0) {

                    tipNumeric = findViewById(R.id.textView14);
                    tipNumeric.setText(tipPercent);
                    total = findViewById(R.id.textView15);
                    if (tipPercent != null) {
                        float calTip = (((Float.parseFloat(tipPercent)) *
                                Float.parseFloat(enterAmount.getText().toString()))) / 100 +
                                Float.parseFloat(enterAmount.getText().toString());
                        total.setText(Float.toString(calTip));
                    }
                }
                }

            @Override
            public void afterTextChanged(Editable editable) {

                if (enterAmount.getText().toString().length() == 0) {
                    enterAmount.setError("Enter Bill Total");
                    double def_tip = 0.00;
                    double def_total = 0.00;
                    tipNumeric.setText(Double.toString(def_tip));
                    total.setText(Double.toString(def_total));

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
