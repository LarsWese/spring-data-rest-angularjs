package de.wesemann.test;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.wesemann.test.repositories.TestTableRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	TestTableRepository testRepository;

	/**
	 * Simply selects the home view to render by returning its name. , headers =
	 * "content-type=application/json,application/xml"
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		// System.out.println(testRepository.getCountByCountry());
		List<Object> countCountry = testRepository.countCountry();
		for (Object item : countCountry) {
			Object[] tuple = (Object[]) item;
			String itemType = (String) tuple[0];
			Long count = (Long) tuple[1];
			System.out.println(itemType + ": " + count);
		}
		return "index";
	}

	/**
	 * Simply selects the home view to render by returning its name. , headers =
	 * "content-type=application/json,application/xml"
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {

		return "test.html";
	}

	/**
	 * Simply selects the home view to render by returning its name. , headers =
	 * "content-type=application/json,application/xml"
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	/**
	 * Simply selects the home view to render by returning its name. , headers =
	 * "content-type=application/json,application/xml"
	 */
	@RequestMapping(value = "/home/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		// logger.info("called list");
		return "list";
	}

}
