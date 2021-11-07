package com.example.myapplication.Boundary;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class PharmacistViewUpdatedToYesPage extends AppCompatActivity {

    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_view_updated_to_yes_page);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            button9 = (Button) findViewById(R.id.button9);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        button9.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == button9) {
                PharmacistMainPage();
            }
        }
    };

    public void PharmacistMainPage() {
        Intent intent = new Intent(PharmacistViewUpdatedToYesPage.this, PharmacistMainPage.class);
        startActivity(intent);
    }
}