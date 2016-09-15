package edu.orangecoastcollege.cs273.tmorrissey1.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Controller for Shipping Calculator. Manages inputs/outputs between model and view.
 * @author Travs Morrissey
 */
public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private TextView baseCostTextView;
    private TextView addedCostTextView;
    private TextView totalCostTextView;
    private ShipItem shipItem = new ShipItem();
    private NumberFormat currency = NumberFormat.getCurrencyInstance();

    /**
     * Perform initialization of all fragments and loaders
     * @param savedInstanceState Last saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = (EditText) findViewById(R.id.weightEditText);
        baseCostTextView = (TextView) findViewById(R.id.baseCostTextView);
        addedCostTextView = (TextView) findViewById(R.id.addedCostTextView);
        totalCostTextView = (TextView) findViewById(R.id.totalCostTextView);

        weightEditText.addTextChangedListener(weightTextChangeListener);
        baseCostTextView.setText(currency.format(shipItem.getBaseCost()));
        updateTextViews();

    }

    private final TextWatcher weightTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        /**
         * On text changed event, updates the model and the view.
         */
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                int weight = s.length() > 0 ? Integer.parseInt(s.toString()) : 0;

                shipItem.setWeight(weight);
                updateTextViews();
            }
            catch (NumberFormatException e) {
                weightEditText.getText().clear();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    /**
     * Helper method to update the TextViews
     */
    private void updateTextViews() {
        addedCostTextView.setText(currency.format(shipItem.getAddedCost()));
        totalCostTextView.setText(currency.format(shipItem.getTotalCost()));
    }
}
