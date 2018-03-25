package org.wecancodeit.ecom.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.repository.CrudRepository;

public class MaintenanceControllerTest {

	@InjectMocks
	private MaintenanceController underTest;
	
	@Mock
	private CrudRepository<Product, Long> productRepo;
	
	@Mock
	private Product incoming;
	
	@Mock 
	private Product persisted;
	
	@Test
	public void shouldCreateProduct() {
		MockitoAnnotations.initMocks(this);
		
		when(productRepo.save(incoming)).thenReturn(persisted);
		Product result = underTest.createProduct(incoming);
		
		assertThat(result, is(persisted));
	}
}
