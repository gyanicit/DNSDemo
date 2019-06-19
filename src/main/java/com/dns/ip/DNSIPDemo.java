package com.dns.ip;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class DNSIPDemo {
	public static void main(String[] args) {
        CamelContext ctx = new DefaultCamelContext();
        try {
			ctx.addRoutes(new DNSIPRoute());
			ctx.start();
//			ctx.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
