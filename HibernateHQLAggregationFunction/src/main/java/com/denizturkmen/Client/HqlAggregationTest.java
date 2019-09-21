package com.denizturkmen.Client;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.denizturkmen.Util.HibernateUtil;

public class HqlAggregationTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			String HqlAggregation = "SELECT COUNT(emp),AVG(emp.salary),MIN(emp.salary),MAX(emp.salary),SUM(emp.salary) FROM Employee emp";

			// Query atacaz aöa birden çok alan dönecekse object[] döndür

			Query<Object[]> query = session.createQuery(HqlAggregation);
			List<Object[]> list = query.list();

			for (Object[] objects : list) {
				Long employeeCount = (Long) objects[0];
				Double avgSalary = (Double) objects[1];
				Double minSalary = (Double) objects[2];
				Double maxSalary = (Double) objects[3];
				Double sumOfSalary = (Double) objects[4];
				
				System.out.println("Toplam Employee is "+employeeCount);
				System.out.println("Toplam Maas Ortalama : "+avgSalary);
				System.out.println("En az Maaş : "+minSalary);
				System.out.println("En Fazla Maas :"+maxSalary);
				System.out.println("Toplam Maas : "+sumOfSalary);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
