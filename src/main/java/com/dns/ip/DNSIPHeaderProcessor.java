package com.dns.ip;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.dns.common.DNSConstant;

public class DNSIPHeaderProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setHeader(DNSConstant.getDnsDomain(), "www.hostamity.com");
	}

}
