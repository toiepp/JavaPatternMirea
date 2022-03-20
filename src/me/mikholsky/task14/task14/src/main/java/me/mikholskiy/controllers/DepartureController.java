package me.mikholskiy.controllers;

import me.mikholskiy.Database;
import me.mikholskiy.entities.Departure;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("/departure")
public class DepartureController {
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
		departure.setId(++Database.DEPARTURE_ID);
		Database.addDeparture(departure);

		return "redirect:/departure";
	}

	@GetMapping("/list")
	public String showAllDepartures(@ModelAttribute("listOfDepartures") ArrayList<Departure> departures) {
		departures.addAll(Database.getAllDepartures());

		return "departure/list";
	}

	@PostMapping("/delete/{id}")
	public RedirectView deleteDeparture(@PathVariable("id") Integer idOfDeparture) {
		Database.deleteDeparture(idOfDeparture);

		return new RedirectView("/departure/list");
	}
}