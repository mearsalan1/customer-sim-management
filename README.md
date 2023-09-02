# Customer Sim Management System


## Requirements

1. Java - 1.8.x

2. Maven - 3.1.1

3. MySQL - 5.7.12    

## Steps to Setup

**1. Clone the application**



**2. Create Mysql database**

```
create database csmssch
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation


**4. Build and run the app using maven**

```
mvn clean install
```

A new JAR file will be generated at `project/target/newbuild-0.0.1-SNAPSHOT.jar` 

**5. Run the app**

```
java -jar newbuild-0.0.1-SNAPSHOT.jar
```

The app will start running at <http://localhost:8080/csmsurl/nb>.

## Explore Application features

The app provides the following features -

	1. Add Customers
	
	2. Assign sim to customers

