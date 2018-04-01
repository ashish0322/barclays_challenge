# barclays_challenge
Problem 3 Inventory Management 1

# Development
The project is developed using 
  Spring Boot
  Java8
  Hibernate
  InMemory H2 Database 
  using Eclipse as IDE

# Build the Jar
Project Jar can be built using Maven Build in Eclipse or IntelliJ 

# Running the Jar
The java jar can be run from console using the below command

java -jar <project-filename>.jar

Sample Input
```
create Book01 10.50 13.79
create Food01 1.47 3.98
create Med01 30.63 34.29
create Tab01 57.00 84.98
updateBuy Tab01 100
updateSell Tab01 2
updateBuy Food01 500
updateBuy Book01 100
updateBuy Med01 100
updateSell Food01 1
updateSell Food01 1
updateSell Tab01 2
report
#

```
Expected Output
```
              	INVENTORY REPORT
Item Name 	Bought At    	Sold At       	AvailableQty    	Value
--------- 	---------    	-------       	-----------     	-------
Book01    	10.50          	13.79               	100    	1050.00
Food01     	1.47           	3.98               	498     	732.06
Med01     	30.63          	34.29               	100    	3063.00
Tab01     	57.00          	84.98                	96    	5472.00
---------------------------------------------------------------------------
Total value                                                     	10317.06
Profit since previous report                                      	116.94
```

# Design 
Followed MVC desin pattern and SOA 

# Model
Store and Items are the Business Objects
Used Hibernate for mapping between entities

# Controller
StoreController will handle all the operations performed from console

# Service
InventoryService contains the business logic for handling the necessary operations

# Repository
Handled the database transactions inside StoreRepository

# Validation 
Validated user input for null and non string values for number input using InputValidator class



