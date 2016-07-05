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
	//һ��hashmap����daosMap��һ��key��Ӧһ��value��key-value
	private Map<String, CustomerDao> daosMap=new HashMap<String,CustomerDao>();
	
	private DaoStart() {
		//���캯������DaoStart�๹�죬���д洢������daosMap��ֵ
		daosMap.put("jdbc", new CustomerDaoJdbcImp());
		daosMap.put("xml", new CustomerDaoXMLImp());
	}
	
	//һ��DaoStart���͵����ԣ�instance
	private static DaoStart instance=new DaoStart();
	
	//��ȡ��������д��������ʱ����ʱ��һ������Ҫ�����е�������ʹ�ã�����Ҫ�������ֻ�ܱ�ʵ����һ�Σ��Ǹ������࣬
	//��д��������ʱ����ʱ��һ������Ҫ�����е�������ʹ�ã�����Ҫ�������ֻ�ܱ�ʵ����һ�Σ��Ǹ������࣬����һ�Σ�������ʹ��ͬһ��������ʵ��
	
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
