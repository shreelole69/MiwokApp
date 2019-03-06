package com.karishmalole.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_phrases);
        final ArrayList<WordList> phrases = new ArrayList<WordList>();

        phrases.add(new WordList("Where are you going?","minto wuksus" , R.raw.phrase_where_are_you_going ));
        phrases.add(new WordList("What is your name?" , "tinnә oyaase'nә" , R.raw.phrase_what_is_your_name));
        phrases.add(new WordList("My name is...", "oyaaset..." , R.raw.phrase_my_name_is));
        phrases.add(new WordList( "How are you feeling?", "michәksәs?" , R.raw.phrase_how_are_you_feeling));
        phrases.add(new WordList("I’m feeling good.", "kuchi achit" , R.raw.phrase_im_feeling_good));
        phrases.add(new WordList("Are you coming?", "әәnәs'aa?" , R.raw.phrase_are_you_coming));
        phrases.add(new WordList("Yes, I’m coming."," hәә’ әәnәm " , R.raw.phrase_yes_im_coming));
        phrases.add(new WordList("I’m coming.","әәnәm" , R.raw.phrase_im_coming));
        phrases.add(new WordList("Let’s go.","yoowutis" , R.raw.phrase_lets_go));
        phrases.add(new WordList("Come here.","әnni'nem" , R.raw.phrase_come_here));

        ListView listView = (ListView) findViewById(R.id.PhrasesList);
        WordAdapter adapter = new WordAdapter(this , phrases , R.color.category_phrases);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WordList temp = phrases.get(i);
                releaseMediaPlayer();
                media = MediaPlayer.create(PhrasesActivity.this ,temp.getMediaPlayer());
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
