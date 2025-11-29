package com.predator.programs;   

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.predator.entities.Account;

import jakarta.persistence.Query;

public class AccountList {
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.addAnnotatedClass(Account.class).buildSessionFactory();
		Session ses=sf.getCurrentSession();
		ses.beginTransaction();
		
		Query q=ses.createQuery("from Account",Account.class);
		List<Account> list=q.getResultList();
		
		ses.close();
		System.out.println("Accounts data retrived..."+list.size());
		list.stream().forEach(obj->System.out.println(obj.getAccnm()));

	}

}
