package org.comit.project.service;

import java.util.List;
import org.comit.project.bean.Order;
import org.comit.project.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class OrderService {

	@Autowired
	OrderDao orderDao;

	public List<Order> listOrders(){
		List<Order> orders = orderDao.listOrders();
		orders.forEach(System.out::println);
		return orders;
	}

	public Order findOrder(int idOrder) {
		return orderDao.findOrder(idOrder);
	}
	 public void deleteOrder(int idOrder) {
	    	orderDao.deleteOrder(idOrder);
	    }

	
}

