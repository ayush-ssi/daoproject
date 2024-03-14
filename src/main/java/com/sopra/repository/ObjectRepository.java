package com.sopra.repository;

import java.util.List;

public interface ObjectRepository<Inventory> {
	
    Inventory getById(int id);
    List<Inventory> getAll();
    String delete(int id);
	

}
