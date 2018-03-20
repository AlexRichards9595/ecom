package org.wecancodeit.ecom;

import java.util.Collection;
import java.util.Collections;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@RequestMapping("/products")
	public Collection<Product> getProducts() {
		return Collections.singleton(new Product("arbitrary product name"));
	}

	@RequestMapping("/products/{id}")
	public Product getProduct(@PathVariable long id) {
		return new Product("arbitrary product name");
	}
}
