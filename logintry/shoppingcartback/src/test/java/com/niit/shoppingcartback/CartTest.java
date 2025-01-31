package com.niit.shoppingcartback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.model.Cart;
import com.niit.shopppingcartdao.CartDAO;

public class CartTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext();
		
		con.scan("com.niit");
		con.refresh();
		
		CartDAO cartDAO =  (CartDAO) con.getBean("cartDAO");
		
		Cart cart= (Cart) con.getBean("cart");
		cart.setId("CART01");
		cart.setPrice(100);
		cart.setQuantity(2);
		cart.setTotal(200);
		cart.setUserId("US01");
		cart.setProductName("PRDCT");
		cart.setStatus("AVAILABLE");
		
		cartDAO.saveOrUpdate(cart);
		
		System.out.println("updated");
	}

}
