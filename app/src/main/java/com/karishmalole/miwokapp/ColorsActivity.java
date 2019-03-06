package com.karishmalole.miwokapp;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_colors);


        final ArrayList<WordList> colors = new ArrayList<WordList>();

        colors.add(new WordList("red" , "weṭeṭṭi" , R.drawable.color_red ,R.raw.color_red ));
        colors.add(new WordList("green" , "chokokki" , R.drawable.color_green ,R.raw.color_green ));
        colors.add(new WordList("brown" , "ṭakaakki" , R.drawable.color_brown , R.raw.color_brown));
        colors.add(new WordList("gray" , "ṭopoppi" , R.drawable.color_gray , R.raw.color_gray));
        colors.add(new WordList("black" , "kululli" , R.drawable.color_black , R.raw.color_black));
        colors.add(new WordList("white" , "kelelli" , R.drawable.color_white,R.raw.color_white));
        colors.add(new WordList("dusty yellow" , "ṭopiisә" , R.drawable.color_dusty_yellow ,
                R.raw.color_dusty_yellow));
        colors.add(new WordList("mustard yellow" , "chiwiiṭә" ,
                R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        ListView listView = (ListView) findViewById(R.id.ColorsList);
        final WordAdapter adapter = new WordAdapter(this , colors , R.color.category_colors);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WordList temp = colors.get(i);
                releaseMediaPlayer();
                media = MediaPlayer.create(ColorsActivity.this ,temp.getMediaPlayer());
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







