package me.mikholskiy.controllers;

import me.mikholskiy.Database;
import me.mikholskiy.entities.PostOffice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/post-office")
public class PostOfficeController {

	@GetMapping
	public String root() {
		return "post-office/main";
	}

	@GetMapping("/new-form")
	public String showFormToAddNewPostOffice(@ModelAttribute("postOffice")PostOffice postOffice) {
		return "post-office/form";
	}

	@PostMapping("/new")
	public String submitNewPostOffice(@ModelAttribute("postOffice") PostOffice postOffice) {
		postOffice.setId(++Database.POSTOFFICE_ID);
		Database.addPostOffice(postOffice);

		return "redirect:/post-office";
	}

	@GetMapping("/list")
	public String showAllPostOffices(@ModelAttribute("listOfPostOffices") ArrayList<PostOffice> postOffices) {
		postOffices.addAll(Database.getAllPostOffices());

		return "post-office/list";
	}

	@PostMapping("/delete/{id}")
	public String deletePostOffice(@PathVariable("id") Integer idOfPostOffice) {
		Database.deletePostOffice(idOfPostOffice);

		return "redirect:/post-office/list";
	}}
