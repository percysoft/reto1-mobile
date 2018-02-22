package com.example.percy.reto1_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textTime, textState, cant_work, cant_break;
    Button buttonStartWork, buttonStartBreak, buttonStopWork,buttonStopBreak;
    int count_work = 0, count_break = 0;
    long timerWork= 1500000 ,timerBreak=300000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTime = (TextView) findViewById(R.id.text_time);
        textState = (TextView) findViewById(R.id.text_state);
        cant_work = (TextView) findViewById(R.id.cant_work);
        cant_break = (TextView) findViewById(R.id.cant_break);
        buttonStartWork = (Button) findViewById(R.id.buttonWork);
        buttonStartBreak = (Button) findViewById(R.id.buttonBreak);
        buttonStopWork = (Button) findViewById(R.id.buttonStopWork);
        buttonStopBreak = (Button) findViewById(R.id.buttonStopBreak);

        buttonStartBreak.setVisibility(View.INVISIBLE);
        buttonStopWork.setVisibility(View.INVISIBLE);
        buttonStopBreak.setVisibility(View.INVISIBLE);
        final timer timer = new timer();

        buttonStartWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timer.startTime(textTime, textState, timerWork, buttonStartBreak, buttonStartWork,buttonStopWork,buttonStopBreak, 1);
                count_work++;
                cant_work.setText("Cantidad de trabajo : " + count_work);
                buttonStopWork.setVisibility(View.VISIBLE);

            }
        });
        buttonStartBreak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.startTime(textTime, textState, timerBreak, buttonStartBreak, buttonStartWork,buttonStopWork,buttonStopBreak, 0);
                count_break++;
                cant_break.setText("Cantidad de receso : " + count_break);
                buttonStopBreak.setVisibility(View.VISIBLE);
            }
        });
        buttonStopWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.pause(buttonStartWork,buttonStartBreak,buttonStopWork,1);
            }
        });
        buttonStopBreak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.pause(buttonStartWork,buttonStartBreak,buttonStopBreak,0);
            }
        });
    }
}


