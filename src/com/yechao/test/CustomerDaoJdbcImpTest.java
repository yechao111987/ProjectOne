package com.yechao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.yecaho.daoStart.DaoStart;
import com.yechao.dao.Critalfactor;
import com.yechao.dao.CustomerDao;
import com.yechao.dao.imp.CustomerDaoJdbcImp;
import com.yechao.module.Customer;

public class CustomerDaoJdbcImpTest {
	//private CustomerDao customerDao = new CustomerDaoJdbcImp();
	private CustomerDao customerDao;
	@Before
	public void setUp() throws Exception {
		customerDao = DaoStart.getInstance().getCustomerDao();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAll() {
		// String mysql="select id,name,address,phone from customers";
		List<Customer> customers = customerDao.getAll();
		System.out.print(customers);
		// fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		// fail("Not yet implemented");
		Customer customer = new Customer();
		customer.setName("yechaoTest");
		customer.setAddress("zhejiang");
		customer.setPhone("17098070309");
		customerDao.Save(customer);
	}

	@Test
	@Ignore
	public void testGetCustomer() {
		Customer customer = new Customer();
		customer = customerDao.getCustomer(5);
		System.out.print(customer);
		// fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		customerDao.delete(1);
		// fail("Not yet implemented");
	}

	@Test
	public void testGetCountByName() {
		String name = "yechao";
		// long long1[]={0,1,2};
		// String name[]={"XXX","yechao"};
		long count = customerDao.getCountByName(name);
		System.out.println(count);
		assertEquals(1, count);
		// fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		// fail("Not yet implemented");
		Customer cust = customerDao.get(2);
		System.out.print(cust);
	}
	@Test
	public void testGetSearch() {
		// fail("Not yet implemented");
		Critalfactor cc= new Critalfactor("%%", "%%", "%%");
		List<Customer> customers=customerDao.getSearch(cc);
		for (Customer customer : customers) {
			System.out.println(customer.toString());
		}
	}

}
