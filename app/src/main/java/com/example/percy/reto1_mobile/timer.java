package com.example.percy.reto1_mobile;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by percy on 20/02/18.
 */

public class timer {

    CountDownTimer countDownTimer;

    public void startTime(final TextView textView,final TextView textState, long timerInit,final Button buttonBreak,
                          final Button buttonStart,final Button buttonStopWork,final Button buttonStopBreak,final int state) {
        countDownTimer = new CountDownTimer(timerInit, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText("" + String.format("%d : %d ",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                if(state == 1) {
                    textState.setText("En proceso... Trabajando");
                    buttonStart.setVisibility(View.INVISIBLE);
                    buttonBreak.setVisibility(View.INVISIBLE);
                }
                if (state == 0) {
                    textState.setText("En proceso... Descansando");
                    buttonStart.setVisibility(View.INVISIBLE);
                    buttonBreak.setVisibility(View.INVISIBLE);
                }
            }
            public void onFinish() {
                textView.setText("00:00");
                if(state == 1) {
                    textState.setText("Finalizo Tiempor primera tarea!");
                    buttonBreak.setVisibility(View.VISIBLE);
                    buttonStart.setVisibility(View.INVISIBLE);
                    buttonStopWork.setVisibility(View.INVISIBLE);
                }
                if (state == 0) {
                    textState.setText("Finalizo Tiempor descanso!");
                    buttonBreak.setVisibility(View.INVISIBLE);
                    buttonStart.setVisibility(View.VISIBLE);
                    buttonStopBreak.setVisibility(View.INVISIBLE);
                }

            }
        }.start();
    }

    public void pause(Button startWork,Button startBreak,Button stop,int state) {
        countDownTimer.cancel();
        if(state == 1) {
            stop.setVisibility(View.INVISIBLE);
            startBreak.setVisibility(View.VISIBLE);
        }
        if ( state == 0) {
            stop.setVisibility(View.INVISIBLE);
            startWork.setVisibility(View.VISIBLE);
        }


    }
}
