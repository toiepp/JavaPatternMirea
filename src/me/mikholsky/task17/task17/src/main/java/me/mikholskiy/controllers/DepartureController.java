package me.mikholskiy.controllers;

import me.mikholskiy.entities.Departure;
import me.mikholskiy.services.DepartureService;
import me.mikholskiy.services.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/departure")
public class DepartureController {
	private Service<Departure> departureService;
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setDepartureDao(@Qualifier("departureService") Service<Departure> departureService) {
		this.departureService = departureService;
	}

	@GetMapping
	public String root() {
		return "departure/main";
	}

	@GetMapping("/new-form")
	public String showFormToAddNewDeparture(@ModelAttribute("departure") Departure departure) {
		return "departure/form";
	}

	@PostMapping("/new")
	public String submitNewDeparture(@ModelAttribute("departure") Departure departure) {
		departureService.save(departure);

		return "redirect:/departure";
	}

	@GetMapping("/list")
	public String showAllDepartures(@RequestParam(required = false) String typePattern,
									@RequestParam(required = false) String dateBegin,
									@RequestParam(required = false) String dateEnd,
									Model model) {
		List<Departure> result;

		if (typePattern == null && dateBegin == null && dateEnd == null) {
			result = new ArrayList<>(departureService.getAll());
		} else {
			CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
			CriteriaQuery<Departure> query = cb.createQuery(Departure.class);
			Root<Departure> root = query.from(Departure.class);

			query.where(
				cb.and(
					cb.like(root.get("type"), typePattern),
					cb.between(root.get("departureDate"), dateBegin, dateEnd)
				)
			);

			result = departureService.getAllFiltered(query);
		}

		model.addAttribute("listOfDepartures", result);

		return "departure/list";
	}

	@PostMapping("/delete")
	public RedirectView deleteDeparture(@RequestParam String id) {
		departureService.delete(Integer.parseInt(id));

		return new RedirectView("/departure/list");
	}
}