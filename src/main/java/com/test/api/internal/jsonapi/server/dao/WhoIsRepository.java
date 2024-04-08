package com.test.api.internal.jsonapi.server.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.test.api.internal.jsonapi.server.model.WhoIsModel;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

@Component
public class WhoIsRepository extends 
	ResourceRepositoryBase<WhoIsModel, Long>
	//InMemoryResourceRepository<WhoIsModel, Long> 
{
	private static final AtomicLong ID_GENERATOR = new AtomicLong(124);
	private Map<Long, WhoIsModel> whoisRepo = new HashMap<>();
	
	public WhoIsRepository() {
		super(WhoIsModel.class);
	}

	@Override
	public ResourceList<WhoIsModel> findAll(QuerySpec querySpec) {
		return querySpec.apply(whoisRepo.values());
	}

	@Override
	public synchronized <S extends WhoIsModel> S save(S project) {
		if (project.getId() == null) {
			project.setId(ID_GENERATOR.getAndIncrement());
		}
		whoisRepo.put(project.getId(), project);
		return project;
	}
}
