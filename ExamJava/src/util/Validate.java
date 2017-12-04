package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Descaption class Validate.
 * 
 * @author User Create time Nov 28, 2017+9:37:34 AM
 */
public class Validate {
	Pattern pattern;
	Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Descaption ValiDate date. 
	 * User
	 * @param dateString
	 *          .
	 * @return boolean. 
	 * Nov 28, 2017
	 */
	public static boolean isValidDate(String dateString) {
		SimpleDateFormat df = new SimpleDateFormat("YYYY");
		try {
			df.parse(dateString);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * Descaption check validate email. 
	 * 
	 * @param email.
	 *          
	 * @return boolean. 
	 * Nov 28, 2017.
	 */
	public static boolean isEmail(String email) {
		if (email.isEmpty()) {
			return false;
		}
		return email.matches(EMAIL_PATTERN);
	}

}
