package com.controller.crudapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.productcrudapp.dao.ProductDAO;

@Controller
public class CrudController {
	@Autowired
	private ProductDAO productDao;

	@RequestMapping("/home")
	public String home(Model model) {
		List<Product> products = productDao.getAll();
		model.addAttribute("product", products);

		return "home";
	}

	// show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	
	// handle add product form
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, Model model, HttpServletRequest request) {
		// process the product data
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/home");
		model.addAttribute("Message", "Added Successfully" + product.getName());
		return redirectView;

	}

	// Handler to delete
	@RequestMapping("/delete/{productId}")
	public RedirectView DeleteProduct(@PathVariable("productId") Long productId, HttpServletRequest request) {
		this.productDao.deleteProductId(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/home");
		return redirectView;
	}
	//Handler to update
	@Transactional
	@RequestMapping("/update/{productId}")
	public String UpdateProduct(@PathVariable("productId") Long productId,Model model) {
		Product product = this.productDao.getProduct(productId);
		Hibernate.initialize(product.getId());
		Hibernate.initialize(product.getName());
		Hibernate.initialize(product.getAbout());
		Hibernate.initialize(product.getPrice());
		model.addAttribute("product", product);
		System.out.print(product);
		return "update_product_form";
	}
	




}