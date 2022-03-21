package me.mikholskiy.controllers;

import me.mikholskiy.daos.Dao;
import me.mikholskiy.daos.DepartureDao;
import me.mikholskiy.entities.Departure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Struct;

@Controller
@RequestMapping("/departure")
public class DepartureController {
	private Dao<Departure> departureDao;

	@Autowired
	public void setDepartureDao(@Qualifier("departureDao") Dao<Departure> departureDao) {
		this.departureDao = departureDao;
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
		departureDao.save(departure);

		return "redirect:/departure";
	}

	@GetMapping("/list")
	public String showAllDepartures(Model model) {
		model.addAttribute("listOfDepartures", departureDao.getAll());

		return "departure/list";
	}

	@PostMapping("/delete")
	public RedirectView deleteDeparture(@RequestParam String id) {
		departureDao.delete(Integer.parseInt(id));

		return new RedirectView("/departure/list");
	}
}