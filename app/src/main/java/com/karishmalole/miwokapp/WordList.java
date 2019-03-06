package com.karishmalole.miwokapp;

public class WordList {

   private String english , mivok ;
   private final int imageProvided = -1 ;
   private int mediaPlayer=0 ;
    private int image = imageProvided ;
    WordList(String eng , String miv , int img , int media)
   {
     english = eng ;
     mivok = miv ;
     image = img;
    mediaPlayer = media;
   }
   WordList(String eng , String miv , int media)
   {
       english = eng ;
       mivok = miv ;
       mediaPlayer = media;

   }
   public String getEnglish()
   {
       return(english);
   }
    public String getMivok()
    {
        return(mivok);
    }
    public int getImage(){return image ;}
    public boolean type()
    {
        return image!=imageProvided ;
    }
    public  int getMediaPlayer(){return  mediaPlayer;}
}
