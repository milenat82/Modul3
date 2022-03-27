package com.application.modul3.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.modul3.company.Company;
import com.application.modul3.company.CompanyService;

@Component
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CompanyService companyService;
	
	public Account createAccount(Integer companyId, Account account) throws Exception {
		
		Company company=companyService.getCompanyById(companyId);
		if(company==null) {
			throw new Exception("Company with id"+companyId+"was not found");
		}
		company.addAccount(account);
		return accountRepository.saveAndFlush(account);
		
	}
	
	public void deleteAccount(Integer accountId) {
		accountRepository.deleteById(accountId);
	}
}
