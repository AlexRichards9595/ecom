package org.wecancodeit.ecom;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FooDemo implements CommandLineRunner{

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	private Foo injectedFoo;
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
