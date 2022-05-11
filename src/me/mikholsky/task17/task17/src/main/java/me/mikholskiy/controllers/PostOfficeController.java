package me.mikholskiy.controllers;

import me.mikholskiy.entities.PostOffice;
import me.mikholskiy.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post-office")
public class PostOfficeController {
	private Service<PostOffice> postOfficeService;

	@Autowired
	public void setPostOfficeDao(@Qualifier("postOfficeService") Service<PostOffice> postOfficeService) {
		this.postOfficeService = postOfficeService;
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
		postOfficeService.save(postOffice);

		return "redirect:/post-office";
	}

	@GetMapping("/list")
	public String showAllPostOffices(Model model) {
		model.addAttribute("listOfPostOffices", postOfficeService.getAll());

		return "post-office/list";
	}

	@PostMapping("/delete")
	public String deletePostOffice(@RequestParam String id) {
		postOfficeService.delete(Integer.parseInt(id));

		return "redirect:/post-office/list";
	}

	@GetMapping("/{id}/departures")
	public String showAllRelatedDepartures(@PathVariable Integer id, Model model) {
		var postOffice = postOfficeService.get(id);

		postOffice.get().getDepartures().forEach(System.out::println);

		postOffice.ifPresent(p -> model.addAttribute("listOfDepartures", p.getDepartures()));

		return "departure/list";
	}
}
