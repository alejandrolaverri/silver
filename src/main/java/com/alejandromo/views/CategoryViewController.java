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
import com.alejandromo.models.Shoe;
import com.alejandromo.repositories.CategoryRepository;
import com.alejandromo.repositories.ShoeRepository;

@Controller
@RequestMapping(path = "/category")
public class CategoryViewController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ShoeRepository shoeRepository;
	
	@GetMapping("/index")
	public String getAll(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "category/index";
	}
	
	@GetMapping("/add")
	public String addCat(Category category) {
		return "category/add";
	}
	
	@GetMapping("/addshoe/{id}")
	public String addShoe(@PathVariable("id") int id, Shoe shoe, Model model) {
		Category category = categoryRepository.findById(id).get();
		model.addAttribute("category", category);
		return "category/addshoe";
	}
	
	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable("id") int id, Model model) {
		Category category = categoryRepository.findById(id).get();
		model.addAttribute("category", category);
		return "category/update";
	}
	
	@GetMapping("/{id}")
	public String viewShoesCategory(@PathVariable("id") int id, @Validated Category category, Model model) {
		model.addAttribute("category", categoryRepository.findById(id).get());
		model.addAttribute("shoes", shoeRepository.findByCategoryIdCategory(id));
		return "category/shoes";
	}
	
	@PostMapping("/addcategory")
	public String addCategory(@Validated Category category, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "category/add";
		}
		categoryRepository.save(category);
		return "redirect:/category/index";
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
	
	@PostMapping("/addshoe/{id}")
	public String addShoe(@PathVariable("id") int id, @Validated Shoe shoe, BindingResult result,
			Model model) {
		Category category = categoryRepository.findById(id).get();
		shoe.setCategory(category);
		shoeRepository.save(shoe);
		return "redirect:/category/"+category.getIdCategory();
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCat(@PathVariable("id") int id) {
		categoryRepository.deleteById(id);
		return "redirect:/category/index";
	}
	
}
