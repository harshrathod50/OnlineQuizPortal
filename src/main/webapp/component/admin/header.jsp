<%@ page import="dev.rathod.harsh.entity.Admin" %>
<div class="container">
  <div class="d-flex justify-content-end">
    <span class="fs-3">
    <% Admin a = (Admin)session.getAttribute("admin");
       if (a != null) { out.print(a.getFirstName()); } %>
    </span>
    <form action="Logout">
      <input type="submit" value="Logout =>" />
    </form>
  </div>
</div>
