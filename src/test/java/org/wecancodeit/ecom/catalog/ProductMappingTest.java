package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductMappingTest {

	@Resource
	private ProductRepository productRepo;
	@Resource
	private CartRepository cartRepo;

	@Test
	public void cartShouldHaveMultipleItems() {
		Product dillPickles = productRepo.save(new Product("Dill Pickles"));
		Product handBags = productRepo.save(new Product("Gucci"));

		Cart cart = new Cart("go", dillPickles, handBags);
		cartRepo.save(cart);

		assertThat(cart.getProducts(), containsInAnyOrder(dillPickles, handBags));
	}
}
