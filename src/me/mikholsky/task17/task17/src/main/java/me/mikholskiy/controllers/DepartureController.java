package me.mikholskiy.controllers;

import me.mikholskiy.entities.Departure;
import me.mikholskiy.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/departure")
public class DepartureController {
	private Service<Departure> departureService;

	@Autowired
	public void setDepartureService(@Qualifier("departureServiceImpl") Service<Departure> departureService) {
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
	public String showAllDepartures(Model model) {
		model.addAttribute("listOfDepartures", departureService.getAll());

		return "departure/list";
	}

	@PostMapping("/delete")
	public RedirectView deleteDeparture(@RequestParam String id) {
		departureService.delete(Integer.parseInt(id));

		return new RedirectView("/departure/list");
	}
}