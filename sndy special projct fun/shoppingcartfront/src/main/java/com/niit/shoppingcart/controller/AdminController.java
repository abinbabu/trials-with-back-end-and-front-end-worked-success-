package com.niit.shoppingcart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shopppingcartdao.CategoryDAO;
import com.niit.shopppingcartdao.ProductDAO;
import com.niit.shopppingcartdao.SupplierDAO;

@Controller
public class AdminController {

	@Autowired
	private Category category;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Product product;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private SupplierDAO supplierDAO;

 	@RequestMapping(value="/manageCategories")
	public ModelAndView category() {

		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("category", category);
		mv.addObject("isAdminCLickedCategory", "true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}

	@RequestMapping("products")
	public ModelAndView product() {

		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("product", product);
		mv.addObject("isAdminClickedProduct", "true");
		mv.addObject("productList", productDAO.list());
		return mv;
	}

	@RequestMapping("/suppliers")
	public ModelAndView supplier() {

		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("supplier", supplier);
		mv.addObject("isAdminClickedSupplier", "True");
		mv.addObject("supplierList", supplierDAO.list());
		return mv;
	}


}
