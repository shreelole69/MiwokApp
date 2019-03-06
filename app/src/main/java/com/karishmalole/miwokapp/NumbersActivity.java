package com.karishmalole.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_numbers);


      final  ArrayList<WordList> number = new ArrayList<WordList>();

        number.add(new WordList("one" , "lutii" , R.drawable.number_one , R.raw.number_one));
        number.add(new WordList("two" , "otiiko" , R.drawable.number_two , R.raw.number_two));
        number.add(new WordList("three" , "tolookosu" , R.drawable.number_three , R.raw.number_three));
        number.add(new WordList("four" , "oyyisa" , R.drawable.number_four , R.raw.number_four));
        number.add(new WordList("five" , "massoka" , R.drawable.number_five , R.raw.number_five));
        number.add(new WordList("six" , "temmoka" , R.drawable.number_six , R.raw.number_six));
        number.add(new WordList("seven" , "kenekaku" , R.drawable.number_seven , R.raw.number_seven));
        number.add(new WordList("eight" , "kawinta" , R.drawable.number_eight , R.raw.number_eight));
        number.add(new WordList("nine" , "wo'e" , R.drawable.number_nine , R.raw.number_nine));
        number.add(new WordList("ten" , "na'aacaha" , R.drawable.number_ten , R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, number , R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WordList temp = number.get(i);
                releaseMediaPlayer();
                media = MediaPlayer.create(NumbersActivity.this ,temp.getMediaPlayer());
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
