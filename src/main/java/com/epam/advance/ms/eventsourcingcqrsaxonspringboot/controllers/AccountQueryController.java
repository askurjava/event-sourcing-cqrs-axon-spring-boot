package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.controllers;

import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.entities.AccountQueryEntity;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.services.queries.AccountQueryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Account query controller.
 */
@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Queries", description = "Account Query Events Endpoint", tags = "Account Queries")
public class AccountQueryController {

    private final AccountQueryService accountQueryService;

    /**
     * Instantiates a new Account query controller.
     *
     * @param accountQueryService the account query service
     */
    public AccountQueryController(AccountQueryService accountQueryService) {
        this.accountQueryService = accountQueryService;
    }

    /**
     * Gets account.
     *
     * @param accountNumber the account number
     * @return the account
     */
    @GetMapping("/{accountNumber}")
    public AccountQueryEntity getAccount(@PathVariable(value = "accountNumber") String accountNumber){
        return accountQueryService.getAccount(accountNumber);
    }

    /**
     * List events for account list.
     *
     * @param accountNumber the account number
     * @return the list
     */
    @GetMapping("/{accountNumber}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "accountNumber") String accountNumber){
        return accountQueryService.listEventsForAccount(accountNumber);
    }
    
}
