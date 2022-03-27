package com.application.modul3.company.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.modul3.company.Company;
import com.application.modul3.company.dto.CompanyDTO;

@Component
public class CompanyMapper {


	public CompanyDTO company2CompanyDTO(Company company) {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setId(company.getId());
		companyDTO.setName(company.getName());
		companyDTO.setNif(company.getNif());
		return companyDTO;
	}

	public List<CompanyDTO> companyList2CompanyDTOList(List<Company> companyList) {
		return companyList.stream().map(company -> company2CompanyDTO(company)).collect(Collectors.toList());
	}

	public Company companyDTO2Company(CompanyDTO companyDTO) {
		Company commpany = new Company();
		commpany.setId(companyDTO.getId());
		commpany.setName(companyDTO.getName());
		commpany.setNif(companyDTO.getNif());
		return commpany;
	}
}