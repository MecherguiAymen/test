package com.sha.springbootbookseller.util;

import java.time.LocalDateTime;

public final class Utils {
	
	public Utils() {}
	public static boolean hasDateExpired(int days,LocalDateTime saveDate,LocalDateTime curentDate) {
		
        boolean hasExpired = false;
        if(saveDate != null && curentDate != null) {
            /* has expired if the saved date plus the specified days is still before the current date (today) */
            if(saveDate.plusDays(days).isBefore(curentDate)) {
                hasExpired = true;
            }  
            }
        return hasExpired;

	}

}
