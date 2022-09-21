package org.comit.project.service;
import java.util.List;
import org.comit.project.bean.ShoppingCart;
import org.comit.project.dao.ShoppingCartDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ShoppingCartDao shoppingCartDao;
	public List<ShoppingCart> listItems(long userId){
		return shoppingCartDao.listItems(userId);
	}

	public void remove(long shoppingcartId){
		shoppingCartDao.removeItem(shoppingcartId);
	}
	
	public void addItem(long artId, long userId, int quantity){
		shoppingCartDao.addItem(artId, userId, quantity);
	}
}