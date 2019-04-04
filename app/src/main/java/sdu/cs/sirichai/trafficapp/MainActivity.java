package sdu.cs.sirichai.trafficapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    ListView listView;
    int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03,
            R.drawable.traffic_04, R.drawable.traffic_05, R.drawable.traffic_06, R.drawable.traffic_07,
            R.drawable.traffic_08, R.drawable.traffic_09, R.drawable.traffic_10, R.drawable.traffic_11,
            R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15,
            R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18, R.drawable.traffic_19,
            R.drawable.traffic_20};
    String[] titleStrings, detailStrings, subStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ผูกตัวแปร JAVA กับ xml
        listView = findViewById(R.id.livTraffic);

        //ดึงค่าจาก my_content มาแสดงผมบนหน้า xml
        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);

        //subStrings Detail ตัดข้อความ detail ให้สั้นลง
        subStrings = new String[detailStrings.length];
        for (int i=0; i<detailStrings.length;i++){
            subStrings[i]=detailStrings[i].substring(0, 10) + "...";
        }//end for

        //Create ListView
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, ints, titleStrings, subStrings);
        listView.setAdapter(myAdapter);

        //ทำการเชื่องโยงแต่ละรายการใน listView ให้ลิงก์ไปหน้า Detail
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                //ส่งข้อมูลไปหน้า Detail
                Intent detaiIntent = new Intent(MainActivity.this, Detail.class);
                //ส่งข้อมูล
                detaiIntent.putExtra("Title", titleStrings[i]);
                detaiIntent.putExtra("Detail", detailStrings[i]);
                detaiIntent.putExtra("Logo", ints[i]);
                //เริ่มส่งข้อมูล
                startActivity(detaiIntent);
            }
        });//end OnItemClickListener

    }//end onCreate

    public void clickMoreinfo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.dlt.go.th/th/"));
        startActivity(intent);
    }//end clickMoreinfo

    public void clickAboutApp(View view) {
        Intent aboutAppIntent = new Intent(MainActivity.this, AboutApp.class);
        startActivity(aboutAppIntent);
    }//end clickAboutApp
}//end Class
