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
    Boolean Work=false,Break=false;

    public void startTime(final TextView textView,final TextView textState, long timerInit,final Button buttonBreak,final Button buttonStart,final int state) {
        countDownTimer = new CountDownTimer(timerInit, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText("" + String.format("%d : %d ",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                if(state == 1) {
                    textState.setText("En proceso... Trabajando");
                    Work=true;
                    buttonStart.setVisibility(View.INVISIBLE);
                    buttonBreak.setVisibility(View.INVISIBLE);
                }
                if (state == 0) {
                    textState.setText("En proceso... Descansando");
                    Break=true;
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
                }
                if (state == 0) {
                    textState.setText("Finalizo Tiempor descanso!");
                    buttonBreak.setVisibility(View.INVISIBLE);
                    buttonStart.setVisibility(View.VISIBLE);
                }

            }
        }.start();
    }

//    public void pause(Button buttonStart,Button buttonBreak) {
//        countDownTimer.cancel();
//        if(Work = true ){
//            buttonStart.setVisibility(View.VISIBLE);
//        }
//        if (Break = true) {
//            buttonBreak.setVisibility(View.VISIBLE);
//        }
//
//    }
}
