package com.vistar.filerecord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
Button bwrite;
Button bread;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bwrite = (Button)findViewById(R.id.b_write);
		bread = (Button)findViewById(R.id.b_read);
		bwrite.setOnClickListener(this);
		bread.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.b_read:
				Intent read = new Intent(this,ReadFile.class);
				startActivity(read);
				break;
			case R.id.b_write:
				Intent write = new Intent(this,WriteFile.class);
				startActivity(write);
				break;
		}
		
	}

}
