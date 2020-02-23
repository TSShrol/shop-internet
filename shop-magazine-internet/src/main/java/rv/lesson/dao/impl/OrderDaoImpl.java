package rv.lesson.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import rv.lesson.dao.OrderDao;
import rv.lesson.model.Order;
import rv.lesson.utils.ConnectionUtils;

public class OrderDaoImpl implements OrderDao {
	private static String READ_ALL = "select * from orders";
	private static String CREATE = "insert into orders(`user_id`, `delivery_address`,`created_date`) values (?,?,?)";
//	private static String UPDATE_BY_ID = "update orders set delivery_address=?  where id = ?";
	private static String READ_BY_ID = "select * from orders where id =?";
	private static String DELETE_BY_ID = "delete from orders where id=?";

	private static Logger logger = LogManager.getLogger(OrderDaoImpl.class);
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	public OrderDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Order create(Order order) {

		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, order.getUserId());
			preparedStatement.setString(2, order.getDeliveryAddress());
			preparedStatement.setDate(3,new Date(order.getCreateDate().getTime()));
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			order.setId(rs.getInt(1));
		} catch (SQLException e) {
			logger.error(e);
		}

		return order;
	}

	@Override
	public Order read(Integer id) {
		Order order = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
		
			Integer orderId = result.getInt("id");
			Integer userId = result.getInt("user_id");
			String deliveryAddress = result.getString("delivery_address");
			Date createDate = result.getDate("created_date");		
			order = new Order(orderId, userId, deliveryAddress, createDate);

		} catch (SQLException e) {
			logger.error(e);
		}

		return order;
	}

	@Override
	public Order update(Order t) {
		throw new IllegalStateException("there is no update for bucket");
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	@Override
	public List<Order> readAll() {
		
		List<Order> orderRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer orderId = result.getInt("id");
				Integer userId = result.getInt("user_id");
				String deliveryAddress = result.getString("delivery_address");
				Date createDate = result.getDate("created_date");
				orderRecords.add(new Order(orderId, userId, deliveryAddress, createDate));
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		
		return orderRecords;
	}

}
