package com.example.cappo;

import android.app.Activity;
import android.os.Bundle;

public class Tutorial4 extends Activity{

	DrawingTheBall v;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		v = new DrawingTheBall(this);
		setContentView(v);
	}
	
}
