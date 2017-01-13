package com.dev.viktorg.soundsofnature.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.dev.viktorg.soundsofnature.R;

public class TabActivity extends android.app.TabActivity {
    TabHost tabHost;
    TabHost.TabSpec tabSpec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tabHost = getTabHost();

        setTab("tag1", "Animals");
        setTab("tag2", "Transport");
    }

    private void setTab(String tag, String indicator) {
        tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(indicator);
        Intent intent = new Intent(this, ListenerActivity.class);
        intent.setType(indicator);
        tabSpec.setContent(intent);
        tabHost.addTab(tabSpec);
    }
}
