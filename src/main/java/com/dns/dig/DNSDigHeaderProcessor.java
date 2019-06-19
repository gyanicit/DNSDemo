package com.dns.dig;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.dns.common.DNSConstant;

public class DNSDigHeaderProcessor implements Processor{
	@Override
	public void process(Exchange exchange) throws Exception {
		
		DNSDigDTO digDTO=(DNSDigDTO)exchange.getIn().getBody();
		
		//exchange.getIn().setHeader(DNSConstant.getDnsDomain(), digDTO.getIpAddress());
		//exchange.getIn().setHeader(DNSConstant.getDnsName(), digDTO.getName());
		
		//exchange.getIn().setHeader(DNSConstant.getDnsDomain(), "10.197.12.12");
//		exchange.getIn().setHeader(DNSConstant.getDnsDomain(), "10.198.8.43");
//		exchange.getIn().setHeader(DNSConstant.getDnsName(), "ORSXG5DDNFZTKOBUGYZUA3LUNYXGG33NFZXGO===.b32.nai.sub.cs");
		//exchange.getIn().setHeader(DNSConstant.getDnsName(), "testcis58463@mtn.com.ng");
		
		//exchange.getIn().setHeader(DNSConstant.getDnsType(), digDTO.getDnsType());//Can be A,TXT
		//exchange.getIn().setHeader(DNSConstant.getDnsServer(), "hostamity.com");
		//exchange.getIn().setHeader("dns.class", digDTO.getClassName());		
	}

}
