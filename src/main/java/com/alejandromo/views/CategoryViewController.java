package com.alejandromo.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alejandromo.models.Category;
import com.alejandromo.repositories.CategoryRepository;

@Controller
@RequestMapping(path = "/category")
public class CategoryViewController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/index")
	public String getAll(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "category/index";
	}
	
	@GetMapping("/add")
	public String addCat(Category category) {
		return "category/add";
	}
	
	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable("id") int id, Model model) {
		Category category = categoryRepository.findById(id).get();
		model.addAttribute("category", category);
		return "category/update";
	}
	
	@PostMapping("/addcategory")
	public String addCategory(@Validated Category category, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "category/add";
		}
		categoryRepository.save(category);
		return "redirect:/category/";
	}
	
	@PostMapping("/updatecategory/{id}")
	public String updateCategory(@PathVariable("id") int id, @Validated Category category, BindingResult result,
			Model model) {
		category.setIdCategory(id);
		if (result.hasErrors()) {
			return "update";
		}
		categoryRepository.save(category);
		return "redirect:/category/index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCat(@PathVariable("id") int id) {
		categoryRepository.deleteById(id);
		return "redirect:/category/";
	}
	
}
