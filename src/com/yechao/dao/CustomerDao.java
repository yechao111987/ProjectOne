package com.yechao.dao;

import java.util.List;
import com.yechao.module.Customer;

/**
 * @author Administrator
 *
 */
public interface CustomerDao {

	public List<Customer> getAll();
	
	public List<Customer> getSearch(Critalfactor cc);

	public void Save(Customer customer);

	public Customer getCustomer(Integer id);

	public void delete(Integer id);

	public Customer get(Integer id);
	
	public void updateById(Integer id,Critalfactor cc);

	/**
	 * 返回name对于的条数
	 * 
	 * @param name
	 * @return
	 */
	public long getCountByName(String name);

}
