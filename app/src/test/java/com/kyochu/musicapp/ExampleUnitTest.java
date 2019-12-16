package com.kyochu.musicapp;

import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        for (int i = 0; i < 100000; i++) {
            int x=52*i+2;
            if(x%14==4&&x%19==1&&x%25==5){
                System.out.println(x);
            }
        }
    }
}