package com.example.cappo;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Select extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		//MediaPlayers
		final MediaPlayer buttonSound = MediaPlayer.create(Select.this, R.raw.endrock);
		
		//buttons
		Button tutorial1 = (Button) findViewById(R.id.tutorial1);
		Button tutorial2 = (Button) findViewById(R.id.tutorial2);
		Button tutorial3 = (Button) findViewById(R.id.tutorial3);
		Button tutorial4 = (Button) findViewById(R.id.tutorial4);
		Button surfaceView = (Button) findViewById(R.id.surfaceView);
		Button tutorial6 = (Button) findViewById(R.id.tutorial6);
		
		tutorial1.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.cappo.TUTORIAL1"));
				buttonSound.start();
			}
		});
		
		tutorial2.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.cappo.TUTORIAL2"));
				buttonSound.start();
			}
		});
		
		tutorial3.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.cappo.TUTORIAL3"));
				buttonSound.start();
			}
		});
		
		tutorial4.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.cappo.TUTORIAL4"));
				buttonSound.start();
			}
		});
		
		surfaceView.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.cappo.SURFACEVIEWEXAMPLE"));
				buttonSound.start();
			}
		});
		
		tutorial6.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.cappo.TUTORIAL6"));
				buttonSound.start();
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		MenuInflater awesome = getMenuInflater();
		awesome.inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.menuSweet:
			startActivity(new Intent("com.example.cappo.SWEET"));
			return true;
		case R.id.menuToast:
			//set up later
			Toast andEggs = Toast.makeText(Select.this, "This is a toast", Toast.LENGTH_LONG);
			andEggs.show();
			return true;
		}
		
		return false;
	}
}
