package com.application.modul3.account.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.modul3.account.Account;
import com.application.modul3.account.dto.AccountDTO;
import com.application.modul3.company.Company;
import com.application.modul3.company.dto.CompanyDTO;

@Component
public class AccountMapper {

	public AccountDTO account2AccountDTO(Account account) {
		AccountDTO accountDTO=new AccountDTO();
		accountDTO.setId(account.getId());
		accountDTO.setIban(account.getIban());
		accountDTO.setBallance(account.getBallance());
		accountDTO.setBank(account.getBank());
		return accountDTO;
	}
	
	
	public Account accountDTOtoAccount(AccountDTO accountDTO) {
		Account account=new Account();
		account.setId(accountDTO.getId());
		account.setIban(accountDTO.getIban());
		account.setBallance(accountDTO.getBallance());
		account.setBank(accountDTO.getBank());
		return account;
		
	}
	
	public List<AccountDTO> accountList2AccountDTOList(List<Account> accountList) {
		return accountList.stream().map(account -> account2AccountDTO(account)).collect(Collectors.toList());
	}
	
}
