package com.example.wana.justjave1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {
    int quantity = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void increment(View view) {

        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);

    }


    public void submitOrder(View view) {
        EditText namefield = (EditText) findViewById(R.id.name_field);
        String name = namefield.getText().toString();
        Log.v("MainActivity", "Name: " + name);
        // CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();


        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(name,price, hasWhippedCream,hasChocolate);
        displayMessage(priceMessage);

    }

    private int calculatePrice(boolean hasWhippedCream,boolean hasChocolate) {
        int basePrice = 5;
        if (hasWhippedCream){
            basePrice = basePrice + 1;
        }

        if (hasChocolate){
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }

    private String createOrderSummary(String name ,int price,boolean hasWhippedCream,boolean hasChocolate ) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream?" + hasWhippedCream;
        priceMessage += "\nAdd chocolate?" + hasChocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal Due $ " + price;
        priceMessage = priceMessage + " \nWoow " + " Thank you";
        return priceMessage;

    }

    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);

    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.orderSummary_text_view);
        orderSummaryTextView.setText(message);
    }


}
