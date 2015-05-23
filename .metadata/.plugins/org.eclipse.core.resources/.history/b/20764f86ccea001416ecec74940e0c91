package org.sms.jfreesms;

import org.sms.jfreesms.exception.NotAuthenticatedException;
import org.sms.jfreesms.sms160by2.SMS160by2;
import org.sms.jfreesms.way2sms.Way2SMS;

public class SendSMS {

	SMS sms = new Way2SMS();
	sms.login("9999999999", "passwd");
	System.out.println(sms.isAuthenticated());
	try {
	    sms.send("8374566903", "hi!");
	    sms.send("8374566903", "hello!!");
	} catch (NotAuthenticatedException ex) {
	    ex.printStackTrace();
	}
}
