package com.example.cappo;

import com.example.cappo.SurfaceViewExample.OurView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {

	int x, y, height, width, xSpeed, ySpeed, currentFrame = 0, direction = 3, speed;
	Bitmap b;
	OurView ov;
	
	public Sprite(OurView ourView, Bitmap blob) {
		// TODO Auto-generated constructor stub
		b = blob;
		ov = ourView;
		// divide by 4 because 4 columns 4 rows
		height = b.getHeight()/4;
		width = b.getWidth()/4;
		x = y = 0;
		speed = 10;
		xSpeed = speed;
		ySpeed = 0;
	}
	
	private void update() {
		// TODO Auto-generated method stub
		
		//0 = up
		//1 = down
		//2 = left
		//3 = right
		if(x > ov.getWidth() - width - xSpeed){
			//going down
			xSpeed = 0;
			ySpeed = speed;
			direction = 1;
		}
		if(y > ov.getHeight() - height - ySpeed){
			//going left
			xSpeed = -speed;
			ySpeed = 0;
			direction = 2;
		}
		if(x + xSpeed < 0){
			//going up
			x = 0;
			xSpeed = 0;
			ySpeed = -speed;
			direction = 0;
		}
		if(y + ySpeed < 0){
			//going right
			y = 0;
			xSpeed = speed;
			ySpeed = 0;
			direction = 3;
		}
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentFrame = ++currentFrame % 4;
		x += xSpeed;
		y += ySpeed;
	}
	
	public void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		update();
		int srcX = currentFrame*width;
		int srcY = direction*height;
		Rect src = new Rect(srcX, srcY, srcX+width, srcY+height);
		Rect dst = new Rect(x, y, x+width, y+height);
		canvas.drawBitmap(b, src, dst, null);
	}
}
