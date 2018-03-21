package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest 
public class CatalogMvcTest {
	
	@Resource 
	private MockMvc mvc;
	
	@MockBean
	private CrudRepository<Product, Long> productRepo;
	
	@Test
	public void shouldRetreiveProducts () throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/products")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRetrieveAnIndividualProduct() throws Exception {
		mvc.perform(get("/products/42")).andExpect(status().isOk());
		
		
	}
	
}
