package com.example.percy.reto1_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textTime, textState, cant_work, cant_break;
    Button buttonStart, buttonBreak, buttonPause;
    int count_work = 0, count_break = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTime = (TextView) findViewById(R.id.text_time);
        textState = (TextView) findViewById(R.id.text_state);
        cant_work = (TextView) findViewById(R.id.cant_work);
        cant_break = (TextView) findViewById(R.id.cant_break);
        buttonStart = (Button) findViewById(R.id.button);
        buttonBreak = (Button) findViewById(R.id.buttonBreak);
//        buttonPause = (Button) findViewById(R.id.buttonPause);
        buttonBreak.setVisibility(View.INVISIBLE);
//        buttonPause.setVisibility(View.INVISIBLE);
        final timer timer = new timer();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timer.startTime(textTime, textState, 30000, buttonBreak, buttonStart, 1);
                count_work++;
                cant_work.setText("Cantidad de trabajo : " + count_work);
            }
        });
        buttonBreak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.startTime(textTime, textState, 15000, buttonBreak, buttonStart, 0);
                count_break++;
                cant_break.setText("Cantidad de receso : " + count_break);
            }
        });
//        buttonPause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                timer.pause(buttonStart,buttonBreak);
//                buttonPause.setVisibility(View.INVISIBLE);
//            }
//        });
    }
}


