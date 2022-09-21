package org.comit.project.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.comit.project.bean.Order;
import org.springframework.jdbc.core.RowMapper;


public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {

		Order order = new Order();

		order.setId(rs.getInt("Order_Id"));
		order.setOrderdate(rs.getDate("Order_Date"));
		
		return order ;
	}

}