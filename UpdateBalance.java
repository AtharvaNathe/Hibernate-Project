    package com.predator.programs;   

	import java.util.Scanner;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;

	import com.predator.entities.Account;

	import jakarta.persistence.Query;

	public class UpdateBalance {
		public static void main(String[] args) {
			Configuration cfg=new Configuration().configure();
			SessionFactory sf=cfg.addAnnotatedClass(Account.class).buildSessionFactory();
			Session ses=sf.getCurrentSession();
			ses.beginTransaction();
			
			int no;
			float bal;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Account number : ");
			no=sc.nextInt();
			System.out.println("Enter the Deposit Amount : ");
			bal=sc.nextFloat();
			
			Query q=ses.createQuery("update Account set balance=balance+:s where accno=:n ");
			q.setParameter("s", bal);
			q.setParameter("n", no);
			int cnt=q.executeUpdate();
			ses.getTransaction().commit();
			
			if(cnt>0)
				System.out.println("Balance updated successfully...");
			else
				System.out.println("Failure in updating Balance...");
			
			ses.close();

		}

	}

