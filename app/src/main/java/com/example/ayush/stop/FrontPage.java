package com.example.ayush.stop;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.opengl.Visibility;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import java.lang.Math;

import org.w3c.dom.Text;

public class FrontPage extends AppCompatActivity {

    Button btnStart;
    TextView txtTimer;
    Handler customHandler = new Handler();
    LinearLayout container;
    Switch switch1;
    RelativeLayout layout;

    long startTime=0L, timeInMilliseconds=0L, timeSwapBuff=0L, updateTime=0L;
    int level = 1;
    String compare;

    Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            timeInMilliseconds = SystemClock.elapsedRealtimeNanos()-startTime;
            updateTime = timeSwapBuff+timeInMilliseconds;

            if (level >=1 & level < 10){
                int secs = (int)(updateTime/(1000000000/level));
                setCompare("" + String.format("%1d" , secs));
                txtTimer.setText(getCompare());
            }

            else if (level == 10){ //FIX THIS

                int secs = (int)(updateTime/(1000000000));
                int secs1 = (int)(updateTime/(1000000000/level));
                setCompare(""+ String.format("%1d", secs) + ":" + String.format("%2d", secs1).substring(String.format("%2d", secs1).length()-1));
                txtTimer.setText(getCompare());


            }

            else if (level == 100){
                int secs = (int)(updateTime/(1000000000));
                int secs1 = (int)(updateTime/(1000000000/10));
                int secs2 = (int)(updateTime/(1000000000/level));
                setCompare(""+ String.format("%1d", secs) + ":" + String.format("%2d", secs1).substring(String.format("%2d", secs1).length()-1)
                        + String.format("%1d", secs2).substring(String.format("%1d", secs2).length()-1));
                txtTimer.setText(getCompare());

            }

            else if (level == 1000){ //FIX THIS
                int secs = (int)(updateTime/(1000000000));
                int secs1 = (int)(updateTime/(1000000000/10));
                int secs2 = (int)(updateTime/(1000000000/100));
                int secs3 = (int)(updateTime/(1000000000/level));
                setCompare(""+ String.format("%1d", secs) + ":" + String.format("%2d", secs1).substring(String.format("%2d", secs1).length()-1)
                        + String.format("%1d", secs2).substring(String.format("%1d", secs2).length()-1) +
                        String.format("%1d", secs3).substring(String.format("%1d", secs3).length()-1));
                txtTimer.setText(getCompare());
            }

            else if (level == 10000){ //FIX THIS
                int secs = (int)(updateTime/(1000000000));
                int secs1 = (int)(updateTime/(1000000000/10));
                int secs2 = (int)(updateTime/(1000000000/100));
                int secs3 = (int)(updateTime/(1000000000/1000));
                int secs4 = (int)(updateTime/(1000000000/level));
                setCompare(""+ String.format("%1d", secs) + ":" + String.format("%2d", secs1).substring(String.format("%2d", secs1).length()-1)
                        + String.format("%1d", secs2).substring(String.format("%1d", secs2).length()-1) +
                        String.format("%1d", secs3).substring(String.format("%1d", secs3).length()-1) + ":"+ String.format("%2d", secs4).substring(String.format("%2d", secs4).length()-1));
                txtTimer.setText(getCompare());
            }

            else if (level == 100000){ //FIX THIS
                int secs = (int)(updateTime/(1000000000));
                int secs1 = (int)(updateTime/(1000000000/10));
                int secs2 = (int)(updateTime/(1000000000/100));
                int secs3 = (int)(updateTime/(1000000000/1000));
                int secs4 = (int)(updateTime/(1000000000/10000));
                int secs5 = (int)(updateTime/(1000000000/level));
                setCompare(""+ String.format("%1d", secs) + ":" + String.format("%2d", secs1).substring(String.format("%2d", secs1).length()-1)
                        + String.format("%1d", secs2).substring(String.format("%1d", secs2).length()-1) +
                        String.format("%1d", secs3).substring(String.format("%1d", secs3).length()-1) + ":"+ String.format("%2d", secs4).substring(String.format("%2d", secs4).length()-1)
                        + String.format("%1d", secs5).substring(String.format("%1d", secs5).length()-1));
                txtTimer.setText(getCompare());
            }

            else if (level == 1000000){ //FIX THIS
                int secs = (int)(updateTime/(1000000000));
                int secs1 = (int)(updateTime/(1000000000/10));
                int secs2 = (int)(updateTime/(1000000000/100));
                int secs3 = (int)(updateTime/(1000000000/1000));
                int secs4 = (int)(updateTime/(1000000000/10000));
                int secs5 = (int)(updateTime/(1000000000/100000));
                int secs6 = (int)(updateTime/(1000000000/level));
                setCompare(""+ String.format("%1d", secs) + ":" + String.format("%2d", secs1).substring(String.format("%2d", secs1).length()-1)
                        + String.format("%1d", secs2).substring(String.format("%1d", secs2).length()-1) +
                        String.format("%1d", secs3).substring(String.format("%1d", secs3).length()-1) + ":"+ String.format("%2d", secs4).substring(String.format("%2d", secs4).length()-1)
                        + String.format("%1d", secs5).substring(String.format("%1d", secs5).length()-1) + String.format("%1d", secs6).substring(String.format("%1d", secs6).length()-1));
                txtTimer.setText(getCompare());
            }

