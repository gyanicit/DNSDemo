package com.dns.lookup;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class DNSLookupDemo {
	public static void main(String[] args) {
        CamelContext ctx = new DefaultCamelContext();
        try {
			ctx.addRoutes(new DNSLookupRoute());
			ctx.start();
//			ctx.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
