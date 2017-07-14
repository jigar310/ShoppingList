package com.shoppinglist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppinglist.dao.ShoppingItemDao;
import com.shoppinglist.domain.ShoppingItem;

@Service
public class ShoppingItemService {
	@Autowired
	ShoppingItemDao shoppingItemDao;
	
	public ShoppingItem find(Long id){
		return shoppingItemDao.find(id);
	}
	
	public List<ShoppingItem> findAll(){
		return shoppingItemDao.findAll();
	}
	
	public ShoppingItem saveOrUpdate(ShoppingItem item){
		return shoppingItemDao.saveOrUpdate(item);
	}
	
	public void delete(Long id){
		shoppingItemDao.delete(id);
	}

}
