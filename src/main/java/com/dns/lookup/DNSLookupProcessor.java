package com.dns.lookup;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.xbill.DNS.DClass;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

import com.dns.common.DNSConstant;

public class DNSLookupProcessor implements Processor{	
	@Override
	public void process(Exchange exchange) throws Exception {
		
        Object name = exchange.getIn().getHeader(DNSConstant.getDnsName());
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException("name is null or empty");
        }
        String dnsName = String.valueOf(name);
        Object type = exchange.getIn().getHeader(DNSConstant.getDnsType());
        Integer dnsType = null;
        if (type != null) {
        	dnsType = Type.value(String.valueOf(type));
        }
        Object dclass = exchange.getIn().getHeader(DNSConstant.getDnsClass());
        Integer dnsClass = null;
        if (dclass != null) {
        	dnsClass = DClass.value(String.valueOf(dclass));
        }

        Lookup lookup = null;
        if (dnsType != null && dnsClass != null) {
            lookup = new Lookup(dnsName, dnsType, dnsClass);
        } else if (dnsType != null) {
            lookup = new Lookup(dnsName, dnsType);
        } else {
            lookup = new Lookup(dnsName);
        }

        lookup.run();
        if (lookup.getAnswers() != null&&lookup.getAnswers().length>0) {
        	StringBuilder sb=new StringBuilder();
        	for(Record reco:lookup.getAnswers()) {
        		sb.append(reco);
        	}
        	
            exchange.getOut().setBody(sb);
        } else {
            exchange.getOut().setBody(lookup.getErrorString());
        }
    }
		

}
