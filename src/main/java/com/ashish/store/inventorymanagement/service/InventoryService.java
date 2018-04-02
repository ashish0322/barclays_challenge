/**
 * 
 */
package com.ashish.store.inventorymanagement.service;

import java.math.BigDecimal;

import com.ashish.store.inventorymanagement.domain.Store;


/**
 * @author Ashish Maheedhara
 *
 */
public interface InventoryService {
	
	public String addItem(String item_name, BigDecimal costPrice, BigDecimal sellingPrice);
	
	public String deleteItem(String item_name);
	
	public String updateItemQuantity(String item_name, int quantity);
	
	public String sellItem(String item_name, int quantity);
	
	public void generateReport();
	
	public Store getStoreInventory();

	public void updateSellingPrice(String item_name, BigDecimal sellingPrice);

}
