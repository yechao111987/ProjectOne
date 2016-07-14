package com.yechao.dao.imp;

import java.util.List;

import com.yechao.dao.Critalfactor;
import com.yechao.dao.CustomerDao;
import com.yechao.dao.Dao;
import com.yechao.module.Customer;

public class CustomerDaoJDBCImpl extends Dao<Customer> implements CustomerDao{

	@Override
	public List<Customer> getAll() {
		String mysql = "select id,name,address,phone from customers";
		return getForList(mysql);
	}

	@Override
	public List<Customer> getSearch(Critalfactor cc) {
		String mysql="select id,name,address,phone from customers where name like ? and address like ? "
				+ "and phone like ?";
		return getForList(mysql, cc.getNameString(),
				cc.getAddressString(),cc.getPhoneString());

	}

	@Override
	public void Save(Customer customer) {
		String mysql = "insert into customers(name,address,phone) values (?,?,?)";
		update(mysql, customer.getName(), customer.getAddress(),
				customer.getPhone());
	}


	@Override
	public void delete(Integer id) {
		String mysql = "delete from customers where id=?";
		update(mysql, id);		
	}

	@Override
	public Customer get(Integer id) {
		String mysql = "select id,name,address,phone from customers where id=?";
		return get(mysql, id);
	}

	@Override
	public void updateById(Integer id, Critalfactor cc) {
		String mysql="update customers set name=? , address=? , phone=? "
				+ "where id=?";
		update(mysql, cc.getNameString1(),cc.getAddressString1(),cc.getPhoneString1(),id);		
	}

	@Override
	public long getCountByName(String name) {
		String mysql = "select count(id) from customers where name=?";
		return getForvale(mysql, name);
	}

}
