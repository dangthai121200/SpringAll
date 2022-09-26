package com.com.thai.dang.domain.page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class StudentPageRequest extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentPageRequest(int page, int size, Sort sort) {
		super(page, size, sort);
	}

}
