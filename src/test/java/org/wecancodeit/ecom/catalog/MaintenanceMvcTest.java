package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import ch.qos.logback.core.status.Status;

@RunWith(SpringRunner.class)
@WebMvcTest(MaintenanceController.class)
public class MaintenanceMvcTest {

	@Resource
	private MockMvc mvc;
	
	@Resource
	private ObjectMapper jsonMapper;
	
	@MockBean
	private CrudRepository<Product, Long> productRepo;
	
	
	@Test
	public void shouldCreateProduct () throws Exception {
		Product product = new Product ("test product");
		String productJson = jsonMapper.writeValueAsString(product);
		mvc.perform(MockMvcRequestBuilders.post("/products").content(productJson)).andExpect(status().isOk());
	}
	
	@Test
	public void shouldAssignProductId () throws Exception {
		Product product = new Product ("test product");
		when(productRepo.save(any(Product.class))).thenReturn(new Product("foo"));
		String productJson = jsonMapper.writeValueAsString(product);
		
		MockHttpServletRequestBuilder request = post("/products").content(productJson);
		mvc.perform(request).andExpect(MockMvcResultMatchers.jsonPath("@.id", is(42L)));
	}
	
	
}
