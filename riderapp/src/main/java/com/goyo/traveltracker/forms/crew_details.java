package com.goyo.traveltracker.forms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.goyo.traveltracker.gloabls.Global;
import com.goyo.traveltracker.R;
import com.goyo.traveltracker.model.model_crewdata;

public class crew_details extends AppCompatActivity {

    /*Variables*/
    TextView txtName,txtShortAddr,txtFullAddr, txtContNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_details);

        initAllControls();
        getBundle();
    }

    /*fill all controls*/
    private void initAllControls(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtName = (TextView)findViewById(R.id.txtName);
        txtShortAddr = (TextView)findViewById(R.id.txtName);
        txtFullAddr = (TextView)findViewById(R.id.txtName);
        txtContNo = (TextView)findViewById(R.id.txtName);
    }

    private void getBundle(){
        model_crewdata data = Global.crewDetails;
        //Toast.makeText(this,data.stdnm ,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
