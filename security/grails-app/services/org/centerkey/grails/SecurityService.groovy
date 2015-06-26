package org.centerkey.grails

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SecurityService {

   def encoder = new BCryptPasswordEncoder()

   def createUser(String email, String password) {
      def user = new User(email: email, hash: encoder.encode(password))
      log.println "Register new user: \n   ${user as grails.converters.JSON}"
      user.save(flush: true)  //MissingMethodException (because User is not the actual domain class BookstoreUser)
      return user
      }

}
