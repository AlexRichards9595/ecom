package org.wecancodeit.ecom.catalog;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CartItem {


		@Id
		@GeneratedValue
		private long id;
		
		private String name;
		
		
		@ManyToMany(mappedBy = "products")
		private Collection<Cart> carts;
		
		public Collection<Cart> getCart() {
			return carts;
		}
		

		public long getId() {
			return id;
		}

		public String getName() {
			return name;
		}
		
		@SuppressWarnings("unused")
		private CartItem() {}
		
		
		public CartItem(String name, Product product, Cart cart) {
			this.name = name;
		}

		
		
		
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (id ^ (id >>> 32));
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CartItem other = (CartItem) obj;
			if (id != other.id)
				return false;
			return true;
		}


	

		
		
}
