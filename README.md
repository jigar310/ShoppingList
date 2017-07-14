# ShoppingList
This is a web application to make and modify the list for shopping. User can Add shopping item, mark it as purchased, modify it and delete it. 

## Technology stack
### Build Tool
	Gradle
### Application container
	Jetty
### Database
	HSQLDB
### Programming tools
	Java, Spring, Hibernate, CSS, Java Script

## Requirements

### Overview
The purpose of this exercise is to create a simple web based grocery list tool. This tool allows its user to
track a list of grocery items that they want to purchase.
### Technical Constraints
Please include application deployment instructions. The stack is limited to JavaScript, Java and/or .NET based
frameworks.
### Tools and Restrictions
Use the tools and libraries that you feel are appropriate. You may not copy code from other sources or obtain
assistance from another developer.
### Story Backlog
The following stories represent the requirements of the web application. They are in priority order. A minimum
of 2 stories must be completed. However, not all stories must be completed.

1. As a grocery shopper, I want to be able to add a grocery item on my grocery item list, so that I can track something that I need to purchase.
* Verify that there is a way to add an item to the list
* Verify that the grocery item has a title and optional notes
2. As a grocery shopper, I want to view the list of grocery items, so that I can see what I need to purchase.
* Verify that there is a way to list all the items on a screen
* Verify that the title is shown and not the optional notes
3. As a grocery shopper, I want to be able to view the details of a specific item, so that I can see the item notes.
* Verify that there functionality to open an item from the list
* Verify that accessing the item shows the item with its title and notes
4. As a grocery shopper, I want to be able to remove an item from the list so I can remove items no longer required.
* Verify there is functionality to delete an item when viewing the item details
* Verify there is a confirm dialog
5. As a grocery shopper, I want to be able to edit an item in my list, so that I can make changes to the item details.
* Verify there is functionality to edit an item when viewing the details of the item
* Verify that the user can save or cancel the item changes
6. As a grocery shopper, I want to be able to mark an item on the list as completed, so that I can see which items in the list I have left to purchase
* Verify there is functionality to toggle an item as purchased or unpurchased
* Verify that when this item is marked as purchased, it is displayed differently in the list of items 

## Technical Details
This project is built using the technologies listed above. To make the deployment easier, database and application server are embedded in the project. The building tool gradle is also embedded with gradle wrapper. So No extra configuration or installations are required to run the application.

### Instructions to Run
1. Clone or download the master branch from https://github.com/jigar310/ShoppingList.git to your local directory.
2. Make sure there is no service on your computer which is consuming the port# 8080
3. Open the command line terminal of your operating system and change the working directory to local repository of this application. i.e.
	*  For Windows, open Command Prompt and type ``` cd "PATH_TO_SHOPPING_LIST_REPOSITORY" ``` (Change "PATH_TO_SHOPPING_LIST_REPOSITORY" with your local directory)
4. Run one of the below commands specific to your operating system.
	* ``` gradlew appRun ``` if you have Windows operating system.
	* ``` ./gradlew appRun ``` if you have UNIX based operating system.
5. Monitor the logs on the console and once you see ```shoppingList runs at:  http://localhost:8080/shoppingList``` on the console,  goto http://localhost:8080/shoppingList in your preferred browser.