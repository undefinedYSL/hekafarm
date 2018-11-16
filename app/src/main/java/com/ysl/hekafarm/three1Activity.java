package com.ysl.hekafarm;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class three1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three1);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar04);
        toolbar.setTitle("详细介绍");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        StatusBarUtil.setImmersiveStatusBar(this,true);
        ImageView iv1_1=(ImageView)findViewById(R.id.iv_three1_1);
        Glide.with(this).load(R.drawable.gmh).into(iv1_1);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

