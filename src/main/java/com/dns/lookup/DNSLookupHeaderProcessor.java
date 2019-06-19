package com.dns.lookup;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.dns.common.DNSConstant;

public class DNSLookupHeaderProcessor implements Processor{
	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setHeader(DNSConstant.getDnsName(), "www.icitinstitute.in");
		//exchange.getIn().setHeader(DNSConstant.getDnsDomain(), "173.208.194.154");
		//exchange.getIn().setHeader(DNSConstant.getDnsServer(), "173.208.194.154");
		exchange.getIn().setHeader(DNSConstant.getDnsType(), "TXT");//Possible Value--> A,TXT,CNAME etc
		exchange.getIn().setHeader(DNSConstant.getDnsClass(), "IN");
	}

}
