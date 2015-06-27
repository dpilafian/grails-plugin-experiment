<!doctype html>
<html>
   <head>
      <meta name="layout" content="main" />
      <title>Grails Plugin Experiment</title>
   </head>
   <body>
      <h1>Grails Plugin Experiment</h1>
      <p>
         <g:link controller="bookstoreUser" action="list">List Bookstore Users</g:link>
         (returns JSON)
      </p>
      <p>
         <g:link controller="bookstoreUser" action="register"
            params="[email: 'lee@example.com', password: '123456']">Create Bookstore User</g:link>
          (returns JSON)
      </p>
  <p>
     <g:link controller="bookstoreUser" action="register2"
        params="[email: 'alvin@example.com', password: '123456']">Another Approach To Create Bookstore User</g:link>
      (returns JSON)
  </p>
    </body>
</html>
