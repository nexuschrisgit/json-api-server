package com.test.api.internal.jsonapi.server.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.test.api.internal.jsonapi.server.model.DomainModel;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

@Component
public class DomainRepository extends 
	ResourceRepositoryBase<DomainModel, Long>
	//InMemoryResourceRepository<DomainModel, Long> 
{
	private static final AtomicLong ID_GENERATOR = new AtomicLong(124);
	private Map<Long, DomainModel> domainRepo = new HashMap<>();
	
	public DomainRepository() {
		super(DomainModel.class);
	}

	@Override
	public ResourceList<DomainModel> findAll(QuerySpec querySpec) {
		return querySpec.apply(domainRepo.values());
	}

	@Override
	public synchronized <S extends DomainModel> S save(S domain) {
		if (domain.getId() == null) {
			domain.setId(ID_GENERATOR.getAndIncrement());
		}
		domainRepo.put(domain.getId(), domain);
		return domain;
	}
}
