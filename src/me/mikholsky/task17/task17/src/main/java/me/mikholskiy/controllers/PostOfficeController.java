package me.mikholskiy.controllers;

import me.mikholskiy.entities.PostOffice;
import me.mikholskiy.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

@Controller
@RequestMapping("/post-office")
public class PostOfficeController {
	private Service<PostOffice> postOfficeService;
	private CriteriaBuilder criteriaBuilder;

	@Autowired
	public void setPostOfficeService(@Qualifier("postOfficeServiceImpl") Service<PostOffice> postOfficeService) {
		this.postOfficeService = postOfficeService;
	}

	@Autowired
	public void setCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
		this.criteriaBuilder = criteriaBuilder;
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
	public String showAllPostOffices(@RequestParam(value = "by-name", required = false) String byName,
									 @RequestParam(value = "by-city", required = false) String byCity,
									 Model model) {
		CriteriaQuery<PostOffice> query = criteriaBuilder.createQuery(PostOffice.class);
		Root<PostOffice> root = query.from(PostOffice.class);

		if (byName != null && !byName.isEmpty()) {
			query.where(criteriaBuilder.like(root.get("name"), byName));
		}

		if (byCity != null && !byCity.isEmpty()) {
			query.where(criteriaBuilder.like(root.get("cityName"), byCity));
		}

		if (byName == null && byCity == null) {
			query.select(root);
		}

		List<PostOffice> list = postOfficeService.getAll(query);

		model.addAttribute("listOfPostOffices", list);

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

		postOffice.get().getDepartures();

		postOffice.ifPresent(p -> model.addAttribute("listOfDepartures", p.getDepartures()));

		return "departure/list";
	}
}
