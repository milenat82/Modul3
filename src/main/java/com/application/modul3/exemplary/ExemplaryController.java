package com.application.modul3.exemplary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplary")
public class ExemplaryController {

	@Autowired
	private ExemplaryService exemplaryService;

	@PostMapping("/add/{bookId}")
	public Exemplary createExemplary(@PathVariable Integer bookId, @RequestBody Exemplary exemplary) {
		return exemplaryService.createExemplary(bookId, exemplary);
	}

}