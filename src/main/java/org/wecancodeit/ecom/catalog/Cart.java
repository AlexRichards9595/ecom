package org.wecancodeit.ecom.catalog;

import java.awt.List;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long id;
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "cart")
	private Collection<CartItem> cartItems = new HashSet<CartItem>();

	public Collection<CartItem> getCartItems() {
		return cartItems;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("unused")
	private Cart() {
	}

	public Cart(String name) {
		this.name = name;
	}

	public void addItem(CartItem cartItem) {
		cartItems.add(cartItem);
	}

//	public void removeItem(CartItem cartItem) {
//		cartItems.(cartItem);
//	}

	public void clearCart() {
		cartItems.clear();
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
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
