# BookingAPI
## A booking API for a popular Hotel in Cancun in a Post-Covid scenario, needs a new booking API to manage user requests.
Technologies used: Java, Eclipse IDE, Tomcat 10.0

The application has 3 main classes, a Reservation Class, a Room class, and a User class. A Datastore to create dummy data for testing purposes. A client class to test User input and test endpoints and a Servlet class to deploy on the server the API endpoints.

Instructions to test the app:
- Clone the repository locally.
- For testing purposes Eclipse IDE and Tomcat 10.0 where used, import the project in Eclipse and create a new Tomcat server.
- Change tomcat's server URL port from 8080 to 8081 on the server's properties
- Export BookingAPI project as jar into BookingAPI -> Java Resources -> src -WEB-INF -> lib (Unselect main.webapp, META-INF and WEB-INF from the exporting options under the BookingAPI options)
- Copy Jakarta Servlet and Json jar libraries into BookingAPI -> Java Resources -> src -WEB-INF -> lib (Might need to add these as classpath dependencies of the project.)
- After exporting the Jar, run BookingAPI on the tomcat server
- Run the APIClient class (small APIClient created for testing purposes) as a java application and follow the instructions on EclipseIDE console.
- After testing succesfully any of the functions, if you want to test any other, the APIClient must be ran againa s java application.
