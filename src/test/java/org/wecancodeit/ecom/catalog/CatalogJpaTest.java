package org.wecancodeit.ecom.catalog;

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
	
	
}
