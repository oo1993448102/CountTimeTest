package com.example.counttimetest;

import java.util.Timer;
import java.util.TimerTask;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private EditText inputTime;
	private Button get , start , end ;
	private TextView showTime;
	private int i = 0;
	 private Timer timer = null;
	 private TimerTask task;
	 
	
	
			

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}
	
	private void initView(){
		inputTime = (EditText) findViewById(R.id.input_time);
		showTime = (TextView) findViewById(R.id.show_time);
		get = (Button) findViewById(R.id.get_time);
		start = (Button) findViewById(R.id.start);
		end = (Button) findViewById(R.id.end);
		get.setOnClickListener(this);
		start.setOnClickListener(this);
		end.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.get_time :
			showTime.setText(inputTime.getText().toString());
			i = Integer.parseInt(inputTime.getText().toString());
			break;
		case R.id.start :
			startTimer();
			break;
		case R.id.end :
			stopTimer();
			break;
			
			
		}
		
	}
	private Handler handler = new Handler(){
		 public void handleMessage(Message msg) {
			 
			
				 showTime.setText(msg.arg1 + "");
				 startTimer();
				
			 
			 
			 
		 }
	 };
	 
	public void startTimer(){
		timer = new Timer();
		task =  new TimerTask() {
			
			@Override
			public void run() {
				if(i>0){
					i -- ;}
				Message message = new Message();
				
				message.arg1 = i;
				handler.sendMessage(message);
				
				
				
				
				
				
			}
		};
		timer.schedule(task, 1000);
		
		
	}
	
	public void stopTimer(){
		timer.cancel();
		
	}

	
}
