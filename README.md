# Grails Plugin Experiment
Defining a Grails 3.0 plugin domain class to be extendable

##### Details on SO:
http://stackoverflow.com/q/30798748

This project contains a plugin called **security** and an application called **bookstore** to test the plugin.

##### Plugin user:

    org.centerkey.grails.User

##### Application user (extends plugin user):

    com.example.BookstoreUser

### Try it out

1. Build the plugin and run the test app:  `$ ./run.sh.command`
1. Open: [http://localhost:8080/](http://localhost:8080/)
1. Click link to create a user

### Challenge

How does the `createUser()` method in `SecurityService` save the new user?

    user.save(flush: true)  //the class in the database is actually BookstoreUser

Or is there some other way plugins should be designed to allow applications to extend a domain class?
