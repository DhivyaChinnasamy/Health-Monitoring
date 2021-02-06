package com.example.healthmonitoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewDataActivity extends MainActivity {

	EditText edtName, edtMobileNo, edtEmail, edtusername,	edtPassword, edtprof,edtdegree,edtaddr;
Button btnSubmit,btnSubmit1;
Connection conn;

private String s1, s2, s3, s4,s5, s6,s7,addr, empid,diabetes,hyp,asthma,heart;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view);
		
		
		edtMobileNo = (EditText) findViewById(R.id.registermobileno);
		
		
	
		btnSubmit = (Button) findViewById(R.id.register_btn_reg);
		btnSubmit.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				
				empid = edtMobileNo.getText().toString();
				
				
				//ssc = edtssc.getText().toString();
				//hsc = edthsc.getText().toString();
				try {
					if(verify())
					{
						new QuerySQL().execute();
						
				

					}
					
		
					} catch (Exception e) {
		        Log.e("ERRO",e.getMessage());
				}

				
			}
		});
		
		btnSubmit1 = (Button) findViewById(R.id.register_btn_cancel);
		btnSubmit1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(i);
				
				
			}
		});

	}
	
	public boolean verify()
	{
//		EditText name, userName, password, cpassword, email, phoneNumber;
		Boolean ret=true;
		
		
		if(edtMobileNo.getText().toString().length()<1){edtMobileNo.setError("Field Required");ret=false;}
		
		
		
		return ret;
	}
	
	
	public class QuerySQL extends AsyncTask<String, Void, Boolean> {

		ProgressDialog pDialog ;
		Exception error;
		ResultSet rs;
	    @Override
	    protected void onPreExecute() {
	        super.onPreExecute();
	        
	        pDialog = new ProgressDialog(ViewDataActivity.this);
	        pDialog.setTitle("View Data");
	        pDialog.setMessage("Getting health info...");
	        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	        pDialog.setIndeterminate(false);
	        pDialog.setCancelable(false);
	        pDialog.show();
	    }

	    @Override
	    protected Boolean doInBackground(String... args) {
	    	
	    	
	    	
	    	
			try {
				
				
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/ZnrtgOH0r0","ZnrtgOH0r0","7vAeXso3N7");		
				} catch (SQLException se) {
				Log.e("ERRO1",se.getMessage());
			} catch (ClassNotFoundException e) {
				Log.e("ERRO2",e.getMessage());
			} catch (Exception e) {
			    Log.e("ERRO3",e.getMessage());
			}
			

			try {
				
				String query = "select * from iotdata where empid='"+empid+"'"; 
                Statement st = conn.createStatement();
                rs = st.executeQuery(query);

                while (rs.next()) {
                    
                    s1 = rs.getString(1);
                    s2 = rs.getString(2);
					
					s3 = rs.getString(3);
                    s4 = rs.getString(4);
					
					s5 = rs.getString(5);
                    s6 = rs.getString(6);
					 s7 = rs.getString(7);
					 
					  int bloodsugar = Integer.parseInt(s4);
					  String bloodsugarreport = "";
					  if(bloodsugar<=140)
					  {
					  	bloodsugarreport="Normal";
					  }
					  else if(bloodsugar>140 && bloodsugar<=199)
					  {
					  	bloodsugarreport="Diabetes";
					  }
					  else if(bloodsugar>199)
					  {
					  	bloodsugarreport="Pre-diabetes";
					  }
					  diabetes=bloodsugarreport;
					  int oxygen = Integer.parseInt(s6);
					  String oxygenreport="";
					  if(oxygen>=96 && oxygen<=98)
					  {
					    oxygenreport="Abnormal";
					  }
					  else
					  {
					  	oxygenreport="Normal";
					  }
					 hyp=oxygenreport;
					 int bp = Integer.parseInt(s2);
					 
					 int respiration = Integer.parseInt(s3);
					 String asthmareport="";
					 if(oxygen>=92 && oxygen<=95 && bp>=100 && bp<=125 && respiration>=20 && respiration<=30)
					  {
					  asthmareport="Abnormal";
					  }
					 else
					 {
					 asthmareport="Normal";
					 }
					 asthma=asthmareport;
					 String heartreport="";
					 if(bp>=140)
					 {
					 	heartreport="Abnormal";
					 }
					  else
					 {
					 heartreport="Normal";
					 }
				heart=heartreport;

			}
				return true;
				// Toast.makeText(getBaseContext(),
				// "Successfully Inserted.", Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				error = e;
				return false;
//				Toast.makeText(getBaseContext(),"Successfully Registered...", Toast.LENGTH_LONG).show();
			}


	    }

	    @SuppressLint("NewApi")
		@Override
	    protected void onPostExecute(Boolean result1) {
	    	pDialog.dismiss ( ) ;
	    	if(result1)
	    	{
                
	    		//Toast.makeText(getBaseContext(),"Successfully added your credentials." ,Toast.LENGTH_LONG).show();
					
//					System.out.println("ELSE(JSON) LOOP EXE");
					try {// try3 open
						
						Intent i = new Intent(getApplicationContext(),
								HealthViewActivity.class);
						
						i.putExtra("s1", s1);
						i.putExtra("s2", s2);
						i.putExtra("s3", s3);
						i.putExtra("s4", s4);
						i.putExtra("s5", s5);
						i.putExtra("s6", s6);
						i.putExtra("s7", s7);
						i.putExtra("empid", empid);
						i.putExtra("diabetes", diabetes);
						i.putExtra("hyp", hyp);
						i.putExtra("asthma", asthma);
						i.putExtra("heart", heart);
						startActivity(i);		
						
					} catch (Exception e1) {
						Toast.makeText(getBaseContext(), e1.toString(),
								Toast.LENGTH_LONG).show();

					}					
				
            
	    	}else
	    	{
	    		if(error!=null)
	    		{
	    			Toast.makeText(getApplicationContext(),error.toString() ,Toast.LENGTH_LONG).show();
	    			Log.d("Error not null...", error.toString());
	    		}
	    		else
	    		{
	    			Toast.makeText(getBaseContext(),"Not crreated your credentials!!!" ,Toast.LENGTH_LONG).show();
	    		}
	    	}
	    	super.onPostExecute(result1);
	    }
	}


}
