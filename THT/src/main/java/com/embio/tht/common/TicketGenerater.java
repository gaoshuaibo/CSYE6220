package com.embio.tht.common;

import com.embio.tht.beans.*;

public final class TicketGenerater {
	
    public static String generateCode() {
        String code = "";
        int temp;
        for (int index = 0; index < 10; index++) {
            temp = extractNumber(9);
            code = code + String.valueOf(temp);
        }
        return code;
    }

    private static int extractNumber(int max) {
        return (int) (Math.random() * max + 1);
    }
}
