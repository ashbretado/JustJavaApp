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
import android.widget.Toast;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD

    int quantity = 0;
=======
    int quantity = 1;
>>>>>>> fa850f09802926d316f874e5b3b3c530af911157

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

<<<<<<< HEAD
    public void increment(View view) {
        if (quantity == 100) {
=======
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText getName = (EditText)findViewById(R.id.name_field);
        String nameValue = getName.getText().toString();
        EditText getCard = (EditText)findViewById(R.id.creditcard_field);
        String cardValue = getCard.getText().toString();
        EditText getExpiration = (EditText)findViewById(R.id.expiration_field);
        String expirationValue = getExpiration.getText().toString();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        CheckBox caramelCheckBox = (CheckBox) findViewById(R.id.caramel_checkbox);
        boolean hasCaramel = caramelCheckBox.isChecked();
        CheckBox marshmallowCheckBox = (CheckBox) findViewById(R.id.marshmallow_checkbox);
        boolean hasMarshmallow = marshmallowCheckBox.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate, hasCaramel, hasMarshmallow);
        String priceMessage = createOrderSummary(nameValue, price, hasWhippedCream,
                hasChocolate, hasCaramel, hasMarshmallow, cardValue, expirationValue);
        //Used displayMessage(priceMessage) before we switched to the email intent
        /*displayMessage(priceMessage);*/
        // Use an intent to launch an email app.
        // Send the order summary in the email body.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for " + nameValue);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /**
     * Calculates the price of the order based on the quantity & pricePerCup.
     *
     * @return the price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate, boolean addCaramel, boolean addMarshmallow) {
        int basePrice = 5;
        if (addWhippedCream){
            basePrice = basePrice + 1;
        }
        if (addChocolate){
            basePrice = basePrice + 2;
        }
        if (addCaramel){
            basePrice = basePrice + 1;
        }
        if (addMarshmallow){
            basePrice = basePrice + 1;
        }
        return quantity * basePrice;
    }
    /**
     * Create summary of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants whipped cream topping
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(String userName, int price, boolean addWhippedCream,
                                      boolean addChocolate, boolean addCaramel,
                                      boolean addMarshmallow, String cardNumber, String expiration){
        String priceMessage = "Customer: " + userName;
        priceMessage = priceMessage + "\n_________________________";
        priceMessage = priceMessage + "\n\nAdd Whipped Cream? " + addWhippedCream;
        priceMessage = priceMessage + "\nAdd Chocolate? " + addChocolate;
        priceMessage = priceMessage + "\nAdd Caramel? " + addCaramel;
        priceMessage = priceMessage + "\nAdd Marshmallow? " + addMarshmallow;
        priceMessage = priceMessage + "\n_________________________";
        priceMessage = priceMessage + "\nNumber of coffees: " + quantity;
        priceMessage = priceMessage + "\nTotal: $" + price;
        priceMessage = priceMessage + "\n\nCredit Card: " + cardNumber;
        priceMessage = priceMessage + "\nExp. Date: " + expiration;
        return priceMessage;
    }
    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if (quantity == 15) {
            // Show an error message as a toast
            //R.string.max - is a reference to @string/max for localization
            Toast.makeText(this, getResources().getString(R.string.max), Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
>>>>>>> fa850f09802926d316f874e5b3b3c530af911157
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
<<<<<<< HEAD
        if (quantity == 0) {
=======
        if (quantity == 1) {
            // Show an error message as a toast
            //R.string.min - is a reference to @string/min for localization
            Toast.makeText(this, getResources().getString(R.string.min), Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
>>>>>>> fa850f09802926d316f874e5b3b3c530af911157
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

<<<<<<< HEAD

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
=======
    /**
     * This method displays the given text on the screen.
     * Replaced by the email intent.
     */
    /*
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
>>>>>>> fa850f09802926d316f874e5b3b3c530af911157
    }
    */
}
