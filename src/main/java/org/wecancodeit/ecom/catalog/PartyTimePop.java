package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PartyTimePop implements CommandLineRunner {

	@Resource
	private InventoryRepository productRepo;

	@Resource
	private CartRepository cartRepo;

	@Override
	public void run(String... args) throws Exception {

		Inventory dillPickles = productRepo.save(new Inventory("Dill Pickles"));
		Inventory handBags = productRepo.save(new Inventory("Gucci"));

		Cart cart = new Cart("go");
		cart = cartRepo.save(cart);
	}

}
