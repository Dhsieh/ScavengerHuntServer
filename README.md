# ScavengerHuntServer

Simple server for ScavengerHuntApp learning purposes

How to setup the standalone server:

Requirements:
	mariadb ( or mysql) - databases to hold most of the information on the server
	maven - only needed to edit the server
	IntelliJ( or any IDE) - To develop Java server
	JDK 1.8

1. git clone https://github.com/Dhsieh/ScavengerHuntServer
2. log in to mariadb and create the android_db database
3. use android_db
4. create tables using android_db.sql
5. make a user with a password
	create user 'readwrite' identified by 'reader123'
6. change permissions
	grant all on android_db.* to 'readwrite'@'%';
7. edit the sql.properties file with the following
	username=readwrite
	password=reader123
	url=jdbc:mariadb://localhost:3306/android_db or jdbc:mysql://localhost:3306/android_db
8. Change the IP address of the async adapters in the ScavengerHuntApp to the local machine IP
9. When running ScavengerHuntServer, arguements needed are in this order: 1. server properties file 2. db properties file
