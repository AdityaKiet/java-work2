package com.aditya;

import java.util.Scanner;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class LocationFinder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String ip = scanner.nextLine();
		GeoIPService geoIPService = new GeoIPService();
		GeoIPServiceSoap geoIPServiceSoap = geoIPService.getGeoIPServiceSoap();
		GeoIP geoIP = geoIPServiceSoap.getGeoIP(ip);
		System.out.println(geoIP.getCountryName());
		scanner.close();
	}

}
