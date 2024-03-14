package com.sopra.footballgoods;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sopra.repository.InventoryRepository;


public class Driver {
	
	public static SessionFactory sf;
	
	public static Session s;
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure();
		sf=cfg.buildSessionFactory();
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		 ac.scan("com.sopra.repository");
		 ac.refresh();
		 
		
//		Inventory prod1=new Inventory();
//		prod1.setProduct_id(1);
//		prod1.setProduct_name("Studs");
//		prod1.setProduct_price(5000);
//		prod1.setProduct_quantity(50);
//		
//		
//		Inventory prod2=new Inventory();
//		prod2.setProduct_id(2);
//		prod2.setProduct_name("Football");
//		prod2.setProduct_price(2000);
//		prod2.setProduct_quantity(10);
//		
//		Inventory prod3=new Inventory();
//		prod3.setProduct_id(3);
//		prod3.setProduct_name("Jersey");
//		prod3.setProduct_price(1500);
//		prod3.setProduct_quantity(50);
//		
//		Inventory prod4=new Inventory();
//		prod4.setProduct_id(4);
//		prod4.setProduct_name("ShinGuard");
//		prod4.setProduct_price(500);
//		prod4.setProduct_quantity(50);
		
		s=sf.openSession();
		Transaction ts=s.beginTransaction();
		InventoryRepository i=ac.getBean(InventoryRepository.class);
		i.getById(1);
		i.delete(2);
		List<Inventory> lst=i.getAll();
		for(Inventory i1:lst)
		{
			System.out.println(i1);
		}
//		s.save(prod1);
//		s.save(prod2);
//		s.save(prod3);
//		s.save(prod4);
		ts.commit();
		
		
        
		
		
        
		
		
		
		
		
	}

}
