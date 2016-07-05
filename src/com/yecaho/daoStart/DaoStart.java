package com.yecaho.daoStart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yechao.dao.Critalfactor;
import com.yechao.dao.CustomerDao;
import com.yechao.dao.imp.CustomerDaoJdbcImp;
import com.yechao.dao.imp.CustomerDaoXMLImp;
import com.yechao.module.Customer;

public class DaoStart {
	//一个hashmap对象daosMap，一个key对应一个value；key-value
	private Map<String, CustomerDao> daosMap=new HashMap<String,CustomerDao>();
	
	private DaoStart() {
		//构造函数，将DaoStart类构造，类中存储了两个daosMap的值
		daosMap.put("jdbc", new CustomerDaoJdbcImp());
		daosMap.put("xml", new CustomerDaoXMLImp());
	}
	
	//一个DaoStart类型的属性；instance
	private static DaoStart instance=new DaoStart();
	
	//获取对象本身，在写程序库代码时，有时有一个类需要被所有的其它类使用，但又要求这个类只能被实例化一次，是个服务类，
	//在写程序库代码时，有时有一个类需要被所有的其它类使用，但又要求这个类只能被实例化一次，是个服务类，定义一次，其它类使用同一个这个类的实例
	
	public static DaoStart getInstance() {
		return instance;
	}	
	
	private  String typeString=null;
	
	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	public String getTypeString() {
		return typeString;
	}
	
	public CustomerDao getCustomerDao(){
		return daosMap.get(typeString);
			
	}
	

}
