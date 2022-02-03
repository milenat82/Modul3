package com.application.modul3.exemplary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.exemplary.dto.ExemplaryDTO;
import com.application.modul3.exemplary.mapper.ExemplaryMapper;

@RestController
@RequestMapping("/exemplary")
public class ExemplaryController {

	@Autowired
	private ExemplaryService exemplaryService;

	@Autowired
	private ExemplaryMapper exemplaryMapper;

	@PostMapping("/add/{bookId}")
	public ExemplaryDTO createExemplary(@PathVariable Integer bookId, @RequestBody ExemplaryDTO exemplaryDTO) {
		Exemplary createdExemplary = exemplaryService.createExemplary(bookId,
				exemplaryMapper.exemplaryDTO2Exemplary(exemplaryDTO));
		return exemplaryMapper.exemplary2ExemplaryDTO(createdExemplary);
	}

	@GetMapping("/list/{bookId}")
	public List<ExemplaryDTO> findExemplariesByBookId(@PathVariable Integer bookId) {
		return exemplaryMapper.exemplaryList2ExemplaryDTOList(exemplaryService.findExemplariesByBookId(bookId));
	}

	@DeleteMapping("/{exemplaryId}")
	public void deleteExemplary(@PathVariable Integer exemplaryId) {
		exemplaryService.deleteExemplary(exemplaryId);
	}

}