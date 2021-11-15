package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.myapplication.Boundary.R;
import com.example.myapplication.Entity.PatientD;

import java.util.ArrayList;

public class PharmacistViewCurrentPrescriptionStatus extends AppCompatActivity {

    Button backtohome;
    TableLayout viewPrescriptionStatus;
    TableRow newTR, test;
    TextView getMedicineName, getQty, getDate, getStatus; //Medicine Name, Qty, Status (column names)

    public void tableCreate(String medicineName, int qty, String date, String status){
        newTR = new TableRow(PharmacistViewCurrentPrescriptionStatus.this);
        getMedicineName = new TextView(PharmacistViewCurrentPrescriptionStatus.this);
        getDate = new TextView(PharmacistViewCurrentPrescriptionStatus.this);
        getQty = new TextView(PharmacistViewCurrentPrescriptionStatus.this);
        getStatus = new TextView(PharmacistViewCurrentPrescriptionStatus.this);

//        newTR.setLayoutParams(new TableLayout.LayoutParams(
////                TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT));

        //newTR.setLayoutParams(test.getLayoutParams());
        TableRow.LayoutParams rowSpanLayout = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams rowSpanLayout2 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        getMedicineName.setText(medicineName);
        getQty.setText(String.valueOf(qty));
        getDate.setText(date);
        getStatus.setText(status);

        getMedicineName.setGravity(Gravity.CENTER);
        getQty.setGravity(Gravity.CENTER);
        getDate.setGravity(Gravity.CENTER);
        getStatus.setGravity(Gravity.CENTER);

        rowSpanLayout.span = 4;
        rowSpanLayout2.span = 1;

        newTR.addView(getMedicineName, rowSpanLayout);
        newTR.addView(getQty, rowSpanLayout2);
        newTR.addView(getDate, rowSpanLayout2);
        newTR.addView(getStatus, rowSpanLayout2);

        newTR.setPadding(0,0,0,10);
        viewPrescriptionStatus.addView(newTR);
        System.out.println(medicineName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_view_current_prescription_status);

        ArrayList<PatientD> p_list = new ArrayList<PatientD>();
        p_list = (ArrayList<PatientD>)getIntent().getSerializableExtra("p_list");

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();

        System.out.println(p_list.size());
        //Create text view inside table row
        for(int i = 0; i < p_list.size(); i++){
            tableCreate(p_list.get(i).getMedicineName(), p_list.get(i).getQty(), p_list.get(i).getDate(), p_list.get(i).getStatus());
        }
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            backtohome = (Button) findViewById(R.id.backtohome);
            test = (TableRow)findViewById(R.id.tableRow_title);
            viewPrescriptionStatus = (TableLayout)findViewById(R.id.tableLayout1);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        backtohome.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == backtohome)
                goHome();
        }
    };

    public void goHome() {
        Intent intent = new Intent(PharmacistViewCurrentPrescriptionStatus.this, PharmacistMainPage.class);
        startActivity(intent);
    }

}