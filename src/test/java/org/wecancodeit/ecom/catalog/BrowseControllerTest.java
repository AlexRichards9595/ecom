package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.ecom.catalog.BrowseController;
import org.wecancodeit.ecom.catalog.BrowseController.ProductNotFoundException;

public class BrowseControllerTest {

	@InjectMocks
	private BrowseController underTest;
	
	@Mock
	private CrudRepository<Product, Long> productRepo;
	
	@Mock
	private Product product;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldFindProducts() {
		when(productRepo.findAll()).thenReturn(Collections.singleton(product));
		
		Iterable<Product> result = underTest.findProducts();
		
		assertThat(result, contains(any(Product.class)));
	}
	
	@Test
	public void shouldRetrieveAnIndividualProduct() {
		long id = 42L;
		when(productRepo.findOne(id)).thenReturn(product);
		Product result = underTest.findProduct(id);
		
		assertThat(result, is(product));
	}
	
	@Test (expected = ProductNotFoundException.class)
	public void shouldReturnNotFoundForBadProductId() {
		underTest.findProduct(42L);
	}
	
	@Test
	public void shouldRetrieveProductsFromDb() {
		when(productRepo.findAll()).thenReturn(Collections.singleton(product));

		Iterable<Product> result = underTest.findProducts();
		
		assertThat(result, contains(product));
	}
	
	
}
