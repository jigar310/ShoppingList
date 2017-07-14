package com.shoppinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shoppinglist.domain.ShoppingItem;
import com.shoppinglist.domain.validator.ItemFormValidator;
import com.shoppinglist.service.ShoppingItemService;

@Controller
public class ShoppingListController {

	@Autowired
	ItemFormValidator itemFormValidator;

	@Autowired
	ShoppingItemService shoppingItemService;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(itemFormValidator);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "index";
	}

	@RequestMapping(path = "/addItemForm", method = RequestMethod.GET)
	public ModelAndView addItemForm() {
		return new ModelAndView("addItem", "shoppingItemForm", new ShoppingItem());
	}

	@RequestMapping(value = "/saveOrUpdateItem", method = RequestMethod.POST)
	public String saveOrUpdateItem(@ModelAttribute("shoppingItemForm") @Validated ShoppingItem item,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("msg", result.getFieldError("title").getCode());
			redirectAttributes.addFlashAttribute("cssColor", "red");
			return "redirect:/addItemForm";
		} else {

			shoppingItemService.saveOrUpdate(item);
			redirectAttributes.addFlashAttribute("msg", "Item Added/Updated successfully!");
			redirectAttributes.addFlashAttribute("cssColor", "green");
			return "redirect:/listAllItems";

		}

	}

	@RequestMapping(value = "/listAllItems", method = RequestMethod.GET)
	public ModelAndView listAllItems() {
		List<ShoppingItem> items = shoppingItemService.findAll();
		ModelAndView model = new ModelAndView("listItems");
		model.addObject("items", items);

		return model;
	}
	
	@RequestMapping(path = "/viewItem/{id}", method = RequestMethod.GET)
	public ModelAndView viewItem(@PathVariable Long id) {
		if(id != null){
			ShoppingItem item = shoppingItemService.find(id);
			return new ModelAndView("viewItem", "shoppingItemForm", item);
		}else{
			return new ModelAndView("viewItem", "shoppingItemForm", new ShoppingItem());	
		}
		
		
	}
	
	@RequestMapping(path = "/deleteItem/{id}", method = RequestMethod.GET)
	public String deleteItem(@PathVariable Long id, final RedirectAttributes redirectAttributes) {
		if(id != null){
			shoppingItemService.delete(id);
			redirectAttributes.addFlashAttribute("msg", "Iten Deleted Successfully!");
			redirectAttributes.addFlashAttribute("cssColor", "green");
		}
			return "redirect:/listAllItems";
		
	}
	/*
	 * @RequestMapping(path= "/greet/{name}",method=RequestMethod.GET) public
	 * String greet(@PathVariable String name, ModelMap model){ String greet =
	 * " Hello !!!" + name + " How are You?"; model.addAttribute("greet",
	 * greet); System.out.println(greet);
	 * 
	 * return "greet"; }
	 */

}
