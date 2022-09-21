package org.comit.project.service;

import java.util.List;
import org.comit.project.bean.Customer;
import org.comit.project.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public List<Customer> listCustomer(){

		List<Customer> customers = customerDao.listCustomer();
		customers.forEach(System.out::println);
		return customers;
	}

	public Customer findCustomer(int idCustomer) {
		return customerDao.findCustomer(idCustomer);
	}

	public void createCustomer(Customer customer) {

		this.createCustomer(customer);
		customer.setEmail("Email");
        customerDao.createCustomer(customer);
	}  
	public void modifyCustomer(Customer customer) {
    	this.modifyCustomer(customer);
    	customerDao.modifyCustomer(customer);
    }
    public void deleteCustomer(int idCustomer) {
    	customerDao.deleteCustomer(idCustomer);
    }
//
//    private void validateUser(User user) {
//    	if (user.getFirstName().isEmpty() ||
//    		user.getLastName().isEmpty() ||
//    		user.getUserName().isEmpty()) {
//    		throw new RuntimeException("Invalid User Data " + user);
//    	}
//    }
}

