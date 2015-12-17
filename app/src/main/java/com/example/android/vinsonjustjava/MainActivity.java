package com.example.android.vinsonjustjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        if (quantity == 100) {
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("MainActivity", "Name: " + name);

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        CheckBox caramelCheckBox = (CheckBox) findViewById(R.id.caramel_checkbox);
        boolean hasCaramel = caramelCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate, hasCaramel);
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate, hasCaramel);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate, boolean addCaramel) {
        int basePrice = quantity * 5;

        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        if (addChocolate) {
            basePrice = basePrice + 1;
        }

        if (addCaramel) {
            basePrice = basePrice + 1;
        }

        return quantity * basePrice;
    }


    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate, boolean addCaramel) {
        String priceMessage = "@string/name: " + name;
        priceMessage += priceMessage + "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += priceMessage + "\nAdd chocolate? " + addChocolate;
        priceMessage += priceMessage + "\nAdd caramel? " + addCaramel;
        priceMessage += priceMessage + "\nQuantity: " + quantity;
        priceMessage += priceMessage + "\nTotal: $" + price;
        priceMessage += priceMessage + "\nThank you " + name + "!";
        return priceMessage;
    }


    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
}


