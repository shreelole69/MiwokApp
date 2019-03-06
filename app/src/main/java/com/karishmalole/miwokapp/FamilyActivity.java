package com.karishmalole.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer media ;
    private MediaPlayer.OnCompletionListener mMedia = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
          releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

      final ArrayList<WordList> family = new ArrayList<WordList>();
        family.add(new WordList("father", "әpә" , R.drawable.family_father , R.raw.family_father));
        family.add(new WordList("mother", "әṭa" , R.drawable.family_mother , R.raw.family_mother));
        family.add(new WordList("son", "angsi" , R.drawable.family_son , R.raw.family_son));
        family.add(new WordList("daughter", "tune" , R.drawable.family_daughter , R.raw.family_daughter));
        family.add(new WordList("older brother", "taachi" , R.drawable.family_older_brother
                , R.raw.family_older_brother));
        family.add(new WordList("younger brother", "chalitti" ,
                R.drawable.family_younger_brother , R.raw.family_younger_brother));
        family.add(new WordList("older sister", "teṭe" ,
                R.drawable.family_older_sister , R.raw.family_older_sister));
        family.add(new WordList("younger sister", "kolliti" ,
                R.drawable.family_younger_sister , R.raw.family_younger_sister));
        family.add(new WordList("grandmother", "ama" ,
                R.drawable.family_grandmother , R.raw.family_grandmother));
        family.add(new WordList("grandfather", "paapa" ,
                R.drawable.family_grandfather , R.raw.family_grandfather));


        ListView listView = (ListView) findViewById(R.id.FamilyList);
        WordAdapter adapter = new WordAdapter(this , family , R.color.category_family);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WordList temp = family.get(i);
                releaseMediaPlayer();
                media = MediaPlayer.create(FamilyActivity.this ,temp.getMediaPlayer());
                media.start();
                media.setOnCompletionListener(mMedia);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (media != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            media.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            media = null;
        }
    }
}
