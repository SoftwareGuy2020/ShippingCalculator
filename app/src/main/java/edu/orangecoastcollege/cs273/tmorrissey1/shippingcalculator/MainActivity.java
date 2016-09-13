package edu.orangecoastcollege.cs273.tmorrissey1.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TextView moneyTextView = (TextView) findViewById(R.id.moneyTextView);
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
