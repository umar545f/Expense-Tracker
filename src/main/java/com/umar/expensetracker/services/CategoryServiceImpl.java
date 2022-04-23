package com.umar.expensetracker.services;

import com.umar.expensetracker.domain.Category;
import com.umar.expensetracker.exceptions.EtBadRequestException;
import com.umar.expensetracker.exceptions.EtResourceNotFoundException;
import com.umar.expensetracker.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepository;


	@Override
	public List<Category> fetchAllCategories(Integer userId) {
		return categoryRepository.findAll(userId);
	}

	@Override
	public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
		return categoryRepository.findById(userId, categoryId);
	}

	@Override
	public Category addCategory(Integer userId, String title, String description) throws EtBadRequestException {
		int categoryId = categoryRepository.create(userId, title, description);
		return categoryRepository.findById(userId, categoryId);
	}

	@Override
	public void updatedCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {
		categoryRepository.update(userId, categoryId, category);
	}

	@Override
	public void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
		this.fetchCategoryById(userId, categoryId);
		categoryRepository.removeById(userId, categoryId);
	}
}
