package com.test.api.internal.jsonapi.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiLinksInformation;
import io.crnk.core.resource.annotations.JsonApiResource;
import io.crnk.core.resource.links.DefaultSelfLinksInformation;

@JsonApiResource(type = "domain")
public class DomainModel {
	@JsonApiId
	Long id;
	@JsonProperty
	Long parentId;
	@JsonProperty
	String type;		
	@JsonProperty
	String subDomain;
	@JsonProperty
	String domainName;
	@JsonProperty
	Long whoIsId;
	@JsonProperty
	Long threadObjId;
	
	@JsonApiLinksInformation
	private DefaultSelfLinksInformation links = new DefaultSelfLinksInformation();

	public DefaultSelfLinksInformation getLinks() {
		return links;
	}

	public void setLinks(DefaultSelfLinksInformation links) {
		this.links = links;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long id) {
		this.parentId = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubDomain() {
		return subDomain;
	}
	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public Long getWhoIsId() {
		return whoIsId;
	}
	public void setWhoIsId(Long whoIsId) {
		this.whoIsId = whoIsId;
	}
	public Long getThreadObjId() {
		return threadObjId;
	}
	public void setThreadObjId(Long threadObjId) {
		this.threadObjId = threadObjId;
	}
}
