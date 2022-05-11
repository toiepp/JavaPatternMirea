package me.mikholskiy.task18.controllers;

import me.mikholskiy.task18.domains.PostOffice;
import me.mikholskiy.task18.services.postOffice.PostOfficeServiceSimpleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.Access;
import java.util.Map;

@Controller
@RequestMapping("/post-offices")
public class PostOfficeController {
	private PostOfficeServiceSimpleImpl postOfficeService;

	@Autowired
	public void setPostOfficeService(PostOfficeServiceSimpleImpl postOfficeService) {
		this.postOfficeService = postOfficeService;
	}

	@GetMapping
	public ModelAndView listOfAll(Model model) {
		return new ModelAndView("post-office/list",
								Map.of("listOfPostOffices", postOfficeService.getAll()));
	}

	@GetMapping("/new")
	public String addNewForm(Model model) {
		model.addAttribute("newOne", new PostOffice());
		return "post-office/add";
	}

	@PostMapping
	public RedirectView addNew(@ModelAttribute PostOffice newOne) {
		postOfficeService.save(newOne);
		return new RedirectView("/post-offices");
	}

	@PostMapping("/delete")
	public RedirectView deleteOneById(@RequestParam Integer id) {
		postOfficeService.deleteById(id);

		return new RedirectView("/post-offices");
	}
}
