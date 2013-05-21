package de.wesemann.test.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

@RestResource(rel = "people", path = "people")
public interface TestTableRepository extends JpaRepository<TestTable, Long> {

	// @RestResource(rel = "country", path = "country")
	List<TestTable> findByCountry(@Param("country") String country);

	List<TestTable> findByTsBetween(Date start, Date end);
}
