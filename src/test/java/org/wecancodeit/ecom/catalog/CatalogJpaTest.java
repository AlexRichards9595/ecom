package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.ecom.catalog.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CatalogJpaTest {

	@Resource
	private CrudRepository<Product, Long> productRepo;
	
	@Test
	public void shouldInitializeProductRepository() {}
	
	@Test
	public void shouldAssignIdWhenProductIsCreated () {
		Product product = new Product("my new product");
		
		product = productRepo.save(product);
		
		assertThat(product.getId(), is(greaterThan(0L)));
	}
	
	
}
