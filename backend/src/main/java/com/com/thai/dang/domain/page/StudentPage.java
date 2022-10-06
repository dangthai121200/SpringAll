package com.com.thai.dang.domain.page;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.GeoPage;
import org.springframework.data.geo.GeoResults;

public class StudentPage<StudentDomain> extends GeoPage<StudentDomain> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StudentPage(GeoResults<StudentDomain> results) {
		super(results);
	}
	
	public StudentPage(GeoResults<StudentDomain> results, Pageable pageable, long total) {
		super(results, pageable, total);
	}

	public StudentPage(List<StudentDomain> studentDomains, Pageable pageable,
			int totalPages) {
		super(results, pageable, totalPages);
	}
	
	

}
