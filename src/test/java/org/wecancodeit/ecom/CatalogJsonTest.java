package org.wecancodeit.ecom;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JsonTest
public class CatalogJsonTest {

	@Resource
	private JacksonTester<Product> productJson;
	
	@Test
	public void shouldSerialize() throws IOException {
		Product product = new Product("product name");
		
		JsonContent<Product> content = productJson.write(product);
		
		Assertions.assertThat(content).extractingJsonPathValue("@.name").isEqualTo("product name");
	}
	
	@Test
	public void shouldDeserialize() throws IOException {
		String expectedJson = "{ \"name\": \"product name\" }";
		
		Product parsed = productJson.parseObject(expectedJson);
		
		Assertions.assertThat(parsed.getName()).isEqualTo("product name");
	}
}
