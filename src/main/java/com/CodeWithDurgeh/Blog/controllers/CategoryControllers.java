package com.CodeWithDurgeh.Blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CodeWithDurgeh.Blog.paylodes.ApiResponce;
import com.CodeWithDurgeh.Blog.paylodes.CategoryDto;
import com.CodeWithDurgeh.Blog.services.CategoryServices;

@RestController
@RequestMapping("/api/categories")
public class CategoryControllers {

	@Autowired
	private CategoryServices categoryServices;

	// create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid@RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = this.categoryServices.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
	}

	// updete
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid@RequestBody CategoryDto categoryDto,
			@PathVariable Integer catId) {
		CategoryDto updateCategory = this.categoryServices.updateCategory(categoryDto, catId);
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponce> deleteCategory(@PathVariable Integer catId) {
		this.categoryServices.deleteCategory(catId);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Category Deleted successfully !!", true),
				HttpStatus.OK);
	}
	// get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId) {
		CategoryDto categoryDto = this.categoryServices.getCategory(catId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	// getall
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories() {
		 List<CategoryDto> categories = this.categoryServices.getCategories();
		 return ResponseEntity.ok(categories);
	}
}
