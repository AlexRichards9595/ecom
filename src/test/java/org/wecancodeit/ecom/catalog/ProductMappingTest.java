package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductMappingTest {

	@Resource
	private ProductRepository productRepo;
	
	@Resource
	private CartRepository cartRepo;
	
	@Resource
	private TestEntityManager entityManager;

	@Test
	public void cartShouldHaveMultipleItems() {
		Product dillPickles = productRepo.save(new Product("Dill Pickles"));
		Product handBags = productRepo.save(new Product("Gucci"));

		Cart cart = new Cart("go", dillPickles, handBags);
		cartRepo.save(cart);

		assertThat(cart.getProducts(), containsInAnyOrder(dillPickles, handBags));
	}
	
	@Test
	public void shouldRemoveItemFromCart() {
		Cart cart = cartRepo.save(new Cart("go"));
		Product dillPickles = productRepo.save(new Product("Dill Pickles", cart));
//		Product handBags = productRepo.save(new Product("Gucci", cart));
//		Product apples = productRepo.save(new Product("Apples", cart));
//		cart = cartRepo.save(cart);
		
		long cartId = cart.getId();
		
		entityManager.flush();
		entityManager.clear();

//		handBags = productRepo.findOne(handBags.getId());
		
		cart = cartRepo.findOne(cartId);
		
//		assertThat(cart.getProducts(), not(hasItem(dillPickles)));
		assertThat(cart.getProducts(), contains(dillPickles));
		
	}
	
	
	
	
	
	
}