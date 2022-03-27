package com.application.modul3.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.company.dto.CompanyDTO;
import com.application.modul3.company.mapper.CompanyMapper;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CompanyMapper companyMapper;

	@PostMapping
	public CompanyDTO createCompany(@RequestBody CompanyDTO companyDTO) {
		Company createCompany = companyService.createCompany(companyMapper.companyDTO2Company(companyDTO));
		return companyMapper.company2CompanyDTO(createCompany);
	}

	@GetMapping("/list")
	public List<CompanyDTO> getAllCompanies() {
		return companyMapper.companyList2CompanyDTOList(companyService.getAllCompanies());
	}
	
	@GetMapping("/{id}")
	public CompanyDTO getCompanyById(@PathVariable Integer id) {
		return companyMapper.company2CompanyDTO(companyService.getCompanyById(id));
	}
	
	@PutMapping("/{id}")
	public CompanyDTO updateCompany(@RequestBody CompanyDTO companyDTO, @PathVariable Integer id) {
		return companyMapper.company2CompanyDTO(companyService.updateCompany(companyMapper.companyDTO2Company(companyDTO), id));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCompanyById(@PathVariable Integer id) {
		companyService.deleteCompanyById(id);
	}
}
