package dev.rathod.harsh;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbUtil {
	private static EntityManagerFactory emf = null;

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("hbn");
		}
		return emf.createEntityManager();
	}

	public void finalize() {
		emf.close();
	}
}
