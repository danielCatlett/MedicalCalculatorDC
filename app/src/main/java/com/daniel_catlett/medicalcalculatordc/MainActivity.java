package com.daniel_catlett.medicalcalculatordc;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText weight = (EditText)findViewById(R.id.txtWeight);
        final RadioButton lbToKg = (RadioButton)findViewById(R.id.radLbToKg);
        final RadioButton kgToLb = (RadioButton)findViewById(R.id.radKgToLb);
        final TextView result = (TextView)findViewById(R.id.txtResults);
        Button convert = (Button)findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");
                if(lbToKg.isChecked())
                {
                    if(weightEntered <= 500)
                    {
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(tenth.format(convertedWeight) + " kilograms");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_LONG).show();
                    }
                }
                if(kgToLb.isChecked())
                {
                    if(weightEntered <= 225)
                    {
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(tenth.format(convertedWeight) + " pounds");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Kilos must be less than 225", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
