package com.dev.viktorg.soundsofnature.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.dev.viktorg.soundsofnature.R;
import com.dev.viktorg.soundsofnature.service.ListViewService;
import com.dev.viktorg.soundsofnature.service.MediaPlayerService;
import com.dev.viktorg.soundsofnature.model.ModelList;
import com.dev.viktorg.soundsofnature.model.ModelService;

public class ListenerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litener);

        ModelList modelList = new ModelList(ModelService.getModels(this,
                getIntent().getType()));

        ListViewService.setListView(this, modelList.getNames(), modelList.getImageIds(),
                R.id.list, getListener(modelList));
    }

    @Override
    protected void onPause() {
        super.onPause();
        MediaPlayerService.stopMusic();
    }

    private AdapterView.OnItemClickListener getListener(final ModelList modelList) {
        return new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayerService.stopMusic();
                MediaPlayerService.playMusicOfEntity(ListenerActivity.this, modelList.get(position));
            }
        };
    }
}
