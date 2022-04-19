package me.mikholskiy.task18.controllers;

import me.mikholskiy.task18.domains.Departure;
import me.mikholskiy.task18.services.departure.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping("/departures")
public class DepartureController {
	private DepartureService departureService;

	@Autowired
	public void setRepository(@Qualifier("departureService") DepartureService departureService) {
		this.departureService = departureService;
	}

	@GetMapping
	public ModelAndView listOfAll(Model model) {
		return new ModelAndView("departure/list", Map.of("listOfDepartures", departureService.getAll()));
	}

	@GetMapping("/new")
	public String addNewForm(Model model) {
		model.addAttribute("newOne", new Departure());
		return "departures/add";
	}

	@PostMapping
	public RedirectView addNew(@ModelAttribute Departure newOne) {
		departureService.save(newOne);
		return new RedirectView("departures");
	}

	@PostMapping("/delete")
	public RedirectView deleteOneById(@RequestParam Integer id) {
		departureService.deleteById(id);

		return new RedirectView("/departures");
	}
}
