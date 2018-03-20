package org.wecancodeit.ecom;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Product {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private Product() {}

	public Product(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}