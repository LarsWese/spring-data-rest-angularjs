package de.wesemann.test.repositories;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import de.wesemann.test.HomeController;

public class MyRepositoryImpl implements MyRepository {
	private static final String QUERY = "SELECT distinct count(country) as count, country "
			+ "FROM TestTable group by country order by count desc";
	private static final Logger logger = Logger.getLogger(HomeController.class);
	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public Map<String, Long> getCountByCountry() {
		logger.info("read this shit out dude");
		Map<String, Long> result = new HashMap<>();
		Query query = em.createQuery(QUERY);
		logger.info("List" + query.getResultList());
		return result;
	}

}
