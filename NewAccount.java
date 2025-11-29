package com.predator.programs;  

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.predator.entities.Account;

public class NewAccount {
	public static void main(String[] args) {
		
		Account obj=new Account();
		obj.setAccno(1012);
		obj.setAccnm("Tony Stark");
		obj.setAcctype("Fixed");
		obj.setBalance(70000);
		
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.addAnnotatedClass(Account.class).buildSessionFactory();
		Session ses=sf.getCurrentSession();
		ses.beginTransaction();
		
		ses.persist(obj);
		ses.getTransaction().commit();
		System.out.println("New account created...");
	}

}
