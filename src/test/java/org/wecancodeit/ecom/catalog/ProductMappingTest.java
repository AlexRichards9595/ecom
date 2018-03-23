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
	private TestEntityManager entityManager;

	@Test
	public void shouldSaveCartToCartItemRelationship() {
		Cart cart = new Cart("go");
		cart = cartRepo.save(cart);
		long cartId = cart.getId();

		CartItem dillPickles = cartItemRepo.save(new CartItem("Dill Pickles", cart));
		CartItem handBags = cartItemRepo.save(new CartItem("Gucci", cart));

		entityManager.flush();
		entityManager.clear();

		cart = cartRepo.findOne(cartId);
		assertThat(cart.getCartItems(), containsInAnyOrder(dillPickles, handBags));
	}

	@Test
	public void shouldAddItemToCart() {
		Cart cart = cartRepo.save(new Cart("go"));
		CartItem dillPickles = cartItemRepo.save(new CartItem("Dill Pickles", cart));
		CartItem handBags = cartItemRepo.save(new CartItem("Gucci", cart));

		cart.addItem(handBags);
		cart.addItem(dillPickles);

		assertThat(cart.getCartItems(), containsInAnyOrder(dillPickles, handBags));
	}

	@Test
	public void shouldClearCart() {
		Cart cart = cartRepo.save(new Cart("go"));
		CartItem dillPickles = cartItemRepo.save(new CartItem("Dill Pickles", cart));
		CartItem handBags = cartItemRepo.save(new CartItem("Gucci", cart));

		cart.addItem(handBags);
		cart.addItem(dillPickles);

		cart.clearCart();

		assertThat(cart.getCartItems(), not(contains(handBags)));
		assertThat(cart.getCartItems(), not(contains(dillPickles)));
		assertThat(cartItemRepo.findAll(), not(contains(dillPickles)));
	}

	@Test
	public void shouldRemoveItemFromCart() {
		Cart cart = cartRepo.save(new Cart("go"));
		CartItem dillPickles = cartItemRepo.save(new CartItem("Dill Pickles", cart));
		CartItem handBags = cartItemRepo.save(new CartItem("Gucci", cart));

		long cartId = cart.getId();

		cart.removeItem(dillPickles);

		entityManager.flush();
		entityManager.clear();

		cart = cartRepo.findOne(cartId);

		assertThat(cart.getCartItems(), contains(handBags));
		assertThat(cartItemRepo.findAll(), not(contains(dillPickles)));
	}

}
