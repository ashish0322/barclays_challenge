package com.ashish.store.inventorymanagement;
import java.math.BigDecimal;
import java.util.Scanner;

import com.ashish.store.inventorymanagement.controller.StoreController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.ashish.store.inventorymanagement.util.InputValidator;

@SpringBootApplication(exclude = {WebMvcAutoConfiguration.class})
public class Application implements ApplicationRunner{

	@Autowired
	private StoreController storeController;

	@Autowired
	private StoreInitializr storeInitializr;

	@Autowired
	private InputValidator inputValidator;

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
		//Initilizing store using StoreInitializr class
		context.getBean(StoreInitializr.class).initilizeStore();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		storeInitializr.initilizeStore();
		Scanner input = new Scanner(System.in);
		System.out.println("Inventory Management");
		String key = input.nextLine();
//		System.out.println("Next Line");
		String userInput[] = key.split(" ");
		while(!input.equals("exit")){
			switch (userInput[0]) {
				case "create":
//					System.out.println("===CREATE ITEM===");
					if(inputValidator.validateInput(userInput)){
						storeController.addItems(userInput[1], new BigDecimal(userInput[2]), new BigDecimal(userInput[3]));
					}
					break;
				case "updateBuy":
//					System.out.println("===UPDATE BUY===");
					if(inputValidator.validateInput(userInput)){
						storeController.updateItemQuantity(userInput[1], Integer.parseInt(userInput[2]));
					}
					break;
				case "updateSell":
//					System.out.println("===UPDATE SELL===");
					if(inputValidator.validateInput(userInput)){
						storeController.updateSell(userInput[1], Integer.parseInt(userInput[2]));
					}
					break;
				case "delete":
//					System.out.println("===DELETE===");
					if(inputValidator.validateInput(userInput)){
						storeController.deleteItem(userInput[1]);
					}
					break;
				case "report":
//					System.out.println("===REPORT===");
					storeController.generateReport();
					break;
				case "updateSellPrice":
//					System.out.println("===Update Sell Price ===");
					if(inputValidator.validateInput(userInput)){
						storeController.updateSellingPrice(userInput[1], new BigDecimal(userInput[2]));
					}
					break;
			}
			key = input.nextLine();
//			System.out.println("Next Line");
			userInput = key.split(" ");
		}

		input.close();
		System.exit(200);
	}

}

