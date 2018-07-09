package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	static public String getDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
}
