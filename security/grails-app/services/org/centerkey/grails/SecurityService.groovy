package org.centerkey.grails

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SecurityService {

   def encoder = new BCryptPasswordEncoder()
   def userDomainClass
   def grailsApplication

   def createUser(String email, String password) {
      def user = getUserDomainClass().newInstance(email: email, hash: encoder.encode(password))
      log.println "Register new user: \n   ${user as grails.converters.JSON}"
      return user
   }

   def createAndSaveUser(Map userInfo) {
      def user = getUserDomainClass().newInstance(userInfo)
      user.hash = encoder.encode(userInfo.password)
      log.println "Register new user: \n   ${user as grails.converters.JSON}"

      // return the saved user
      user.save()
  }

   protected getUserDomainClass() {
      if(!userDomainClass) {
         userDomainClass = grailsApplication.getDomainClass(grailsApplication.config.myapp.securityDomainClass)?.clazz
      }
      userDomainClass
   }
}
