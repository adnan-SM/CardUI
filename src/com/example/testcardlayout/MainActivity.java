package com.example.testcardlayout;

import java.util.ArrayList;
import java.util.List;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	private List<RowItem> rowItems;

    private static Integer[] images = {
            R.drawable.red,
            R.drawable.red,
            R.drawable.red,
            R.drawable.red,
            R.drawable.red,
            R.drawable.red,
            R.drawable.red,            
            R.drawable.red
    };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Intialize and set the Action Bar to Holo Blue
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33b5e5" )));
		
		ListView lv = (ListView) findViewById(R.id.myList);
		 rowItems = new ArrayList<RowItem>();
		 
	        String[] titles = {"Movie1","Movie2","Movie3","Movie4","Movie5","Movie6","Movie7","Movie8"};
	        String[] descriptions = {"First Movie","Second movie","Third Movie","Fourth Movie","Fifth Movie",
	        		"Sixth Movie","Seventh Movie","Eighth Movie"};
	        //Populate the List
	        for (int i = 0; i < titles.length; i++) {
	            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
	            rowItems.add(item);
	        }

	        // Set the adapter on the ListView
	        LazyAdapter adapter = new LazyAdapter(getApplicationContext(), R.layout.list_row, rowItems);
	        lv.setAdapter(adapter);
	}

}
