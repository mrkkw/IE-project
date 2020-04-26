package com.example.newgame;

import android.nfc.Tag;
import android.widget.TextView;

public class custom_text_view {

    private static TextView tv;
    private static String s;
    private static int length;
    private static long time;
    static int n = 0;
    private static int nn;

    public custom_text_view(TextView tv, String s, long time) {
        this.tv = tv;
        this.s = s;
        this.time = time;
        this.length = s.length();
        startTv(n);
    }

    public static void startTv(final int n) {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        try {
                            final String stv = s.substring(0, n);
                            tv.post(new Runnable() {
                                @Override
                                public void run() {
                                    tv.setText(stv);
                                }
                            });

                            Thread.sleep(time);

                            nn = n + 1;
                            if (nn <= length) {
                                startTv(nn);
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }

    public void setTime(int tt){
        time -= tt;
    }
}
