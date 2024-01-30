package com.alejandromo.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alejandromo.repositories.ShoeRepository;

@Controller
@RequestMapping(path = "/shoe")
public class ShoeViewController {
	@Autowired
	private ShoeRepository shoeRepository;
	
	@GetMapping("/index")
	public String getAll(Model model) {
		model.addAttribute("shoes", shoeRepository.findAll());
		return "shoe/index";
	}
	
	
}