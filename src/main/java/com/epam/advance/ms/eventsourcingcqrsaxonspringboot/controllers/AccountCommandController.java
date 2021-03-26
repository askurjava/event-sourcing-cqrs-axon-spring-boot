package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.controllers;

import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands.AccountCreateDTO;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands.MoneyCreditDTO;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands.MoneyDebitDTO;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.services.commands.AccountCommandService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * The type Account command controller.
 */
@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Commands", description = "Account Commands Related Endpoints", tags = "Account Commands")
public class AccountCommandController {

    private final AccountCommandService accountCommandService;

    /**
     * Instantiates a new Account command controller.
     *
     * @param accountCommandService the account command service
     */
    public AccountCommandController(final AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }

    /**
     * Create account completable future.
     *
     * @param accountCreateDTO the account create dto
     * @return the completable future
     */
    @PostMapping
    public CompletableFuture<String> createAccount(@RequestBody final AccountCreateDTO accountCreateDTO){
        return accountCommandService.createAccount(accountCreateDTO);
    }

    /**
     * Credit money to account completable future.
     *
     * @param accountNumber  the account number
     * @param moneyCreditDTO the money credit dto
     * @return the completable future
     */
    @PutMapping(value = "/credits/{accountNumber}")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountNumber") final String accountNumber,
                                                          @RequestBody final MoneyCreditDTO moneyCreditDTO){
        return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDTO);
    }

    /**
     * Debit money from account completable future.
     *
     * @param accountNumber the account number
     * @param moneyDebitDTO the money debit dto
     * @return the completable future
     */
    @PutMapping(value = "/debits/{accountNumber}")
    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountNumber") final String accountNumber,
                                                           @RequestBody final MoneyDebitDTO moneyDebitDTO){
        return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
    }
}
