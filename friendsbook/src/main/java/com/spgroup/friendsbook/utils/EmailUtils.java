package com.spgroup.friendsbook.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.spgroup.friendsbook.exception.CustomException;

public class EmailUtils {
	
	private static Logger logger = LoggerFactory.getLogger(EmailUtils.class);
	
	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static void check(String...emails) throws CustomException {
		for (String email : emails) {
			if(StringUtils.isEmpty(email)) {
				logger.error("Email Address is empty");
				throw new CustomException("Email Address is empty");
			}
			
			if(email.length() > 80) {
				logger.error("Email Address is more than 80 characters");
				throw new CustomException("Email Address is more than 80 characters");
			}
			
			if(!email.matches(EMAIL_PATTERN)) {
				logger.error("Email Address is not correct format");
				throw new CustomException("Email Address is not correct format");
			}
		}
	}
}
