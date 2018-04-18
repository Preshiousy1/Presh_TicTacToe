package com.example.android.presh_tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private Spinner spinner1, spinner2;
    public static String Spinner1ItemSelected;
    public static String Spinner2ItemSelected;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }
    public void welcome_page(View view) {
        Intent intent = new Intent(this, WelcomePage.class);
        startActivity(intent);
    }
    // add items into spinner dynamically
    /*public void addItemsOnSpinner2() {

        spinner2 = findViewById(R.id.chooseBoardSizeSpinner);
        List<String> list = new ArrayList<String>();
        list.add("3");
        list.add("4");
        list.add("5");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }
*/
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = findViewById(R.id.choosePlayersSpinner);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 =  findViewById(R.id.choosePlayersSpinner);
        spinner2 =  findViewById(R.id.chooseBoardSizeSpinner);
        btnSubmit =  findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(SettingsActivity.this,
                        "OnClickListener : " +
                                "\nPlayers : "+ String.valueOf(spinner1.getSelectedItem()) +
                                "\nBoard Size : "+ String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
                Spinner1ItemSelected = "" + String.valueOf(spinner1.getSelectedItem());
                Spinner2ItemSelected = "" + String.valueOf(spinner2.getSelectedItem());
                welcome_page2();
            }

        });
    }

    public void welcome_page2() {
        Intent intent = new Intent(this, WelcomePage.class);
        startActivity(intent);

    }
}
