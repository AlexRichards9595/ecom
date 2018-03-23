package org.wecancodeit.ecom;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.ecom.catalog.Inventory;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContainerRestTest {

	@Resource
	private TestRestTemplate restTemplate;
	
	@Resource
	private ObjectMapper jsonMapper;
	
	@Test
	public void shouldGetProducts() {
		ResponseEntity<String> response = restTemplate.getForEntity("/products", String.class);
		
		HttpStatus status = response.getStatusCode();
		
		assertThat(status, is(HttpStatus.OK));
	}
	
	@Test
	public void shouldCreateProduct() {
		Inventory product = new Inventory("my new product");
		
		ResponseEntity<Inventory> response = restTemplate.postForEntity("/products", product, Inventory.class);
		Inventory created = response.getBody();
		
		assertThat(created.getId(), is(greaterThan(0L)));
	}
	
}
 