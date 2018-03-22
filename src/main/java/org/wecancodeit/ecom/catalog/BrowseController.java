package org.wecancodeit.ecom.catalog;

import java.util.Collection;
import java.util.Collections;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@Resource
	private CrudRepository<Product, Long> productRepo;
	
	@RequestMapping(path = "/products", method = RequestMethod.GET)
	public Iterable<Product> findProducts() {
		return productRepo.findAll();
	}

	@RequestMapping("/products/{id}")
	public Product findProduct(@PathVariable long id) {
		Product selectedProduct = productRepo.findOne(id);
		if (selectedProduct != null) {
			return selectedProduct;
		}
		throw new ProductNotFoundException();
		
		
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ProductNotFoundException extends RuntimeException {
		
	}
}
