package edu.fandm.enovak.tipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends AppCompatActivity {

    public final static double SALES_TAX_PA = 0.02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        if(savedInstanceState != null){
            String tmp = savedInstanceState.getString("bill_string");
            TextView tv = findViewById(R.id.result_tv);
            tv.setText(tmp);
        }
    }


    public void calculateTip15(View v){
        calculateTip(0.15);
    }

    public void calculateTip20(View v){
        calculateTip(0.20);
    }

    public void calculateTip(double tipPrecentage){

        EditText et = this.findViewById(R.id.tip__bill_et);
        try {
            double bill = Double.parseDouble(et.getText().toString());
            double billAfterTax = bill + (bill * SALES_TAX_PA);

            double newBill = billAfterTax + (billAfterTax * tipPrecentage);

            String amt = "$" + String.format("%.2f", newBill);
            TextView tv = this.findViewById(R.id.result_tv);
            tv.setText(amt);

        }catch(NumberFormatException e1){
            return;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle sis){
        super.onSaveInstanceState(sis);

        TextView tv = findViewById(R.id.result_tv);
        String s = tv.getText().toString();
        sis.putString("bill_string", s);
    }

}