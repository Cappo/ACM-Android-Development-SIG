package com.example.crystalball;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer buttonSound = MediaPlayer.create(MainActivity.this,R.raw.magic);
        
        //Declare our View variables and assign variables
        final TextView answerLabel = (TextView) findViewById(R.id.textView1);
        Button getAnswerButton = (Button) findViewById(R.id.button1);
        
        
        getAnswerButton.setOnClickListener(new View.OnClickListener() {
		String answer = "";	
			@Override
			public void onClick(View v) {
				//buttonSound.start();
				Random generator = new Random();
				int roll = generator.nextInt(5);
				
				switch(roll){
				case 0: answer = "Yes!"; break;
				case 1: answer = "NO!!!"; break;
				case 2: answer = "Maybe..."; break;
				case 3: answer = "Of course!"; break;
				case 4: answer = "Maybe later."; break;
				}
				
				answerLabel.setText(answer);
				
			}
		});		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
