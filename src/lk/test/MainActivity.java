package lk.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.lvp.ListViewPopulator;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button addButton = (Button) findViewById(R.id.btn_main_addNew);
		addButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				
				Intent openAddIntent = new Intent(getApplicationContext(), AddActivity.class);
				startActivity(openAddIntent);
				
			}
		});
		
		
		
		DBModule dbm = new DBModule();	//to get a helper
		
		ListView listView = (ListView) findViewById(R.id.listView_main_contacts);
		final ListViewPopulator populator = new ListViewPopulator(
				getApplicationContext(), 
				dbm.getHelper(getApplicationContext()),
				DBModule.TABLENAME);
		
		populator.setListView(listView);
		populator.setMapping(R.id.textView_entry_name, "name");
		populator.setMapping(R.id.textView_entry_phone, "number");
		populator.setListViewEntryLayoutID(R.layout.contact_entry);
		//populator.populate("name=?", new String[]{"a"});
		populator.populate();
		
		final EditText search = (EditText) findViewById(R.id.input_main_search);
		search.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable e) {
				if(e.toString().compareTo("") != 0) { 
					populator.populate("name LIKE '%"+ e.toString() +"%'", null);
				} else {
					populator.populate();
				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	

}
