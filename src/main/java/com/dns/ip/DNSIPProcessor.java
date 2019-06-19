package com.dns.ip;
import java.net.InetAddress;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.xbill.DNS.Address;

import com.dns.common.DNSConstant;

public class DNSIPProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		Object domain = exchange.getIn().getHeader(DNSConstant.getDnsDomain());
        if (!(domain instanceof String) || ((String) domain).length() == 0) {
            throw new IllegalArgumentException("Invalid or null domain :" + domain);
        }
        InetAddress address = Address.getByName((String) domain);
        //	exchange.getOut().setBody(domain.toString()+" IP: "+address);
		
	}

}
