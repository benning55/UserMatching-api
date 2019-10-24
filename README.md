# UserMatching-api
- This project is the part of Service Oriented Programming.


# What is this project about?
This goal of this project is to make service that match the user from diference other database and define the user and activity log
- Match user verification with other email.
- Match user with public data that the user is real person.
- Collect all user information and log in one place.


<img src="matching.png">

# The tools that we will use?
- Post Man
- Java SpringBoot api
- My Sql v5.7
- Google Cloud Platform (Sql database)

# (development) Mocked Up Company Data
To access the mocked up data please run the project "companya"
```
localhost:8200/companya -> Get All Company Customer Mocked Up Data
localhost:8200/id -> Get by Id of Company Customer Mocked Up Data
localhost:8200/companya-create -> Post New Company Customer Mocked Up Data

Fields of data:
id, username, password, email
id_card_number, fname, lname, address
phone, credit_card
``` 

# Eureka Server
The eureka server is run localhost:8761
