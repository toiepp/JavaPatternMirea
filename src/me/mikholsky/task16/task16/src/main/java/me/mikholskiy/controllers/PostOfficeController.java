package me.mikholskiy.controllers;

import me.mikholskiy.daos.Dao;
import me.mikholskiy.entities.Departure;
import me.mikholskiy.entities.PostOffice;
import net.bytebuddy.matcher.StringMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/post-office")
public class PostOfficeController {
	private Dao<PostOffice> postOfficeDao;

	@Autowired
	public void setPostOfficeDao(@Qualifier("postOfficeDao") Dao<PostOffice> postOfficeDao) {
		this.postOfficeDao = postOfficeDao;
	}

	@GetMapping
	public String root() {
		return "post-office/main";
	}

	@GetMapping("/new-form")
	public String showFormToAddNewPostOffice(@ModelAttribute("postOffice") PostOffice postOffice) {
		return "post-office/form";
	}

	@PostMapping("/new")
	public String submitNewPostOffice(@ModelAttribute("postOffice") PostOffice postOffice) {
		postOfficeDao.save(postOffice);

		return "redirect:/post-office";
	}

	@GetMapping("/list")
	public String showAllPostOffices(Model model) {
		model.addAttribute("listOfPostOffices", postOfficeDao.getAll());

		return "post-office/list";
	}

	@PostMapping("/delete")
	public String deletePostOffice(@RequestParam String id) {
		postOfficeDao.delete(Integer.parseInt(id));

		return "redirect:/post-office/list";
	}

	@GetMapping("/{id}/departures")
	public String showAllRelatedDepartures(@PathVariable Integer id, Model model) {
		var postOffice = postOfficeDao.get(id);

		postOffice.get().getDepartures().forEach(System.out::println);

		postOffice.ifPresent(p -> model.addAttribute("listOfDepartures", p.getDepartures()));

		return "departure/list";
	}
}
