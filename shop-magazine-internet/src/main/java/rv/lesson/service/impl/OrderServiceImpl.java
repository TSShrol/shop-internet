package rv.lesson.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import rv.lesson.dao.OrderDao;
import rv.lesson.dao.impl.OrderDaoImpl;
import rv.lesson.model.Order;
import rv.lesson.service.OrderService;


public class OrderServiceImpl implements OrderService {
	private static Logger logger = LogManager.getLogger(OrderServiceImpl.class);
	private static OrderService orderServiceImpl;
	private OrderDao orderDao;
	
	private OrderServiceImpl() {
		try {
			orderDao = new OrderDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			logger.error(e);
		}
	}
	
	public static  OrderService getOrderService() {
		if(orderServiceImpl==null){
			orderServiceImpl=new OrderServiceImpl();
		}
		return orderServiceImpl;
	}
	
	@Override
	public Order create(Order t) {
		return orderDao.create(t);
	}
	@Override
	public Order read(Integer id) {
		
		return orderDao.read(id);
	}
	@Override
	public Order update(Order t) {
		// TODO Auto-generated method stub
		return orderDao.update(t);
	}
	@Override
	public void delete(Integer id) {
		orderDao.delete(id);
		
	}
	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return orderDao.readAll();
	}
	
		
}