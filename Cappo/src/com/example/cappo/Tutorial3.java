package com.example.cappo;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Tutorial3 extends Activity implements OnClickListener{

	ImageView display;
	int toPhone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.wallpaper);
		
		toPhone = R.drawable.back_battlefield;
		
		display = (ImageView) findViewById(R.id.IVdisplay);
		ImageView image1 = (ImageView) findViewById(R.id.IVbattlefield);
		ImageView image2 = (ImageView) findViewById(R.id.IVblack);
		ImageView image3 = (ImageView) findViewById(R.id.IVblue);
		ImageView image4 = (ImageView) findViewById(R.id.IVcity);
		ImageView image5 = (ImageView) findViewById(R.id.IVmountain);
		ImageView image6 = (ImageView) findViewById(R.id.IVwalle);
		Button setWall = (Button) findViewById(R.id.SetWallpaper);
		
		image1.setOnClickListener(this);
		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		image5.setOnClickListener(this);
		image6.setOnClickListener(this);
		setWall.setOnClickListener(this);
	}
	
	public void onClick(View v){
		Toast WallChanged = Toast.makeText(Tutorial3.this, "Wallpaper has been changed!", Toast.LENGTH_LONG);
		
		switch(v.getId()){
		case R.id.IVbattlefield:
			display.setImageResource(R.drawable.back_battlefield);
			toPhone = R.drawable.back_battlefield;
			break;
		case R.id.IVblack:
			display.setImageResource(R.drawable.back_black);
			toPhone = R.drawable.back_black;
			break;
		case R.id.IVblue:
			display.setImageResource(R.drawable.back_blue);
			toPhone = R.drawable.back_blue;
			break;
		case R.id.IVcity:
			display.setImageResource(R.drawable.back_city);
			toPhone = R.drawable.back_city;
			break;
		case R.id.IVmountain:
			display.setImageResource(R.drawable.back_mountain);
			toPhone = R.drawable.back_mountain;
			break;
		case R.id.IVwalle:
			display.setImageResource(R.drawable.back_walle);
			toPhone = R.drawable.back_walle;
			break;
		case R.id.SetWallpaper:
			InputStream newStream = getResources().openRawResource(toPhone);
			Bitmap newWall = BitmapFactory.decodeStream(newStream);
			try{
				getApplicationContext().setWallpaper(newWall);
				WallChanged.show();
			} catch(IOException e){
				e.printStackTrace();
			}
			break;
		}
	}
}
