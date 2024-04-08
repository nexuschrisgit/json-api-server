package com.test.api.internal.jsonapi.server.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.test.api.internal.jsonapi.server.dao.DomainRepository;
import com.test.api.internal.jsonapi.server.dao.WhoIsRepository;
import com.test.api.internal.jsonapi.server.model.DomainModel;
import com.test.api.internal.jsonapi.server.model.WhoIsModel;

import java.util.Date;

import javax.annotation.PostConstruct;

@Configuration
public class DataLoader {

	@Autowired
	private DomainRepository domainRepository;
	@Autowired
	private WhoIsRepository whoisRepository;

	@PostConstruct
	public void init() {
		Date date = new Date();
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		c.add(java.util.Calendar.YEAR, 2);
		
		for (long i = 1; i <= 5; i++) {
			DomainModel domain = new DomainModel();
			domain.setId(i);
			domain.setDomainName("domain_" + i + ".com");
			domain.setType("M");
			domain.setThreadObjId(i);
			domain.setWhoIsId(i);
			domainRepository.save(domain);

			for (long j = 1; j <= 3; j++) {
				DomainModel subdomain = new DomainModel();
				subdomain.setId(5 + j);
				subdomain.setDomainName("domain_" + i + ".com");
				subdomain.setSubDomain("sub" + j);
				subdomain.setType("S");
				domainRepository.save(subdomain);
			}

			WhoIsModel whoIs = new WhoIsModel();
			whoIs.setId(i);
//			whoIs.setRegistrar("goDaddy Inc.");
//			whoIs.setDomainName("domain_" + i + ".com");
//			whoIs.setExpiryDt(c.getTime());
//			whoIs.setRegisteredDt(date);
//			whoIs.setNameServers("ns.domain1.com");
			whoisRepository.save(whoIs);
		}
	}
}
