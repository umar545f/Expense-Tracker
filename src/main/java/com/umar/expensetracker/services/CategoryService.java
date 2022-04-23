package com.umar.expensetracker.services;

import com.umar.expensetracker.domain.Category;
import com.umar.expensetracker.exceptions.EtBadRequestException;
import com.umar.expensetracker.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryService {
	List<Category> fetchAllCategories(Integer userId);

	Category fetchCategoryById(Integer userId,Integer categoryId)throws EtResourceNotFoundException;

	Category addCategory(Integer userId,String title,String description) throws EtBadRequestException;

	void updatedCategory(Integer userId,Integer categoryId,Category category) throws EtBadRequestException;

	void removeCategoryWithAllTransactions(Integer userId,Integer categoryId) throws EtResourceNotFoundException;


}
