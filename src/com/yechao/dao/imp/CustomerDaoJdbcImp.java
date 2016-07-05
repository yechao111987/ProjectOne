package com.yechao.dao.imp;

import java.util.List;

import com.yechao.dao.Critalfactor;
import com.yechao.dao.CustomerDao;
import com.yechao.dao.Dao;
import com.yechao.module.Customer;

public class CustomerDaoJdbcImp extends Dao<Customer> implements CustomerDao {

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		String mysql = "select id,name,address,phone from customers";
		return getForList(mysql);
	}

	@Override
	public void Save(Customer customer) {
		// TODO Auto-generated method stub
		String mysql = "insert into customers(name,address,phone) values (?,?,?)";
		update(mysql, customer.getName(), customer.getAddress(),
				customer.getPhone());

	}

	// 该方法用get替代了
	@Override
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String mysql = "delete from customers where id=?";
		update(mysql, id);

	}

	@Override
	public long getCountByName(String name) {
		// TODO Auto-generated method stub
		String mysql = "select count(id) from customers where name=?";

		return getForvale(mysql, name);
	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		// System.out.print(clazz);
		String mysql = "select id,name,address,phone from customers where id=?";

		return get(mysql, id);
	}

	@Override
	public List<Customer> getSearch(Critalfactor cc) {
		// TODO Auto-generated method stub
		String mysql="select id,name,address,phone from customers where name like ? and address like ? "
				+ "and phone like ?";
		return getForList(mysql, cc.getNameString(),cc.getAddressString(),cc.getPhoneString());
	}

	@Override
	public void updateById(Integer id,Critalfactor cc) {
		// TODO Auto-generated method stub
		String mysql="update customers set name=? , address=? , phone=? "
				+ "where id=?";
		update(mysql, cc.getNameString1(),cc.getAddressString1(),cc.getPhoneString1(),id);
		
	}

}
