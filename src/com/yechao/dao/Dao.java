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
 * @author Administrator ��װ�˻�����CRUD�ķ������Թ�������� ��ǰDAO����ֱ�ӻ�ȡ���ݿ����� ����DAO��ȡdb
 *         utiles�������
 * @param T
 *            ����ǰDao�����ʵ�������������ʲô��
 */
public class Dao<T> {
	

	private QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	// ��ȡ��ǰ���������
	public Dao() {
		// 1.Class<? super T> getSuperclass():���ر���ĸ���
		//2.Type getGenericSuperclass():���ر���ĸ���,�������Ͳ�����Ϣ
		//http://blog.csdn.net/z69183787/article/details/37606309
		Type superclass = getClass().getGenericSuperclass();
		/*
		 * Java �е�instanceof �����������������ʱָ�������Ƿ����ض����һ��ʵ����instanceofͨ������һ������ֵ��ָ������������Ƿ�������ض�����������������һ��ʵ����
 		*�÷���result = object instanceof class
 		*������
 		*Result���������͡�
 		*Object����ѡ����������ʽ��
 		*Class����ѡ������Ѷ���Ķ����ࡣ
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
	 * ����ĳһ���ֶεĵ�ֵ�������һ����¼��name��ֵ���������ͬһ�����ֵ�����
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
	 * ����T��Ӧ��list
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
	 * ���ض�Ӧ��T��һ��ʵ����Ķ���
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
	 * �÷�����װ��insert,delete,update����
	 * 
	 * @param mysql
	 *            ��SQL���
	 * @param args
	 *            �����sql����ռλ����
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
