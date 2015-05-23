package com.exam.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCountListener
 * 
 */
public class SessionCountListener implements HttpSessionListener {
	public static int counter = 0;

	public SessionCountListener() {
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		counter++;
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		counter--;
	}

}
