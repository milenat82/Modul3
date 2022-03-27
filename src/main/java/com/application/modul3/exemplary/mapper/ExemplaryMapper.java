package com.application.modul3.exemplary.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.dto.CompanyDTO;

@Component
public class ExemplaryMapper {
	public CompanyDTO exemplary2ExemplaryDTO(Exemplary exemplary) {
		CompanyDTO exemplaryDTO = new CompanyDTO();
		exemplaryDTO.setId(exemplary.getId());
		exemplaryDTO.setDate(exemplary.getDate());
		exemplaryDTO.setCode(exemplary.getCode());
		exemplaryDTO.setPageNumbers(exemplary.getPageNumbers());
		return exemplaryDTO;
	}

	public List<CompanyDTO> exemplaryList2ExemplaryDTOList(List<Exemplary> exemplaryList) {
		return exemplaryList.stream().map(exemplary -> exemplary2ExemplaryDTO(exemplary)).collect(Collectors.toList());
	}

	public Exemplary exemplaryDTO2Exemplary(CompanyDTO exemplaryDTO) {
		Exemplary exemplary = new Exemplary();
		exemplary.setId(exemplaryDTO.getId());
		exemplary.setDate(exemplaryDTO.getDate());
		exemplary.setCode(exemplaryDTO.getCode());
		exemplary.setPageNumbers(exemplaryDTO.getPageNumbers());
		return exemplary;
	}
}