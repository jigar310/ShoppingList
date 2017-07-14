package com.shoppinglist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppinglist.domain.ShoppingItem;


@Repository
public class ShoppingItemDao {

	@PersistenceContext
	private EntityManager manager;

	public ShoppingItem find(Long id) {
		return manager.find(ShoppingItem.class, id);
	}

	public List<ShoppingItem> findAll() {
		return manager.createQuery("Select item from ShoppingItem item").getResultList();
	}

	@Transactional
	public ShoppingItem saveOrUpdate(ShoppingItem item) {
		return manager.merge(item);
	}
	
	@Transactional
	public void delete(Long id) {
		ShoppingItem item = this.find(id);
		 manager.remove(item);
	}

}
