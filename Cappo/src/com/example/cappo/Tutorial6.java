package com.example.cappo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Tutorial6 extends Activity {
	VideoView vid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial6);
		vid = (VideoView)findViewById(R.id.videoView1);
		String urlPath = "android.resource://" + getPackageName() + "/" + R.raw.my_video;
		vid.setVideoURI(Uri.parse(urlPath));
		vid.start();
		
		MediaController mc = new MediaController(this);
		mc.setMediaPlayer(vid);
		vid.setMediaController(mc);
	}
	
}
