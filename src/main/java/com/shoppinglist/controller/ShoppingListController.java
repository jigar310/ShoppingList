package com.shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shoppinglist.domain.ShoppingItem;
import com.shoppinglist.domain.validator.ItemFormValidator;

@Controller
public class ShoppingListController {

	@Autowired
	ItemFormValidator itemFormValidator;

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
	public String greet(ModelMap model) {
		return "addItem";
	}

	@RequestMapping(value = "/saveOrUpdateItem", method = RequestMethod.POST)
	public String saveOrUpdateItem(@ModelAttribute("shoppingItem") @Validated ShoppingItem item, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "addItemForm";
		} else {

			redirectAttributes.addFlashAttribute("msg", "Item Added/Updated successfully!");

//			userService.saveOrUpdate(user);

			// POST/REDIRECT/GET
			return "redirect:/users/";

			// POST/FORWARD/GET
			// return "user/list";

		}

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
