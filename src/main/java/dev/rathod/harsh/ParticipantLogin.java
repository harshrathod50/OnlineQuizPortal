package dev.rathod.harsh;

import dev.rathod.harsh.entity.Participant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/ParticipantLogin")
public class ParticipantLogin extends HttpServlet {

	public ParticipantLogin() {
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
		Participant p = null;
		try {
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Participant> cq = cb.createQuery(Participant.class);
			Root<Participant> root = cq.from(Participant.class);
			Predicate eqEmail = cb.equal(root.get("email"), request.getParameter("eMail").toLowerCase());
			Predicate eqPassword = cb.equal(root.get("password"), request.getParameter("pWord"));
			cq.select(root).where(cb.and(eqEmail, eqPassword));
			Query q = em.createQuery(cq);
			List<Participant> r = q.getResultList();
			em.getTransaction().commit();
			if (r.size() == 1) {
				HttpSession s = request.getSession(true);
				s.setAttribute("participant", r.get(0));
				s.setMaxInactiveInterval(1000 * 60 * 2);
				response.sendRedirect("participant_dashboard.jsp");
			} else {
				response.sendError(404);
			}
		} catch(Exception e) {
			response.setStatus(404);
		}
	}
}
