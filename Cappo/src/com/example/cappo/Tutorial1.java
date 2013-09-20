package com.example.cappo;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Tutorial1 extends Activity implements OnCheckedChangeListener {

	TextView textOut;
	EditText textIn;
	RadioGroup gravity, style;
	Button generate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial1);
		
		textOut = (TextView) findViewById(R.id.change);
		textIn = (EditText) findViewById(R.id.editText1);
		gravity = (RadioGroup) findViewById(R.id.gravityGroup);
		style = (RadioGroup) findViewById(R.id.styleGroup);
		generate = (Button) findViewById(R.id.generate);
		

		gravity.setOnCheckedChangeListener(this);
		style.setOnCheckedChangeListener(this);
		generate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textOut.setText(textIn.getText());
			}
		});
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId){
		case R.id.left: 
			textOut.setGravity(Gravity.LEFT);
			break;
		case R.id.right:
			textOut.setGravity(Gravity.RIGHT);
			break;
		case R.id.center:
			textOut.setGravity(Gravity.CENTER);
			break;
		case R.id.normal:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL), Typeface.NORMAL);
			break;
		case R.id.italic:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC), Typeface.ITALIC);
			break;
		case R.id.bold:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD), Typeface.BOLD);
			break;
		}
	}

}
