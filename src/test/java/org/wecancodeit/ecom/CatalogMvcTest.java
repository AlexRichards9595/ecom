package org.wecancodeit.ecom;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest 
public class CatalogMvcTest {
	
	@Resource 
	private MockMvc mvc;
	
	@Test
	public void shouldRetreiveProducts () throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/products")).andExpect(status().isOk());
		
	}
	
}
