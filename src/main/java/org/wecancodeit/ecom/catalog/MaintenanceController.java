package org.wecancodeit.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MaintenanceController {

	@Resource
	private CrudRepository<Inventory, Long> productRepo;
	
	
	
	@RequestMapping(path = "/products", method = RequestMethod.POST)
	public Inventory createProduct(Inventory incoming) {
		return productRepo.save(incoming);
		
	}
}
