package com.epsilon.training.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epsilon.training.dao.DaoException;
import com.epsilon.training.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller //qualifies for component scan // treated as special
public class ProductController {
	
	@Autowired
	private ProductDao dao;
	
	public ProductController() {
		System.out.println("Product controller instantiated");
	}
	@RequestMapping("/product-list")
	public String getAllProducts(Model model) throws DaoException {
//		log.debug("From inside pc method");
//		dao.findAll();
		model.addAttribute("products", dao.findAll());
		return "/show-products.jsp";
	}
	
	@RequestMapping("/products-by-brand")
	public String getProductsByBrand(@RequestParam("brand") String brand, Model model) throws DaoException {
		model.addAttribute("products", dao.findByBrand(brand));
		return "/show-products.jsp";
	}
	
	@RequestMapping("/products-by-category")
	public String getProductsByCategory(@RequestParam("category") String category, Model model) throws DaoException {
		model.addAttribute("products", dao.findByCategory(category));
		return "/show-products.jsp";
	}
	
	@RequestMapping("./product-details")
	public ModelAndView getProductById(@RequestParam int id) throws DaoException{
		return new ModelAndView("/product-details.jsp", "p", dao.findById(id));
	}
}
