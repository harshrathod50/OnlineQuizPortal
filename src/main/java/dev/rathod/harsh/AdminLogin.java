package dev.rathod.harsh;

import dev.rathod.harsh.entity.Admin;
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

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

	public AdminLogin() {
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
		try {
			em.getTransaction().begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Admin> cq = cb.createQuery(Admin.class);
			Root<Admin> root = cq.from(Admin.class);
			Predicate eqEmail = cb.equal(root.get("email"), request.getParameter("eMail").toLowerCase());
			Predicate eqPassword = cb.equal(root.get("password"), request.getParameter("pWord"));
			cq.select(root).where(cb.and(eqEmail, eqPassword));
			Query q = em.createQuery(cq);
			List<Admin> r = q.getResultList();
			em.getTransaction().commit();
			if (r.size() == 1) {
				HttpSession s = request.getSession(true);
				s.setAttribute("admin", r.get(0));
				s.setMaxInactiveInterval(1000 * 60 * 2);
				response.sendRedirect("admin_dashboard.jsp");
			} else {
				response.sendError(404);
			}
		} catch(Exception e) {
			response.setStatus(404);
		}
	}
}
