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
        Uri location = Uri.parse("http://maps.google.com/maps?z=10&q=loc:13.776109, 100.509849");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        //mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }//end clickMap
}//end Class
