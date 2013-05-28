package de.wesemann.test.repositories;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

@RestResource(rel = "people", path = "people")
public interface TestTableRepository extends
		PagingAndSortingRepository<TestTable, Long> {

	// @RestResource(rel = "country", path = "country")
	Page<TestTable> findByCountryContaining(@Param("country") String country,
			Pageable pageable);

	Page<TestTable> findByNameContaining(@Param("name") String name,
			Pageable pageable);

	// @Query(countQuery =
	// "select count(t.country) from TestTable t where t.country like %:country%")
	// long countByCountryLike(@Param("country") String country);

	@Query("SELECT country, count(country) as count FROM TestTable group by country")
	List<Object> countCountry();

	List<TestTable> findByTsBetween(Date start, Date end);
}
