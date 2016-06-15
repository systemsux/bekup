package id.ac.petra.softdev.bekupapp5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  int qty =0;
    private  int price =5;
    private TextView qtyText;
    private TextView qtyPrice;
    private Button btnTambahQty;
    private Button btnKurangiQty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qtyText = (TextView) findViewById(R.id.tv_Quantity);
        qtyPrice = (TextView) findViewById(R.id.tv_price);
        btnTambahQty = (Button) findViewById(R.id.btn_tambahQty);
//        btnTambahQty.setOnClickListener(this);
        btnKurangiQty = (Button) findViewById(R.id.btn_kurangiQty);
    }

    protected void submitOrder(View view) {
//        display(2);
//        displayPrice(2*5);
        int result = this.qty*this.price;
        this.qtyPrice.setText(NumberFormat.getCurrencyInstance().format(result));
    }

    protected void tambahQty(View view) {
        qty++;
        qtyText.setText(qty + "");
    }

    protected void kurangiQty(View view) {
        if(qty > 1) {
            qty--;
            qtyText.setText(String.valueOf(qty));
        }
    }

    protected void display(int number) {
        this.qtyText.setText("" + number);
    }

    protected void displayPrice(int number) {
        int result = this.qty*this.price;
        this.qtyPrice.setText(NumberFormat.getCurrencyInstance().format(result));
    }

    @Override
    public void onClick(View v) {
        if(v == btnTambahQty) {
            qty = Integer.parseInt(qtyText.getText().toString());

            int datat = qty + 1;
            qtyText.setText(datat);
        } else if(v == btnKurangiQty) {
            qty = Integer.parseInt(qtyText.getText().toString());

            int datat = qty -1;
            qtyText.setText(datat);
        }
    }
}
