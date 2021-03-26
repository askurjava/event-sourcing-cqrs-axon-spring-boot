package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.services.commands;

import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands.AccountCreateDTO;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands.MoneyCreditDTO;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

/**
 * The interface Account command service.
 */
public interface AccountCommandService {

    /**
     * Create account completable future.
     *
     * @param accountCreateDTO the account create dto
     * @return the completable future
     */
    CompletableFuture<String> createAccount(final AccountCreateDTO accountCreateDTO);

    /**
     * Credit money to account completable future.
     *
     * @param accountNumber  the account number
     * @param moneyCreditDTO the money credit dto
     * @return the completable future
     */
    CompletableFuture<String> creditMoneyToAccount(final String accountNumber, final MoneyCreditDTO moneyCreditDTO);

    /**
     * Debit money from account completable future.
     *
     * @param accountNumber the account number
     * @param moneyDebitDTO the money debit dto
     * @return the completable future
     */
    CompletableFuture<String> debitMoneyFromAccount(final String accountNumber, final MoneyDebitDTO moneyDebitDTO);
}
