package com.jihwan.soccer.mail.common;

import java.util.Random;

public class TempKey {

    public static String otp(int length){

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < length; i++){

            sb.append(random.nextInt(length));
        }
        return sb.toString();
    }
}
