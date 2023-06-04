<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <title>Online Quiz Portal</title>
  </head>
  <body class="">
    <jsp:include page="component/header.jsp"></jsp:include>
    <div class="container">
      <div class="row">
        <div class="col">
          <h2 class="display-2">Admin</h2>
          <a href="admin_login.jsp" class="btn btn-primary">Login</a>        
        </div>
        <div class="col">
          <h2 class="display-2">Participant</h2>
          <a href="participant_login.jsp" class="btn btn-primary">Login</a>
          <a href="participant_register.jsp" class="btn btn-primary">Sign up</a>
        </div>
      </div>
    </div>
    <jsp:include page="component/footer.jsp"></jsp:include>
  </body>
</html>
