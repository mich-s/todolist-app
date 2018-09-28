# To Do list app
This is an Spring-based _To Do List_  app.
Features:
- user registration and login
- option to log in to predefined user accounts:
	- Meg (username: meg, password: test123, default entries)
	- John (username: john, password: test123)
- CRUD operations on lists and tasks
## Tools & Technologies
- Spring MVC, Spring Security
- Hibernate
- Maven
- JUnit 5
- JSP, JSTL
- Bootstrap

## Requirements
In order to run the application you need:
- Java 8
- Maven 3
- MySQL 5
 
## Getting the code
Clone the repository:
```
git clone https://github.com/mich-s/todolist-app.git
```
## Database configuration
Add the credentials to `src/main/resources/persistence-mysql.properties`.  
The default ones are :
```
jdbc.url=jdbc:mysql://localhost:3306/todolist-app?serverTimezone=UTC&useSSL=false
jdbc.user=
jdbc.password=
```
Bootstrap a command line and navigate to the folder where `todo-list.sql` is in:
```
cd todolist-app/src/main/resources/db
``` 
Type:
```
mysql -u username -p < todo-list.sql
```
and then enter a password.
__Remember__ to use MySQL username and password as per your installation.

> Instead of creating database using the above guide, you can also run __todo-list.sql__ script  in MySQL Workbench.
## Running the application 
Go to the root directory of this project (the one that contains the _pom.xml_ file) and run command:
```
mvn clean jetty:run
```
Start your browser and go to the location: 
`http://localhost:8080/todo-list`

You can also run the app by packaging it -`mvn clean package` -
 and deploying the _war_ artifact on a web container, e.g. Tomcat.
Another possibility is to import this project to an IDE and build the project to resolve the dependencies.

### Screenshots
![Alt](
https://github.com/mich-s/todolist-app/blob/master/src/main/webapp/resources/img/tl2.PNG)
![Alt](
https://github.com/mich-s/todolist-app/blob/master/src/main/webapp/resources/img/tl1.PNG)