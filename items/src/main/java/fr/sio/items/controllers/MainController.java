package fr.sio.items.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fr.sio.items.models.Element;

@Controller
@SessionAttributes("items")
public class MainController {
	@GetMapping("")
	public String index() {
		return "index";
	}

	@ModelAttribute("items")
	public List<Element> getItems() {
		return new ArrayList<>();
	}

	@GetMapping("add/{name}")
	public RedirectView addItem(@PathVariable String name, @SessionAttribute List<Element> items,
			RedirectAttributes attrs) {
		items.add(new Element(name));
		attrs.addFlashAttribute("msg", "Elément " + name + " ajouté");
		return new RedirectView("/");
	}

	@GetMapping("add")
	public RedirectView addForm(RedirectAttributes attrs) {
		attrs.addFlashAttribute("form", true);
		return new RedirectView("/");
	}

	@PostMapping("add")
	public RedirectView postForm(@RequestParam String name, @SessionAttribute List<Element> items,
			RedirectAttributes attrs) {
		items.add(new Element(name));
		attrs.addFlashAttribute("msg", "Elément " + name + " ajouté");
		return new RedirectView("/");
	}
}
