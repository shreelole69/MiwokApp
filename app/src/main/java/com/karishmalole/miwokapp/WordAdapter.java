package com.karishmalole.miwokapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<WordList>
{
    private Context mContext ;
    private ArrayList<WordList> myArrayList = new ArrayList<WordList>();
    int colorid ;
    WordAdapter(Context m , ArrayList<WordList> list , int color)
    {
        super(m , 0 , list);
        mContext = m ;
        myArrayList = list;
        colorid = color ;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem==null)
        {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.image_list_item,parent,false);
        }
        WordList currentWord = myArrayList.get(position);
        ImageView MyImage = (ImageView) listItem.findViewById(R.id.MyImage);
        if(currentWord.type()) {
            MyImage.setImageResource(currentWord.getImage());
        }
        else
        {
            MyImage.setVisibility(View.GONE);
        }
        TextView mivok = (TextView) listItem.findViewById(R.id.firstImage);
        mivok.setText(currentWord.getMivok());
        TextView English = (TextView) listItem.findViewById(R.id.secondImage);
        English.setText(currentWord.getEnglish());
        LinearLayout ly = (LinearLayout) listItem.findViewById(R.id.MyLinearLayout);
        ly.setBackgroundResource(colorid);
        return (listItem);


    }

}
