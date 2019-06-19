package com.dns.dig;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class DNSDigDemo {
	public static void main(String[] args) {
        CamelContext ctx = new DefaultCamelContext();
        try {
        	DNSDigRouteBuilder dnsDigRouteBuilder=new DNSDigRouteBuilder();
        	dnsDigRouteBuilder.setContext(ctx);
			ctx.addRoutes(dnsDigRouteBuilder);
			ctx.start();
			
			ProducerTemplate template = ctx.createProducerTemplate();
			
			DNSDigDTO digDTO=new DNSDigDTO();
			digDTO.setIpAddress("173.208.194.154");
			digDTO.setName("ns11.hostamity.com");
			digDTO.setClassName("IN");
			digDTO.setDnsType("A");
			
			template.sendBody("direct:start", digDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
