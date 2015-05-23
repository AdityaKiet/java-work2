package org.sms.jfreesms;

import org.sms.jfreesms.exception.NotAuthenticatedException;
import org.sms.jfreesms.fullonsms.FullonSMS;
import org.sms.jfreesms.sms160by2.SMS160by2;
import org.sms.jfreesms.way2sms.Way2SMS;

public class SendSMS {

	public boolean send(){
	SMS sms = new FullonSMS();
	System.out.println(sms.login("9761604698","907b65"));
	System.out.println(sms.isAuthenticated());
	try {
	    sms.send("8267894544", "hi!");
	    System.out.println("sent1");
	    sms.send("9761604698", "hello!!");
	    System.out.println("sent2");
	    return true;
	} catch (NotAuthenticatedException ex) {
	    ex.printStackTrace();
	    return false;
	}
}
}
