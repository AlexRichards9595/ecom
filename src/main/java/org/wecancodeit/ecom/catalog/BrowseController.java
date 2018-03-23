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
	private ProductRepository productRepo;
	
	@Resource
	private  CartRepository cartRepo;
	
	@RequestMapping(path = "/carts", method = RequestMethod.GET)
	public Iterable<Cart> findCarts() {
		return cartRepo.findAll();
	}

	@RequestMapping("/carts/{id}")
	public Collection<Product> findCartProducts(@PathVariable long id) {
		Cart selectedCart = cartRepo.findOne(id);
		if (selectedCart != null) {
			return selectedCart.getProducts();
		}
		throw new ProductNotFoundException();
		
		
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ProductNotFoundException extends RuntimeException {
		
	}
}
