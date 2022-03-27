package com.application.modul3.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.account.dto.AccountDTO;
import com.application.modul3.account.mapper.AccountMapper;

@RestController
@RequestMapping("/accounts")
public class AccountController {
@Autowired
AccountService accountService;
@Autowired
AccountMapper accountMapper;


@PostMapping("/add/{companyID}")
public ResponseEntity<Object> createAccountWithCompany(@PathVariable Integer companyId, @RequestBody AccountDTO accountDTO) {
	
	Account createAccount=accountService.createAccount(accountMapper.accountDTOtoAccount(accountDTO), accountDTO.getCompanyIds());
	return accountMapper.account2AccountDTO(createAccount);
}

@DeleteMapping("/{id}")
public void deleteAccountById(@PathVariable Integer id) {
	accountService.deleteAccount(id);
}
}
