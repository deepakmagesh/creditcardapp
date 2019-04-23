# creditcardapp
Credit card app using Spring boot + Spring security + Spring data

Credit card app using Spring boot + Spring security + Spring data.
Spring security ensures all the /secure/ URL's can be accessed only after logging in to the application. 
Spring security is responsible for logging in new user in to the system.

Admin user credentials 
user: admin 
pass : admin

The role table maintains the role for the user. By now all the users are defaulted to ADMIN role. 
The user_role table maps to user and role tables.
Spring data is used for the database operations. H2 in memnory database is used for the back end. 

The H2 console can be accessed within tha application "http://localhost:8080/h2-console"
By default spring boot application runs in 8080 port. 
You can modify the port in the application.properties by adding the following property 
server.port = <PORT_NUMBER>

The application is hosted in the spring boot integrated tomcat server. 
The application is integrated with Thymeleaf for the UI.

