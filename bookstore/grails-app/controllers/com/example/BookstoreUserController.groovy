package com.example

import grails.converters.JSON
import com.example.BookstoreUser

class BookstoreUserController {

   def securityService

   def register() {
      def bookstoreUser = securityService.createUser(params.email, params.password)
      bookstoreUser.name = "Lee"
      bookstoreUser.save(flush: true)
      render bookstoreUser as JSON
   }

   def register2() {
      def bookstoreUser = securityService.createAndSaveUser(email: params.email,
                                                            password: params.password,
                                                            name: 'Alvin')
      render bookstoreUser as JSON
   }

   def list() {
      render BookstoreUser.list() as JSON
      }

}
