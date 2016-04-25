# ScavengerHuntServer

Simple server for ScavengerHuntApp learning purposes

How to setup the standalone server:

SW Requirements:
	mariadb ( or mysql) - databases to hold most of the information on the server
	maven - only needed to edit the server
	IntelliJ - To develop Java server
	JDK 1.8

1. git clone https://github.com/Dhsieh/ScavengerHuntServer
2. log in to mariadb and create the android_db database
3. use android_db
4. create tables using android_db.sql

5. insert users values('test','f5d1278e8109edd94e1e4197e04873b9','McTester@Tester.com','tester','McTester');
6. make a user with a password
	create user 'readwrite' identified by 'reader123'
7. change permissions
	grant all on android_db.* to 'readwrite'@'%';
8. make a sql.properties file with the following
	username=readwrite
	password=reader123
	url=jdbc:mariadb://localhost:3306/android_db
9. Change the file path in DBUtil/DBConnector of the ScavengerHuntServer to localhost
10. Change the IP address of the async adapters in the ScavengerHuntApp to the local machine IP