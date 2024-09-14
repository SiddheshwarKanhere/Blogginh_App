package com.CodeWithDurgeh.Blog.paylodes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter 
public class CategoryDto {

	private Integer CategoryId;
	@NotBlank
	@Size(min=3,message="min size of categorys title is 3")
	private String categoryTitle;
	@NotBlank
	@Size(min=5,message="min size of category disc is 5")
	private String categoryDescription;
}
