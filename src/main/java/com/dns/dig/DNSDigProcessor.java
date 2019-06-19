package com.dns.dig;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.xbill.DNS.DClass;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.Section;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.Type;

import com.dns.common.DNSConstant;

public class DNSDigProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		String server = null;
        if (exchange.getIn().getHeader(DNSConstant.getDnsServer()) != null) {
            server = String.valueOf(exchange.getIn().getHeader(DNSConstant.getDnsServer()));
        }
        SimpleResolver resolver = new SimpleResolver(server);
        int type = Type.value(String.valueOf(exchange.getIn().getHeader(DNSConstant.getDnsType())));
        if (type == -1) {
            // If not able to parse then value will be used A by default.
            type = Type.A;
        }
        int dclass = DClass.value(String.valueOf(exchange.getIn().getHeader(DNSConstant.getDnsClass())));
        if (dclass == -1) {
            // default value is IN.
            dclass = DClass.IN;
        }
        Name name = Name.fromString(String.valueOf(exchange.getIn().getHeader(DNSConstant.getDnsName())),Name.root);
        Record rec = Record.newRecord(name, type, dclass);
        Message query = Message.newQuery(rec);
        Message response = resolver.send(query);
        exchange.getOut().setBody(response);
        Record[] answers=response.getSectionArray(Section.UPDATE);
        for(Record ans:answers) {
        	System.out.println("------------ans--->"+ans);
        }
        System.out.println("------------resp--->"+response);
	}

}
