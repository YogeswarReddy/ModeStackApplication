package com.app.util;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class UserUtil {
	
	
	public String getToken() {
        String charcters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < 41) { // length of the random string.
            int index = (int) (rnd.nextFloat() * charcters.length());
            builder.append(charcters.charAt(index));
        }
        
        return builder.toString();

    }

}
