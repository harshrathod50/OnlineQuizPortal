<%@ page import="dev.rathod.harsh.entity.Participant" %>
<div class="container">
  <div class="d-flex justify-content-end">
    <span class="fs-3">
    <% Participant p = (Participant)session.getAttribute("participant");
       if (p != null) { out.print(p.getFirstName()); } %>
    </span>
    <form action="Logout">
      <input type="submit" value="Logout =>" />
    </form>
  </div>
</div>
