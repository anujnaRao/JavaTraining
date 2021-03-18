package com.epsilon.training.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.epsilon.training.entity.Product;

@Repository("htDao") //qualifies for component-scan
@SuppressWarnings({"unchecked","deprecation"})
public class HibernateTemplateProductDao implements ProductDao {
	
	//dependency on 
	@Autowired
	private HibernateTemplate template;
	
	@Override
	public long count() {
		return Long.valueOf(template.find("select count(p) from Product p").get(0).toString());
	}

	@Override
	public void create(Product product) throws DaoException {
		template.persist(product);
	}

	@Override
	public Product findById(int id) throws DaoException {
		return template.get(Product.class, id);
	}

	@Override
	public void update(Product product) throws DaoException {
		
		template.merge(product);
	}

	@Override
	public void delete(int id) throws DaoException {
		Product p = this.findById(id);
		if(p == null) {
			throw new DaoException("No data found for id "+ id);
		}
		template.delete(p);
	}

	
	@Override
	public List<Product> findAll() throws DaoException {
//		String hql = "select p from com.epsilon.training.entity.Product";
//		String hql = "from com.epsilon.training.entity.Product";
//		String hql = "from products";
		return (List<Product>) template.find("from Product");
	}

	@Override
	public List<Product> findByPriceRange(double min, double max) throws DaoException {
		return (List<Product>) template.find("from Product where unitPrice between ?0 and ?1", min, max);
	}

	@Override
	public List<Product> findByBrand(String brand) throws DaoException {
		return (List<Product>) template.find("from Product where brand = ?0", brand);
	}

	@Override
	public List<Product> findByCategory(String category) throws DaoException {
		return (List<Product>) template.find("from Product where category = ?0", category);
	}

}
