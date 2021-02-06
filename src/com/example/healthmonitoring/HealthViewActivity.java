package com.example.healthmonitoring;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class HealthViewActivity extends Activity {

	String recvname="",recvname1="",recvname2="";
	String mobile="";
String sendername="";
	Connection conn;
	EditText edmessage;
	String complaint,area,landmark,description,date1,status,diet1,diet2,diag,dept;
	Button sendmsg;
	ImageButton template;
	TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,username,facility;
	Button b1,b2,b3;
	HashMap<String,String> usersList1 = null;
	ArrayList<HashMap<String,String>> usersList2 = new ArrayList<HashMap<String,String>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.healthlistreport);
		
		
		SharedPreferences preferences1=getSharedPreferences("username", Context.MODE_PRIVATE);
		username=preferences1.getString("username",null);


		
		Intent intent=getIntent();
		
		String empid=intent.getStringExtra("empid");
		
		s1=intent.getStringExtra("s1");
		
		s2=intent.getStringExtra("s2");
		
		s3=intent.getStringExtra("s3");

		s4=intent.getStringExtra("s4");

		s5=intent.getStringExtra("s5");

		s6=intent.getStringExtra("s6");

		s7=intent.getStringExtra("s7");
		
		String diabetes=intent.getStringExtra("diabetes");
		
		String hyp=intent.getStringExtra("hyp");
		
		String asthma=intent.getStringExtra("asthma");
		
		String heart=intent.getStringExtra("heart");
		
		
		t1 = (TextView) findViewById(R.id.textView_empid);
		t1.setText(empid);
		
		t2 = (TextView) findViewById(R.id.textView_temp);
		t2.setText(s1);
		
		t3 = (TextView) findViewById(R.id.textView_bp);
		t3.setText(s2);

		t4 = (TextView) findViewById(R.id.textView_res);
		t4.setText(s3);

		t5 = (TextView) findViewById(R.id.textView_glucose);
		t5.setText(s4);

		t6 = (TextView) findViewById(R.id.textView_heartrate);
		t6.setText(s5);
		
		t7 = (TextView) findViewById(R.id.textView_oxygen);
		t7.setText(s6);
		
		t8 = (TextView) findViewById(R.id.textView_cardiogram);
		t8.setText(s7);
		
		t9 = (TextView) findViewById(R.id.textView_diabetes);
		t9.setText(diabetes);

		t10 = (TextView) findViewById(R.id.textView_hyp);
		t10.setText(hyp);
		
		t11 = (TextView) findViewById(R.id.textView_asthma);
		t11.setText(asthma);
		
		t12 = (TextView) findViewById(R.id.textView_heartdisease);
		t12.setText(heart);

	
		b3 = (Button)findViewById(R.id.backbtn1);
		b3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				try {

					//String solved = "solved";
					//new StatusUpdate().execute(solved);
					startActivity(new Intent(HealthViewActivity.this,ViewDataActivity.class));

				}
				catch(Exception e){
					//	Toast.makeText(applicationContext.getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
				}
			}
		});


	}

	
	
}
