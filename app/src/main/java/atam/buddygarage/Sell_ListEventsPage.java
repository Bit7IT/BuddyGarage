package atam.buddygarage;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sell_ListEventsPage extends Activity {

    private ListView lv;
    private ArrayList<String> strArr;
    private ArrayAdapter<String> adapter;

    private void onClockListenListView(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView)view).getText().toString();
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Sell_ListEventsPage.this, Sell_EventInfoPage.class); // go to the User Sign up Screen
                startActivity(intent);
            }
        });
    } // Action when click on event


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell__list_events_page);
        lv = (ListView) findViewById(R.id.ListView_events);

        strArr = new ArrayList <String>(); // the ArrayList of String containing events to be displayed

        /**
         * Items to add in Listview Below:
         */
        strArr.add("1092 Sherwood Blvd. NW."); // hard code address for testing
        for (int i =0; i<20;i++){// hard code address for testing
            strArr.add("Events at address "+i); // hard code address for testing
        }// hard code address for testing

        /**
         *
         */

        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, strArr); //adding array to adapter
        lv.setAdapter(adapter);
        onClockListenListView();
    }// Sell_ListEventsPage main



}
