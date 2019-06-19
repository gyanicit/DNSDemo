package com.dns.lookup;
import org.apache.camel.builder.RouteBuilder;

import com.dns.common.DNSType;

public class DNSLookupRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jetty:http://localhost:8089/TestProject/customers")
		.process(new DNSLookupHeaderProcessor())
		.to(DNSType.getLookup()).process(new DNSLookupProcessor());
	}

}
