<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="dev.rathod.harsh.entity.Participant" %>
<% Participant p = (Participant)session.getAttribute("participant");
   if (p == null) {
     response.sendRedirect("participant_login.jsp");
   } %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <title>Participant Dashboard</title>
  </head>
  <body class="">
    <jsp:include page="component/participant/header.jsp"></jsp:include>
    <div class="container">
      <div class="row">
        <div class="col">
          
        </div>
        <div class="col">
          
        </div>
      </div>
    </div>
    <jsp:include page="component/footer.jsp"></jsp:include>
  </body>
</html>
