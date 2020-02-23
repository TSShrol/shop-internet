package rv.lesson.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import rv.lesson.dao.ProductDao;
import rv.lesson.dao.impl.ProductDaoImpl;
import rv.lesson.model.Product;
import rv.lesson.service.ProductService;


public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	private static Logger logger = LogManager.getLogger(ProductServiceImpl.class);
	private static ProductService productServiceImpl;
	private ProductServiceImpl() {
		try {
			productDao = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			logger.error(e);
		}

	}
	public static  ProductService getProductService() {
		if(productServiceImpl==null){
			productServiceImpl=new ProductServiceImpl();
		}
		return productServiceImpl;
	}

	@Override
	public Product create(Product t) {
		return productDao.create(t);
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public Product update(Product t) {
		return productDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

}
