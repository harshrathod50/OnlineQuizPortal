package dev.rathod.harsh;

import dev.rathod.harsh.entity.Participant;
import jakarta.persistence.EntityManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ParticipantRegister")
public class ParticipantRegister extends HttpServlet {

	public ParticipantRegister() {
        super();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		EntityManager em = DbUtil.getEntityManager();
		Participant p = new Participant();
		p.setFirstName(request.getParameter("firstName"));
		if (request.getParameter("lastName") != null) {
			p.setLastName(request.getParameter("lastName"));
		}
		p.setEmail(request.getParameter("eMail"));
		p.setPassword(request.getParameter("pWord"));
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			response.setStatus(201);
			response.sendRedirect("participant_login.jsp");
		} catch(Exception e) {
			response.setStatus(400);
		}
	}
}
