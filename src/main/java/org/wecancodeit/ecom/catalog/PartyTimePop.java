package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PartyTimePop implements CommandLineRunner {

	@Resource
	private ProductRepository productRepo;

	@Resource
	private CartRepository cartRepo;

	@Override
	public void run(String... args) throws Exception {

		Product dillPickles = productRepo.save(new Product("Dill Pickles"));
		Product handBags = productRepo.save(new Product("Gucci"));

		Cart cart = new Cart("go");
		cart = cartRepo.save(cart);
	}

}
