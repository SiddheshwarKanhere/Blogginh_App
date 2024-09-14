package com.CodeWithDurgeh.Blog.exceptions;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ResourceNotFoundException extends RuntimeException{

	String resourceName;
	String fieldName;
	long filedValue;
	public ResourceNotFoundException(String resourceName, String fieldName, long filedValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName,filedValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.filedValue = filedValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public long getFiledValue() {
		return filedValue;
	}
	public void setFiledValue(long filedValue) {
		this.filedValue = filedValue;
	}
	@Override
	public String toString() {
		return "ResorurceNotFoundException [resourceName=" + resourceName + ", fieldName=" + fieldName + ", filedValue="
				+ filedValue + "]";
	}
	
	
	
}
