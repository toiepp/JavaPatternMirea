package me.mikholskiy.controllers;

import me.mikholskiy.entities.Departure;
import me.mikholskiy.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

@Controller
@RequestMapping("/departure")
public class DepartureController {
	private Service<Departure> departureService;
	private CriteriaBuilder criteriaBuilder;

	@Autowired
	public void setDepartureService(@Qualifier("departureServiceImpl") Service<Departure> departureService) {
		this.departureService = departureService;
	}

	@Autowired
	public void setCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
		this.criteriaBuilder = criteriaBuilder;
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
	public String showAllDepartures(@RequestParam(value = "by-type", required = false) String byType,
									@RequestParam(value = "by-departure-date", required = false) String byDepartureName,
									Model model) {
		CriteriaQuery<Departure> query = criteriaBuilder.createQuery(Departure.class);
		Root<Departure> root = query.from(Departure.class);

		if (byType != null && !byType.isEmpty()) {
			query.where(criteriaBuilder.like(root.get("type"), byType));
		}

		if (byDepartureName != null && !byDepartureName.isEmpty()) {
			query.where(criteriaBuilder.like(root.get("departureDate"), byDepartureName));
		}

		if (byType == null && byDepartureName == null) {
			query.select(root);
		}

		model.addAttribute("listOfDepartures", departureService.getAll(query));

		return "departure/list";
	}

	@PostMapping("/delete")
	public RedirectView deleteDeparture(@RequestParam String id) {
		departureService.delete(Integer.parseInt(id));

		return new RedirectView("/departure/list");
	}
}