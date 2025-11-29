package com.predator.programs;   

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.predator.entities.Account;

import jakarta.persistence.Query;

public class DeleteAccount {
	public static void main(String[] args) {
		int no;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Account number : ");
		no=sc.nextInt();
		
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.addAnnotatedClass(Account.class).buildSessionFactory();
		Session ses=sf.getCurrentSession();
		ses.beginTransaction();
		
		Query q=ses.createQuery("delete from Account where accno= :accno");
		q.setParameter("accno",no);
		int cnt=q.executeUpdate();
		System.out.println("Records Deleted "+cnt);
	}

}
