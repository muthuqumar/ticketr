This is a simple Ticket booking application. 

The following operations are supported:
1. View all users and add a new user.
2. Book a seat. One user can book only one seat for now.
3. Modify the seat.
4. Cancel the seat.
5. View the bookings filtered by section.

The application is pre-seeded with the following data:
1. Two users with id 1,2
2. All the seats are seeded, with odd number ids signifying section A and even number ids signifying section B. There are 50 seats in each section.
3. Only one tariff is pre-seeded, with source London, and destination Paris for 5 units of currency.

A postman collection is also attached to the code, which can be imported.
/post-collection
Reference: https://learning.postman.com/docs/getting-started/importing-and-exporting/importing-data/

A basic Open API spec is also available:
http://localhost:8080/open-api (JSON)
http://localhost:8080/open-api.yaml

Swagger UI link
http://localhost:8080/swagger-ui/index.html
