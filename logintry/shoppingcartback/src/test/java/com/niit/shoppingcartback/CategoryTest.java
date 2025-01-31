package com.niit.shoppingcartback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.model.Category;
import com.niit.shopppingcartdao.CategoryDAO;

public class CategoryTest {
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category) context.getBean("category");
		
		// Create Operation
		category.setId("CG22");
		category.setName("CG22");
		category.setDescription("CG22");
	    categoryDAO.saveOrUpdate(category);
		
	    // categoryDAO.delete("CG01"); --> Delete Operation
		
	    //Retrieve Operation
	    if(categoryDAO.get("CG02")== null)
		{
			System.out.println("Category does not exist");
		}
		else
		{
			System.out.println("Category exists..");
			System.out.println();
		} 

	}

}
