package com.dev.viktorg.soundsofnature.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.dev.viktorg.soundsofnature.R;

public class TabActivity extends android.app.TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpec;

        // создаем вкладку и указываем тег
        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("Animal");
        Intent animalIntent = new Intent(this, ListenerActivity.class);
        animalIntent.setType("animal");
        tabSpec.setContent(animalIntent);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Transport");
        Intent transportIntent = new Intent(this, ListenerActivity.class);
        transportIntent.setType("transport");
        tabSpec.setContent(transportIntent);
        tabSpec.setContent(transportIntent);
        tabHost.addTab(tabSpec);

        // обработчик переключения вкладок
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            public void onTabChanged(String tabId) {
               // Toast.makeText(getBaseContext(), "tabId = " + tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
