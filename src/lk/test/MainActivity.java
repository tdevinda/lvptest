package lk.test;

import com.lvp.ListViewPopulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

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
		
		ListView listView = (ListView) findViewById(R.id.listView_main_contacts);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	

}
