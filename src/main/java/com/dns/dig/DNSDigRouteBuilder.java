package com.dns.dig;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.Builder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.dns.DnsComponent;

import com.dns.common.DNSConstant;
import com.dns.common.DNSType;

public class DNSDigRouteBuilder extends RouteBuilder {

	private CamelContext context;
	
	public void setContext(CamelContext context) {
		this.context=context;
	}
	
	@Override
	public void configure() throws Exception {
		
		DnsComponent dnsComponent=context.getComponent("dns", DnsComponent.class);
		//from("jetty:http://localhost:8089/TestProject/customers")
		from("direct:start")
		.setProperty("value",Builder.constant(123))
		//.process(new DNSDigHeaderProcessor())
		.setHeader(DNSConstant.getDnsDomain(), Builder.constant("173.208.194.154"))
		.setHeader(DNSConstant.getDnsName(), Builder.constant("ns11.hostamity.com"))
		.setHeader(DNSConstant.getDnsType(), Builder.constant("CNAME"))
		.setHeader("dns.class", Builder.constant("IN"))
		
		.to(DNSType.getDig())
		.process(new DNSDigProcessor());
	}

}
