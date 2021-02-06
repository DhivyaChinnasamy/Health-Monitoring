package com.prop.healthmonitoring;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MonitorActivity extends Activity {
	/** Called when the activity is first created. */
	Connection conn;
	String r1, r2, r3, r4, a1, a2, a3, a4;
	// EditText edt1;
	Button b1;

	Vibrator mVibrator;

	int dot = 200; // Length of a Morse Code "dot" in milliseconds

	int dash = 500; // Length of a Morse Code "dash" in milliseconds

	int short_gap = 200; // Length of Gap Between dots/dashes

	int medium_gap = 500; // Length of Gap Between Letters

	int long_gap = 1000; // Length of Gap Between Words

	long[] pattern = { 0, // Start immediately

			dot, short_gap, dot, short_gap, dot, // s

			medium_gap, dash, short_gap, dash, short_gap, dash, // o

			medium_gap, dot, short_gap, dot, short_gap, dot, // s

			long_gap };
	String result = "2";

	// String regno;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.monitorpage);

		mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		// contextInitialized();

		String serverURL = "https://api.thingspeak.com/channels/423763/fields/1/last?key=J08RB6BQMXFZJ7C1";
		String serverURL1 = "https://api.thingspeak.com/channels/423763/fields/2/last?key=J08RB6BQMXFZJ7C1";
		
		new LongOperation().execute(serverURL, serverURL1);
		// contextInitialized();
		Thread t = new Thread() {
			public void run() {
				try {
					synchronized (this) {
						wait(20000);
						//Intent intent = new Intent(Gas_Detection.this,
						//		Success.class);
						//startActivity(intent);

					}

					/*
					 * if (r1.equals(result)) { Intent intent = new
					 * Intent(Gas_Detection.this, Sms.class);
					 * startActivity(intent); } else {
					 * 
					 * }
					 */

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();

	}

	private class LongOperation extends AsyncTask<String, Void, Void> {

		private final HttpClient Client = new DefaultHttpClient();
		private String Content;
		private String Content1,Content2,Content3,Content4;

		private String Error = null;
		private ProgressDialog Dialog = new ProgressDialog(MonitorActivity.this);
		TextView uiUpdate = (TextView) findViewById(R.id.output);

		TextView t1 = (TextView) findViewById(R.id.textView2);
		TextView t2 = (TextView) findViewById(R.id.TextView02_weight);
		
		protected void onPreExecute() {
			// NOTE: You can call UI Element here.

			// UI Element
			uiUpdate.setText("");
			Dialog.setMessage("Retrieving data..");
			Dialog.show();
		}

		// Call after onPreExecute method
		protected Void doInBackground(String... urls) {
			try {

				// Call long running operations here (perform background
				// computation)
				// NOTE: Don't call UI Element here.

				// Server url call by GET method
				HttpGet httpget = new HttpGet(urls[0]);
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
				Content = Client.execute(httpget, responseHandler);

				HttpGet httpget1 = new HttpGet(urls[1]);
				ResponseHandler<String> responseHandler1 = new BasicResponseHandler();
				Content1 = Client.execute(httpget1, responseHandler1);
				
				

			} catch (ClientProtocolException e) {
				Error = e.getMessage();
				cancel(true);
			} catch (IOException e) {
				Error = e.getMessage();
				cancel(true);
			}

			return null;
		}

		protected void onPostExecute(Void unused) {
			// NOTE: You can call UI Element here.

			// Close progress dialog
			Dialog.dismiss();

			t1.setText(" " + Content + "");
			t2.setText(" " + Content1 + "");
			
			/*
			 * t2.setText(" " + "30" + "      " + "33" + "     " + "0.2");
			 * 
			 * t3.setText(" " + "28" + "      " + "31" + "     " + "1.1");
			 * 
			 * t4.setText(" " + "31" + "      " + "34" + "     " + "0.5");
			 * 
			 * t5.setText(" " + "27" + "      " + "30" + "     " + "0.9");
			 */

			// int v1 = Integer.parseInt(Content);
			// int v2 = Integer.parseInt(Content1);

			// if (v1 > 34) {
			// mVibrator.vibrate(300);

			// }
			// if (v2 > 90) {
			// mVibrator.vibrate(300);

			// }

			if (Error != null) {

				uiUpdate.setText("Output : " + Error);

			} else {

				//uiUpdate.setText(Content);
				//r1 = t1.getText().toString();
				//r2 = t2.getText().toString();

			}
		}

	}

}