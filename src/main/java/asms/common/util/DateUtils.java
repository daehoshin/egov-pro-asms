package asms.common.util;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * @PackageName asms.common.util
 * @FileName DateUtils.java
 * @Author DAE.HO.SHIN
 * @Since 2016. 3. 29.
 */
public class DateUtils {
	
	public static String CurrentDate(){
		Date now = new Date();
		String currentDate =  DateFormatUtils.format(now, "yyyyMMddHHmmss");
		return currentDate;
	}
    
}
