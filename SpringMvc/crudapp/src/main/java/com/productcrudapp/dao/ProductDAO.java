package com.productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.controller.crudapp.Product;

@Component
public class ProductDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	// Create
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}

	
	// Get product
	@Transactional
	public List<Product> getAll() {
		return hibernateTemplate.loadAll(Product.class);

	}

	// delete the product by id
	@Transactional
	public void deleteProductId(Long id) {
		Product product = this.hibernateTemplate.load(Product.class, id);
		this.hibernateTemplate.delete(product);
	}

	@Transactional
	// get single product by id
	public Product getProduct(Long id) {
		return this.hibernateTemplate.load(Product.class, id);

	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}