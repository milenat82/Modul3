package com.application.modul3.company;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyService {
	@Autowired
	CompanyRepository companyRepository;

	public Company createCompany(Company company) {
		return companyRepository.saveAndFlush(company);
	}

	public List<Company>getAllCompanies(){
		return companyRepository.findAll();
	}
	
	public Company getCompanyById(Integer id) {
		Optional<Company>compOpt=companyRepository.findById(id);
		if(compOpt.isPresent()) {
			return compOpt.get();
		}
		return null;
	}
	
	public Company updateCompany(Company company, Integer id) {
		Company companyUpdated=getCompanyById(id);
		companyUpdated.setName(company.getName());
		companyUpdated.setNif(company.getNif());
		companyRepository.flush();
		return companyUpdated;
		
	}
	
	public void deleteCompanyById(Integer id) {
		companyRepository.deleteById(id);
	}
}
