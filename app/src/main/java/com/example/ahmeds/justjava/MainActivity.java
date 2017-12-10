package com.example.ahmeds.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        String name = setName();
        boolean hasWippedCream = checkWhippedCream();
        boolean hasChocolate = checkChocolate();
        int price = calculatePrice(hasChocolate,  hasWippedCream);
        String summary = createOrderSummary(price, hasWippedCream, hasChocolate,name);
        //displayMessage(summary);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void increment(View view){
         quantity += 1;
        display(quantity);
    }

    public void decrement(View view){
        quantity -= 1;
        if(quantity >= 0) {
            display(quantity);
        }else if(quantity < 0){
            quantity = 0;
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private String setName(){
        EditText editText = (EditText) findViewById(R.id.input_text);
        return editText.getText().toString();
    }

    private boolean checkWhippedCream(){
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox);
        return checkBox1.isChecked();
    }

    private boolean checkChocolate(){
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        return checkBox1.isChecked();
    }

    private int calculatePrice(boolean hasChocolate, boolean hasWippedCream) {

        int basePrice = 5;
        if(hasChocolate){
            basePrice += 2;
        }
        if(hasWippedCream)
            basePrice += 1;

        return quantity * basePrice;
    }

    private String createOrderSummary(int price, boolean checked, boolean hasChocolate, String name){
        String summary = "Name: " + name
                + "\nAdd whipped cream ? " + checked
                +"\nAdd Chocolate ? "+ hasChocolate
                + "\nQuantity:" + quantity
                + "\nTotal:" + price
                + "\nThank you!";
        return summary;
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }




}