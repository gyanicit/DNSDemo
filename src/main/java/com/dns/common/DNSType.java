package com.dns.common;

public class DNSType {
	private static final String ip = "dns:ip";
	private static final String lookup = "dns:lookup";
	private static final String dig = "dns:dig";
	
	public static String getIp() {
		return ip;
	}
	public static String getLookup() {
		return lookup;
	}
	public static String getDig() {
		return dig;
	}
	
	
}
