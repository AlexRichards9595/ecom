package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
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
	private CartItemRepository cartItemRepo;

	@Resource
	private CartRepository cartRepo;
	
	@Resource
	private ProductRepository productRepo;

	@Resource
	private TestEntityManager entityManager;

	@Test
	public void shouldSaveCartToCartItemRelationship() {
		Cart cart = new Cart("go");
		cart = cartRepo.save(cart);
		long cartId = cart.getId();

		Product dillPickles = productRepo.save(new Product("Dill Pickles"));
		Product handBags = productRepo.save(new Product("Gucci"));
		CartItem dillPicklesItem = cartItemRepo.save(new CartItem(dillPickles, cart));
		CartItem handBagsItem = cartItemRepo.save(new CartItem(handBags, cart));
		
		entityManager.flush();
		entityManager.clear();

		cart = cartRepo.findOne(cartId);
		assertThat(cart.getCartItems(), containsInAnyOrder(dillPicklesItem, handBagsItem));
	}

	@Test
	public void shouldAddItemToCart() {
		Cart cart = cartRepo.save(new Cart("go"));
		Product dillPickles = productRepo.save(new Product("Dill Pickles"));
		Product handBags = productRepo.save(new Product("Gucci"));
		CartItem dillPicklesItem = cartItemRepo.save(new CartItem(dillPickles, cart));
		CartItem handBagsItem = cartItemRepo.save(new CartItem(handBags, cart));

		cart.addItem(handBagsItem);
		cart.addItem(dillPicklesItem);

		assertThat(cart.getCartItems(), containsInAnyOrder(dillPicklesItem, handBagsItem));
	}

	@Test
	public void shouldClearCart() {
		Cart cart = cartRepo.save(new Cart("go"));
		Product dillPickles = productRepo.save(new Product("Dill Pickles"));
		Product handBags = productRepo.save(new Product("Gucci"));
		CartItem dillPicklesItem = cartItemRepo.save(new CartItem(dillPickles, cart));
		CartItem handBagsItem = cartItemRepo.save(new CartItem(handBags, cart));

		cart.addItem(handBagsItem);
		cart.addItem(dillPicklesItem);

		cart.clearCart();

		assertThat(cart.getCartItems(), not(contains(handBags)));
		assertThat(cart.getCartItems(), not(contains(dillPickles)));
		assertThat(cartItemRepo.findAll(), not(contains(dillPickles)));
	}

	@Test
	public void shouldRemoveItemFromCart() {
		Cart cart = cartRepo.save(new Cart("go"));
		Product dillPickles = productRepo.save(new Product("Dill Pickles"));
		Product handBags = productRepo.save(new Product("Gucci"));
		CartItem dillPicklesItem = cartItemRepo.save(new CartItem(dillPickles, cart));
		CartItem handBagsItem = cartItemRepo.save(new CartItem(handBags, cart));

		long cartId = cart.getId();

		cart.removeItem(dillPicklesItem);

		entityManager.flush();
		entityManager.clear();

		cart = cartRepo.findOne(cartId);

		assertThat(cart.getCartItems(), contains(handBagsItem));
		assertThat(cartItemRepo.findAll(), not(contains(dillPicklesItem)));
	}

}
