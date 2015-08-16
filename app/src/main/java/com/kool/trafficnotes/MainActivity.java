package com.kool.trafficnotes;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit

    private ListView trafficListView;
    private Button aboutMeButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial Widget
        initialWidget();

        //Button Controller
        buttonController();

        //Create ListView
        createListView();


    }   //Main Method.

    private void createListView() {

        //Setup Source of Images
        int[] intDrawable = new int[20];
        intDrawable[0] = R.drawable.traffic_01;
        intDrawable[1] = R.drawable.traffic_02;
        intDrawable[2] = R.drawable.traffic_03;
        intDrawable[3] = R.drawable.traffic_04;
        intDrawable[4] = R.drawable.traffic_05;
        intDrawable[5] = R.drawable.traffic_06;
        intDrawable[6] = R.drawable.traffic_07;
        intDrawable[7] = R.drawable.traffic_08;
        intDrawable[8] = R.drawable.traffic_09;
        intDrawable[9] = R.drawable.traffic_10;
        intDrawable[10] = R.drawable.traffic_11;
        intDrawable[11] = R.drawable.traffic_12;
        intDrawable[12] = R.drawable.traffic_13;
        intDrawable[13] = R.drawable.traffic_14;
        intDrawable[14] = R.drawable.traffic_15;
        intDrawable[15] = R.drawable.traffic_16;
        intDrawable[16] = R.drawable.traffic_17;
        intDrawable[17] = R.drawable.traffic_18;
        intDrawable[18] = R.drawable.traffic_19;
        intDrawable[19] = R.drawable.traffic_20;

        //Setup Title
        final String[] strTile = {"ห้ามเลี้ยวซ้าย","ห้ามเลี้ยวขวา","ตรงไป","เลี้ยวขวา","เลี้ยวซ้าย",
                "ทางออก","ทางเข้า","ทางออก","ให้หยุด","ห้ามสูงเกิน 2.5 เมตร",
                "แยกซ้ายขวา","ห้ามกลับรถ","ห้ามจอด","รถสวนทาง","ห้ามแซง",
                "ทางเข้า","หยุดตรวจ","จำกัดความเร็ว","กว้างไม่เกิน 2.5 เมตร","ห้ามสูงเกิน 5 เมตร",
        };

        //Drive Adapter
        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, strTile, intDrawable);
        trafficListView.setAdapter(objMyAdapter);

        //Active ListView
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Intent to detail activity
                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);

                objIntent.putExtra("Title", strTile[i]);

                startActivity(objIntent);

            } // Event Click
        });


    }   //createListView

    private void buttonController() {
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sound effect.
                MediaPlayer buttonPlayer = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_shut);
                buttonPlayer.start();

                //Intent to WebView
                Intent objIntent = new Intent(Intent.ACTION_VIEW);
                objIntent.setData(Uri.parse("http://www.yahoo.com"));
                startActivity(objIntent);


            }//event
        });
    }

    private void initialWidget() {
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.btnAboutMe);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}   //Main Class
