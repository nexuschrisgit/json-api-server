package com.test.api.internal.jsonapi.server.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiLinksInformation;
import io.crnk.core.resource.annotations.JsonApiResource;
import io.crnk.core.resource.links.DefaultSelfLinksInformation;

@JsonApiResource(type = "whois")
public class WhoIsModel {
	@JsonApiId
	Long id;
	@JsonProperty
	String domainName;
	@JsonProperty
	String status;
	
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
	public String getDomainName() {
		return domainName;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
