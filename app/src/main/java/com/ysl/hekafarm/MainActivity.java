package com.ysl.hekafarm;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		handler.sendEmptyMessageDelayed(3,1500);
	}

	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			getHome();
			super.handleMessage(msg);
		}
	};

	private void getHome(){
		Intent intent = new Intent(MainActivity.this,BaseActivity.class);
		startActivity(intent);
		finish();
	}
}
