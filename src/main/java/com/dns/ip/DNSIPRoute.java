package com.dns.ip;
import org.apache.camel.builder.RouteBuilder;

import com.dns.common.DNSType;

public class DNSIPRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jetty:http://localhost:8089/TestProject/customers")
		.process(new DNSIPHeaderProcessor())
		.to(DNSType.getIp()).process(new DNSIPProcessor());
	}

}
