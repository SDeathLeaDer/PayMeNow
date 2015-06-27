package com.aqpup.paymenow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import model.Person;

/**
 * Created by wilder on 26/06/15.
 */
public class LoanAdapter extends ArrayAdapter<Person> {

    private ArrayList<Person> listPerson;

    public LoanAdapter(Context context, ArrayList<Person> listPerson){

        super(context, 0, listPerson);

        this.listPerson = listPerson;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;

        Person person = listPerson.get(position);

        if(view == null){
          //  Toast.makeText(getContext(), "View null", Toast.LENGTH_SHORT).show();
            view = LayoutInflater.from(getContext()).inflate(R.layout.row_loan, parent, false);
        }

        TextView tvName = (TextView)view.findViewById(R.id.tvRowName);
        TextView tvAmount = (TextView)view.findViewById(R.id.tvRowAmount);
        TextView tvDate = (TextView)view.findViewById(R.id.tvRowDateLoan);
        ImageButton ibDeleteLoan = (ImageButton) view.findViewById(R.id.ibDeleteLoan);

        tvName.setText(person.getName());
        tvAmount.setText(person.getAmount()+"");
        tvDate.setText(person.getDate()+"");

        ibDeleteLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPerson.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
