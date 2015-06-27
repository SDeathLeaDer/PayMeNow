package com.aqpup.paymenow;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import model.Person;


public class DebtActivity extends ActionBarActivity {

    private int numLoan = 100;
    private ArrayList<Person> listPerson;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt);

        context = this;

        ListView lvDebt = (ListView)findViewById(R.id.lvDebt);
        listPerson = new ArrayList<Person>();
        loadData();

        DebtAdapter debtAdapter = new DebtAdapter(context, listPerson);
        lvDebt.setAdapter(debtAdapter);

    }


    public void loadData(){

        for (int i=0; i<numLoan; i++){
            if(i%2==0){
                listPerson.add(new Person("Lorenzo", 100.00, new Date(2015,12,12)));

            }else{
                listPerson.add(new Person("Maria", 130.00, new Date(2015,11,22)));
            }
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_debt, menu);
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
