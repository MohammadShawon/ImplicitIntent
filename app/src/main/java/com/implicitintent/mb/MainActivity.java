package com.implicitintent.mb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.btnCamera).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent();
				i.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
				startActivity(i);
			}
		});
		final EditText et = (EditText) findViewById(R.id.etNo);
		findViewById(R.id.btnGallery).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent();
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("content://media/external/images/media/"));
				startActivity(i);
			}
		});
		
		findViewById(R.id.btnCallLog).setOnClickListener(new View.OnClickListener() {

			
			
			@Override
			public void onClick(View v) {
			
				Intent i = new Intent();
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("content://call_log/calls/1"));
				startActivity(i);
			}
			
		});
		
		findViewById(R.id.btnBrowser).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent i = new Intent();
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("http://www.google.com/"));
				startActivity(Intent.createChooser(i, "Title"));
			}
		});
		
		findViewById(R.id.btnContact).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent();
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("content://contacts/people/"));
				startActivity(i);
			}
		});
		
		findViewById(R.id.btnCall).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// AndroidManifest.xml -> Permissions -> Add ->
				// Uses Permission -> android.permission.CALL_PHONE -> Save
				Intent i = new Intent();
				i.setAction(Intent.ACTION_CALL);
				i.setData(Uri.parse("tel:"+et.getText()));
				startActivity(i);
			}
		});
		
		findViewById(R.id.btnDial).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent();
				i.setAction(Intent.ACTION_DIAL);
				i.setData(Uri.parse("tel:"+et.getText()));
				startActivity(i);
				
			Intent I = new Intent(Intent.ACTION_DIAL, Uri
					.parse("tel:" + et.getText()));
			startActivity(i);
				
			startActivity(new Intent(Intent.ACTION_DIAL, Uri
					.parse("tel:" + et.getText())));
			
			}
		});
		
	}
}
