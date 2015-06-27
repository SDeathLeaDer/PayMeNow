package com.aqpup.paymenow;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Person;


public class LoanActivity extends ActionBarActivity {

    private int numLoan = 10;
    private ArrayList<Person> listPerson;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_loan);

        ListView lvLoan = (ListView)findViewById(R.id.lvLoan);
        ImageButton ibAddLoan = (ImageButton)findViewById(R.id.ibAddLoan);


        listPerson = new ArrayList<Person>();
        loadData();

       final     LoanAdapter loanAdapter = new LoanAdapter(context, listPerson);
        lvLoan.setAdapter(loanAdapter);


        ibAddLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_add_loan);
                dialog.setTitle("Agregar Prestamo");

                final EditText etAmount = (EditText)dialog.findViewById(R.id.etAmount);
                final EditText etName = (EditText)dialog.findViewById(R.id.etName);
                final EditText etDate = (EditText)dialog.findViewById(R.id.etDate);


                Button bAddLoan = (Button)dialog.findViewById(R.id.bAddLoan);
                Button bClean = (Button)dialog.findViewById(R.id.bClean);

                bAddLoan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
                        Date convertedDate = new Date();
                        try {
                            convertedDate = dateFormat.parse(etDate.getText().toString());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        listPerson.add(new Person(etName.getText().toString(),
                                Double.valueOf(etAmount.getText().toString()),
                                convertedDate));

                        loanAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });

                bClean.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        etAmount.setText("");
                        etName.setText("");
                        etDate.setText("");

                    }
                });

                dialog.show();

            }
        });

    }

    public void loadData(){

        for (int i=0; i<numLoan; i++){
            listPerson.add(new Person("Raul", 100.00, new Date(2015,12,12)));
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
