package com.yechao.dao.imp;

import java.util.List;
import com.yechao.dao.Critalfactor;
import com.yechao.dao.CustomerDao;
import com.yechao.module.Customer;

public class CustomerDaoXMLImp implements CustomerDao {

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		System.out.println("getAll");
		return null;
	}

	@Override
	public List<Customer> getSearch(Critalfactor cc) {
		// TODO Auto-generated method stub
		System.out.println("getSearch");

		return null;
	}

	@Override
	public void Save(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("getSearch");


	}

	@Override
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("getCustomer");

		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("delete");


	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("get");

		return null;
	}

	@Override
	public void updateById(Integer id, Critalfactor cc) {
		// TODO Auto-generated method stub
		System.out.println("updateById");


	}

	@Override
	public long getCountByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("getCountByName");

		return 0;
	}

}
