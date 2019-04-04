package sdu.cs.sirichai.trafficapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutApp extends AppCompatActivity {

    //Explicit
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
    }//end onCreate

    public void clickBack(View view) {
        finish();
    }//end clickBack

    public void playSound(View view) {
        mediaPlayer = MediaPlayer.create(this,R.raw.sound);
        mediaPlayer.start();
    }//end playSound

    public void clickFB(View view) {
        Intent fbIntent = new Intent(Intent.ACTION_VIEW);
        fbIntent.setData(Uri.parse("https://www.facebook.com/100002277116076"));
        startActivity(fbIntent);
    }//end clickFB

    public void clickMobile(View view) {
        Intent mobileIntent = new Intent(Intent.ACTION_DIAL);
        mobileIntent.setData(Uri.parse("tel: 0990065815"));
        startActivity(mobileIntent);
    }//end clickMobile

    public void clickMap(View view) {
        Uri location = Uri.parse("https://www.google.co.th/maps/place/%E0%B8%A1%E0%B8%AB%E0%B8%B2%E0%B8%A7%E0%B8%B4%E0%B8%97%E0%B8%A2%E0%B8%B2%E0%B8%A5%E0%B8%B1%E0%B8%A2%E0%B8%AA%E0%B8%A7%E0%B8%99%E0%B8%94%E0%B8%B8%E0%B8%AA%E0%B8%B4%E0%B8%95/@13.7747537,100.5096181,17.54z/data=!4m5!3m4!1s0x0:0x5feff31367bdbe1d!8m2!3d13.7760039!4d100.5106276?hl=th");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        //mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }//end clickMap
}//end Class
