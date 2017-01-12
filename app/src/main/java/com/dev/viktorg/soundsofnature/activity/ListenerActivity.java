package com.dev.viktorg.soundsofnature.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dev.viktorg.soundsofnature.R;
import com.dev.viktorg.soundsofnature.adapter.CustomListAdapter;
import com.dev.viktorg.soundsofnature.model.entity.Entity;
import com.dev.viktorg.soundsofnature.model.entity.EntityList;
import com.dev.viktorg.soundsofnature.model.entity.EntityService;

public class ListenerActivity extends Activity {
    ListView listView;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litener);

        Intent intent = getIntent();
        final EntityList entityList = new EntityList(EntityService.getEntities(this, intent.getType()));

        CustomListAdapter adapter = new CustomListAdapter(this, entityList.getNames(),
                entityList.getImageIds());
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (mPlayer != null) {
                    mPlayer.stop();
                }

                final Entity entity = entityList.get(position);

                final int[] i = {0};
                mPlayer = MediaPlayer.create(ListenerActivity.this, entity.getAudioIds().get(i[0]++));
                mPlayer.start();
                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if(i[0] < entity.getAudioIds().size()) {
                            mPlayer = MediaPlayer.create(ListenerActivity.this, entity.getAudioIds().get(i[0]++));
                            mPlayer.start();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onPause () {
        super.onPause();
        if (mPlayer != null) {
            mPlayer.stop();
        }
    }
}
