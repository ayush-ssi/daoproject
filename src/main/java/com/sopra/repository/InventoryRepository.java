package com.sopra.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sopra.DAOproject.App;
import com.sopra.footballgoods.Driver;
import com.sopra.footballgoods.Inventory;
@Repository
public class InventoryRepository implements ObjectRepository<Inventory>{
	


	@Override
	public Inventory getById(int id) {
		// TODO Auto-generated method stub
		Query<Inventory> q = Driver.s.createQuery("FROM Inventory where id =: x");
		
		q.setParameter("x", id);
		
		List<Inventory> lst = q.list();
		
		return lst.getFirst();
	}

	@Override
	public List<Inventory> getAll() {
		
		
			
		Query<Inventory> q = Driver.s.createQuery("FROM Inventory");
		
		List<Inventory> lst = q.list();
		
		return lst;
		
    
	}



	@Override
	public String delete(int id) {
		Query<Inventory> q = Driver.s.createQuery("DELETE from Inventory where id=x");
		
		q.setParameter("x", id);
		
		int rows = q.executeUpdate();
		
		if (rows > 0) {
			return "Successfully deleted";
		}
		return "Something went wrong";

		
	}
	
	

}
