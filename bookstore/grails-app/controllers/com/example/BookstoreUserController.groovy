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

   def list() {
      render BookstoreUser.list() as JSON
      }

}