            customHandler.postDelayed(this, 0);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        btnStart = (Button)(findViewById(R.id.btnStart));
        btnStart.setText("START");
        txtTimer = (TextView)(findViewById(R.id.txtTimer));
        container = (LinearLayout)(findViewById(R.id.container));


        btnStart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if (btnStart.getText()=="START"){
                    startTime = SystemClock.elapsedRealtimeNanos();
                    customHandler.postDelayed(updateTimerThread, 0);
                    btnStart.setText("STOP");
                }

                else if (btnStart.getText()== "STOP"){
                    if (level == 1) {
                        if (getCompare().equals("5")){
                            increaseLevel();
                            btnStart.setText("NEXT LEVEL");
                        }

                        else{
                            btnStart.setText("TRY AGAIN");
                        }
                    }

                    else if (level == 10){
                        if (getCompare().equals("5:0")){
                            increaseLevel();
                            btnStart.setText("NEXT LEVEL");
                        }

                        else{
                            btnStart.setText("TRY AGAIN");
                        }
                    }

                    else if (level == 100){
                        if (getCompare().equals("5:00")){
                            increaseLevel();
                            btnStart.setText("NEXT LEVEL");
                        }
                        else{
                            btnStart.setText("TRY AGAIN");
                        }
                    }

                    else if (level == 1000){
                        if (getCompare().equals("5:000")){
                            increaseLevel();
                            btnStart.setText("NEXT LEVEL");
                        }
                        else{
                            btnStart.setText("TRY AGAIN");
                        }
                    }

                    else if (level == 10000){
                        if (getCompare().equals("5:000:0")){
                            increaseLevel();
                            btnStart.setText("NEXT LEVEL");
                        }
                        else{
                            btnStart.setText("TRY AGAIN");
                        }
                    }

                    else if (level == 100000){
                        if (getCompare().equals("5:000:00")){
                            increaseLevel();
                            btnStart.setText("NEXT LEVEL");
                        }
                        else{
                            btnStart.setText("TRY AGAIN");
                        }
                    }

                    else if (level == 100000){
                        if (getCompare().equals("5:000:000")){
                            increaseLevel();
                            btnStart.setText("NEXT LEVEL");
                        }
                        else{
                            btnStart.setText("TRY AGAIN");
                        }
                    }


                    else{
                        btnStart.setText("START");
                    }

                    timeSwapBuff+=timeInMilliseconds;
                    customHandler.removeCallbacks(updateTimerThread);
                }

                else if (btnStart.getText()== "NEXT LEVEL"){
                    startTime = 0L;
                    startTime = SystemClock.elapsedRealtimeNanos() + 5000000000L;
                    customHandler.postDelayed(updateTimerThread, 0);
                    btnStart.setText("STOP");
                }

                else if (btnStart.getText().equals("TRY AGAIN")){
                    tryAgain();
                }

            }
        });

        layout = (RelativeLayout)(findViewById(R.id.panel));
        switch1= (Switch) (findViewById(R.id.switch1));

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    switch1.setTextColor(Color.WHITE);
                    layout.setBackgroundColor(Color.GRAY);
                    btnStart.setBackgroundColor(Color.WHITE);
                    btnStart.setTextColor(Color.GRAY);
                    txtTimer.setTextColor(Color.WHITE);
                }

                else{
                    switch1.setTextColor(Color.BLACK);
                    int myColor = getResources().getColor(R.color.back);
                    layout.setBackgroundColor(myColor);
                    int defaults = getResources().getColor(R.color.defaults);

                    switch1.setTextColor(defaults);
                    btnStart.setBackgroundColor(defaults);
                    btnStart.setTextColor(myColor);
                    txtTimer.setTextColor(defaults);

                }

            }
        });


    }

    public void increaseLevel(){
        level*=10;
    }

    public void setCompare(String s){
        compare = s;
    }

    public String getCompare(){
        return compare;
    }

    public void tryAgain(){ //FIX
        startTime = 0L;
        String str = getCompare();
        str = str.replaceAll("[.:]", "");
        long count = ((long) (Integer.parseInt(str) * Math.pow(10, 10-str.length())));

        startTime = SystemClock.elapsedRealtimeNanos() + count;
        customHandler.postDelayed(updateTimerThread, 0);
        btnStart.setText("STOP");
    }
}
