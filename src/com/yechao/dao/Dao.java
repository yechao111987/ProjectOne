package com.yechao.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.yechao.utils.JdbcUtils;

/**
 * @author Administrator 封装了基本的CRUD的方法，以供子类调用 当前DAO方法直接获取数据库链接 整个DAO采取db
 *         utiles解决方案
 * @param T
 *            ：当前Dao处理的实体类的类型型是什么？
 */
public class Dao<T> {
	

	private QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	// 获取当前类的类名字
	public Dao() {
		// 1.Class<? super T> getSuperclass():返回本类的父类
		//2.Type getGenericSuperclass():返回本类的父类,包含泛型参数信息
		//http://blog.csdn.net/z69183787/article/details/37606309
		Type superclass = getClass().getGenericSuperclass();
		/*
		 * Java 中的instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例。instanceof通过返回一个布尔值来指出，这个对象是否是这个特定类或者是它的子类的一个实例。
 		*用法：result = object instanceof class
 		*参数：
 		*Result：布尔类型。
 		*Object：必选项。任意对象表达式。
 		*Class：必选项。任意已定义的对象类。
		 */
		if (superclass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) superclass;
			Type[] typeArgs = parameterizedType.getActualTypeArguments();
			if (typeArgs != null && typeArgs.length > 0) {
				if (typeArgs[0] instanceof Class) {
					clazz = (Class<T>) typeArgs[0];
				}
			}
		}
	}

	/**
	 * 返回某一个字段的的值，比如第一条记录的name的值，比如计算同一个名字的数量
	 * 
	 * @param mysql
	 * @param args
	 * @return
	 */
	public <E> E getForvale(String mysql, Object... args) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return (E) queryRunner.query(connection, mysql,
					new ScalarHandler(), args);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			JdbcUtils.releaseConnection(connection);

		}
		return null;
	}

	/**
	 * 返回T对应的list
	 * 
	 * @return
	 */
	public List<T> getForList(String mysql, Object... args) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, mysql, new BeanListHandler<>(
					clazz), args);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			JdbcUtils.releaseConnection(connection);

		}
		return null;
	}

	/**
	 * 返回对应的T的一个实例类的对象
	 * 
	 * @param mysql
	 * @param args
	 * @return
	 */
	public T get(String mysql, Object... args) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, mysql,
					new BeanHandler<>(clazz), args);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			JdbcUtils.releaseConnection(connection);

		}
		return null;
	};

	/**
	 * 该方法封装了insert,delete,update操作
	 * 
	 * @param mysql
	 *            ：SQL语句
	 * @param args
	 *            ：填充sql语句的占位符；
	 */
	public void update(String mysql, Object... args) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, mysql, args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtils.releaseConnection(connection);
		}

	};

}
