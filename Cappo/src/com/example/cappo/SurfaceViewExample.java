package com.example.cappo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;

public class SurfaceViewExample extends Activity implements OnTouchListener{

	OurView v;
	Bitmap ball, blob;
	float x, y;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		super.onCreate(savedInstanceState);
		v = new OurView(this);
		v.setOnTouchListener(this);
		setContentView(v);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.blue_ball);
		blob = BitmapFactory.decodeResource(getResources(), R.drawable.spritesheet);
		x = y = 0;
	}

	@Override
	protected void onPause() {
		super.onPause();
		v.pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		v.resume();
	}

	public class OurView extends SurfaceView implements Runnable{
		
		Thread t = null;
		SurfaceHolder holder;
		boolean isItOK = false;
		Sprite sprite;

		public OurView(Context context) {
			super(context);
			holder = getHolder();
		}
		
		@SuppressLint("WrongCall")
		public void run(){
			sprite = new Sprite(OurView.this, blob);
			
			while(isItOK == true){
				//perform canvas drawing
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!holder.getSurface().isValid()) continue;
				//lock your room door, do your painting, then unlock to show everybody!
				Canvas c = holder.lockCanvas();
				//c.drawARGB(255, 150, 150, 10);
				//c.drawBitmap(ball, x - ball.getWidth()/2, y - ball.getHeight()/2, null);
				onDraw(c);
				holder.unlockCanvasAndPost(c);
			}
		}
		
		@SuppressLint("WrongCall")
		protected void onDraw(Canvas canvas){
			canvas.drawARGB(255, 150, 150, 10);
			canvas.drawBitmap(ball, x - ball.getWidth()/2, y - ball.getHeight()/2, null);
			sprite.onDraw(canvas);
		}
		
		public void pause(){
			isItOK = false;
			while(true){
				try{
					t.join();
				} catch(InterruptedException e){
					e.printStackTrace();
				}
				break;
			}
			t = null;
		}
		
		public void resume(){
			isItOK = true;
			t = new Thread(this);
			t.start();
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent me) {
		// TODO Auto-generated method stub		
		
		switch(me.getAction()){
		case MotionEvent.ACTION_DOWN:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_UP:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			x = me.getX();
			y = me.getY();
			break;
		}
		return true;
	}
}