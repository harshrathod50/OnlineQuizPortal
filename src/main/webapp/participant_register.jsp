
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <title>Participant Register</title>
  </head>
  <body class="">
    <jsp:include page="component/header.jsp"></jsp:include>
    <div class="container">
      <div class="row">
        <div class="col">
          <h2 class="display-2">Participant</h2>
        </div>
        <div class="col">
          <form action="ParticipantRegister" method="post">
            <div class="mb-3 row">
              <label for="firstName" class="col-sm-2 col-form-label">First name</label>
              <div class="col-sm-10">
                <input id="firstName" name="firstName" type="text" class="form-control-plaintext" 
                required />
              </div>
            </div>
            <div class="mb-3 row">
              <label for="lastName" class="col-sm-2 col-form-label">Last name</label>
              <div class="col-sm-10">
                <input id="lastName" name="lastName" type="text" class="form-control-plaintext" />
              </div>
            </div>
            <div class="mb-3 row">
              <label for="eMail" class="col-sm-2 col-form-label">Email</label>
              <div class="col-sm-10">
                <input id="eMail" name="eMail" type="text" class="form-control-plaintext"
                required />
              </div>
            </div>
            <div class="mb-3 row">
              <label for="pWord" class="col-sm-2 col-form-label">Password</label>
              <div class="col-sm-10">
                <input id="pWord" name="pWord" type="password" class="form-control-plaintext"
                required />
              </div>
            </div>
            <div class="mb-3 row">
              <input type="submit" class="btn btn-primary" value="Register" />
            </div>
          </form>
        </div>
      </div>
    </div>
    <jsp:include page="component/footer.jsp"></jsp:include>
  </body>
</html>
