package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.util.Util;
import com.niit.shopppingcartdao.ProductDAO;

@Controller
public class ProductController {
	
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value = "/Products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("isAdminClickedProduct", "true");
		model.addAttribute("product", product);
		model.addAttribute("productList", this.productDAO.list());
		return "home";
	}

	@RequestMapping(value = "/to_add_product", method = RequestMethod.POST)
	public String addProducts(@ModelAttribute("product") Product product) {
		
		String newID=Util.removeComma(product.getId());
		product.setId(newID);
		
		productDAO.saveOrUpdate(product);

		return "redirect:/Products";
	}
	
	@RequestMapping(value = "product/remove/{id}")
	public String deleteProducts(@PathVariable("id") String id,ModelMap model) {
		try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/Products";
	}
	
	
	@RequestMapping(value = "product/edit/{id}")
	public String editProducts(@PathVariable("id") String id,ModelMap model) {
		product=productDAO.get(id);
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());

		return "redirect:/Products";
	}


	
	
	

}
