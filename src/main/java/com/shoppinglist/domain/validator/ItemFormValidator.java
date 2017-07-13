package com.shoppinglist.domain.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shoppinglist.domain.ShoppingItem;

public class ItemFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ShoppingItem.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ShoppingItem item = (ShoppingItem) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Please enter name");
	}

}
