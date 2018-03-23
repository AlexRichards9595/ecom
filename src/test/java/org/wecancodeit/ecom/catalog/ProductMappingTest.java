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
	
//	@Test
//	public void shouldRemoveItemFromCart() {
//		Inventory dillPickles = inventoryRepo.save(new Inventory("Dill Pickles"));
//		Inventory handBags = inventoryRepo.save(new Inventory("Gucci"));
//		
//		Cart cart = cartRepo.save(new Cart("go"));
//		cart.removeItem(dillPickles);
//		
//		entityManager.flush();
//		entityManager.clear();
//		
//		assertThat(cart.getCartItems(), not(hasItem(dillPickles)));
//		assertThat(cart.getCartItems(), contains(handBags));
//	}
	
//	@Test
//	public void shouldAddItemToCart() {
//		Inventory dillPickles = inventoryRepo.save(new Inventory("Dill Pickles"));
//		Inventory handBags = inventoryRepo.save(new Inventory("Gucci"));
//		
//		Cart cart = cartRepo.save(new Cart("go"));
//		
//		cart.addItem(handBags);
//		
//		assertThat(cart.getCartItems(), containsInAnyOrder(dillPickles, handBags));
//		
//	}
//	
//	@Test
//	public void shouldClearCart() {
//		Inventory dillPickles = inventoryRepo.save(new Inventory("Dill Pickles"));
//		Inventory handBags = inventoryRepo.save(new Inventory("Gucci"));
//		
//		Cart cart = cartRepo.save(new Cart("go"));
//		cart.clearCart();
//		
//		assertThat(cart.getCartItems(), not(containsInAnyOrder(dillPickles, handBags)));
//	}
	
	
	
	
	
	
}
