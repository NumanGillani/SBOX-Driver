package numan.superboxdriver.VisitsReport;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import numan.superboxdriver.DetailInfo;
import numan.superboxdriver.R;

public class CustomerRecord extends AppCompatActivity {

    public List<CustomerRowItem> rowItems;
    public ListView transList;
    public List<String> vehicles;
    public List<String> services;
    public List<String> charges;
    public List<String> count;
    public List<String> createdOn;
    public List<String> mobileNumber;



    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_record);
        try {
            transList = (ListView) findViewById(R.id.transList);
            rowItems = new ArrayList<CustomerRowItem>();

            vehicles = new ArrayList<String>();
            services = new ArrayList<String>();
            charges = new ArrayList<String>();
            count = new ArrayList<String>();
            createdOn = new ArrayList<String>();
            mobileNumber = new ArrayList<String>();

            vehicles.add("Ahmed");
            vehicles.add("Numan");
            vehicles.add("Ali");
            vehicles.add("Syed");
            vehicles.add("Zayed");

            services.add("Body Wash");
            services.add("Full Wash");
            services.add("Inside Cleaning");
            services.add("Oil Change");
            services.add("Body Wash");

            charges.add("40 AED");
            charges.add("90 AED");
            charges.add("70 AED");
            charges.add("140 AED");
            charges.add("50 AED");

            count.add("1");
            count.add("3");
            count.add("1");
            count.add("2");
            count.add("1");

            createdOn.add("09:33 AM");
            createdOn.add("10:45 AM");
            createdOn.add("11:56 AM");
            createdOn.add("02:09 PM");
            createdOn.add("05:21 PM");

            mobileNumber.add("052 7054445");
            mobileNumber.add("050 5573607");
            mobileNumber.add("056 7358964");
            mobileNumber.add("050 5573607");
            mobileNumber.add("052 7054445");
            searchTrans();

            transList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    startActivity(new Intent(CustomerRecord.this, DetailInfo.class));
                }
            });
        } catch(Exception ex)
        {
            Log.e("Customer Exception" , ex + "");
        }

    }

    public void searchTrans() {
        CustomerRowItem item;
        for(int i=0;i<5;i++)
        {
            item = new CustomerRowItem(services.get(i), vehicles.get(i), count.get(i) , charges.get(i) , createdOn.get(i) , mobileNumber.get(i));
            rowItems.add(item);
        }
        CustomerAdapter adapter = new CustomerAdapter(this, rowItems);
        transList.setAdapter(adapter);
    }

}