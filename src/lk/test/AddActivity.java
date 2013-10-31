package lk.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		Button add = (Button) findViewById(R.id.btn_add_addNew);
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				DBModule dbm = new DBModule();
				EditText user = (EditText) findViewById(R.id.input_add_name);
				EditText number = (EditText) findViewById(R.id.input_add_number);
				
				dbm.addToDB(getApplicationContext(), user.getText().toString(), number.getText().toString());
				
				user.setText("");
				user.setText("");
				
				Intent goBackIntent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(goBackIntent);
			}
		});
		
	}
}
