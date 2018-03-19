package org.wecancodeit.ecom.catalog;

import java.util.Collection;
import java.util.Collections;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.ecom.products.Product;

@RestController
public class BrowseController {

	@RequestMapping("/products")
	public Collection<Product> getProducts() {
		return Collections.singleton(new Product());
	}
}
