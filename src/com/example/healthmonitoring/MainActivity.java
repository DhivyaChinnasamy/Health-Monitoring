package com.example.healthmonitoring;

import java.sql.Connection;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	Connection conn;
	EditText username,password,hostIP;
	Button signin,signup;
	String user,pass,user1,pass1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.monitorpage);
		signin=(Button)findViewById(R.id.databtn);
		signup=(Button)findViewById(R.id.viewbtn);

	signin.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			startActivity(new Intent(MainActivity.this,EnterDataActivity.class));		
			
		}
		
	});
	
	signup.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			startActivity(new Intent(MainActivity.this,ViewDataActivity.class));		
			
		}
		
	});
	}

}
