package com.example.tvdemo;

import android.app.Activity;
import android.content.Context;
import android.media.tv.TvInputInfo;
import android.media.tv.TvInputManager;
import android.media.tv.TvView;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class TVDemoActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvdemo);

        TvInputManager tvInputManager = (TvInputManager) getSystemService(Context.TV_INPUT_SERVICE);
        final List<TvInputInfo> list = tvInputManager.getTvInputList();
        for (int i = 0; i < list.size(); i++) {
            TvInputInfo info = list.get(i);
            android.util.Log.d("zhaokai5", "tv input " + i + ":" + info.getId());
            android.util.Log.d("zhaokai5", "tv input " + i + " tisName:" + String.valueOf(info.loadLabel(getApplicationContext())));
        }

        Button btnSetAv = (Button)findViewById(R.id.btn_set_av);
        btnSetAv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TvView tvView = (TvView) findViewById(R.id.test_tv_view);
                android.util.Log.d("zhaokai5", "change input to AV");
                for (int i=0; i<list.size(); i++) {
                    String tisName = String.valueOf(list.get(i).loadLabel(TVDemoActivity.this));
                    if (tisName.equals("Composite")) {
                        tvView.tune(list.get(i).getId(), Uri.parse("content://main"));
                        break;
                    }
                }
            }
        });

        Button btnSetHdmi1 = (Button)findViewById(R.id.btn_set_hdmi1);
        btnSetHdmi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TvView tvView = (TvView) findViewById(R.id.test_tv_view);
                android.util.Log.d("zhaokai5", "change input to HDMI1");
                for (int i=0; i<list.size(); i++) {
                    String tisName = String.valueOf(list.get(i).loadLabel(TVDemoActivity.this));
                    if (tisName.equals("HDMI 1")) {
                        tvView.tune(list.get(i).getId(), Uri.parse("content://main"));
                        break;
                    }
                }
            }
        });

        Button btnSetAtv = (Button)findViewById(R.id.btn_set_atv);
        btnSetAtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TvView tvView = (TvView) findViewById(R.id.test_tv_view);
                android.util.Log.d("zhaokai5", "change input to ATV");
                for (int i=0; i<list.size(); i++) {
                    String tisName = String.valueOf(list.get(i).loadLabel(TVDemoActivity.this));
                    if (tisName.equals("ATV")) {
                        tvView.tune(list.get(i).getId(), Uri.parse("content://main"));
                        break;
                    }
                }
            }
        });

        Button btnSetDtv = (Button)findViewById(R.id.btn_set_dtv);
        btnSetDtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TvView tvView = (TvView) findViewById(R.id.test_tv_view);
                android.util.Log.d("zhaokai5", "change input to DTV");
                for (int i=0; i<list.size(); i++) {
                    String tisName = String.valueOf(list.get(i).loadLabel(TVDemoActivity.this));
                    if (tisName.equals("DTV")) {
                        tvView.tune(list.get(i).getId(), Uri.parse("content://main"));
                        break;
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tvdemo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
