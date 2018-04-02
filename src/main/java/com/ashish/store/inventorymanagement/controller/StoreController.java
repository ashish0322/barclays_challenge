/**
 * 
 */
package com.ashish.store.inventorymanagement.controller;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import com.ashish.store.inventorymanagement.service.InventoryService;
import org.springframework.stereotype.Component;

/**
 * @author Ashish Maheedhara
 *
 */
@Component
public class StoreController {

	/* Controller that handles the input requests from the user */

	@Autowired
	private InventoryService inventoryService;

	public StoreController(){}

	public void addItems(String item_name,BigDecimal cost_price, BigDecimal selling_price){
		String response = inventoryService.addItem(item_name,cost_price,selling_price);
//		System.out.println(response);
	}

	public void updateItemQuantity(String item_name,int item_quantity){
		String response =inventoryService.updateItemQuantity(item_name, item_quantity);
//		 System.out.println(response);
	}

	public void updateSell(String item_name,int sellQty){
		String response =inventoryService.sellItem(item_name, sellQty);
//		System.out.println(response);
	}

	public void deleteItem(String item_name){
		String response =inventoryService.deleteItem(item_name);
//		System.out.println(response);
	}

	public void generateReport(){
		inventoryService.generateReport();
	}

	public void updateSellingPrice(String item_name,BigDecimal selling_price){
		inventoryService.updateSellingPrice(item_name, selling_price);
	}
}
