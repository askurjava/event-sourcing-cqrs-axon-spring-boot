package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.services.commands;

import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.commands.CreateAccountCommand;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.commands.CreditMoneyCommand;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.commands.DebitMoneyCommand;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands.AccountCreateDTO;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands.MoneyCreditDTO;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands.MoneyDebitDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * The type Account command service.
 */
@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    private final CommandGateway commandGateway;

    /**
     * Instantiates a new Account command service.
     *
     * @param commandGateway the command gateway
     */
    public AccountCommandServiceImpl(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createAccount(final AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccountCommand("ACC:" + UUID.randomUUID().toString(), accountCreateDTO.getStartingBalance(), accountCreateDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(final String accountNumber, final MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditMoneyCommand(accountNumber, moneyCreditDTO.getCreditAmount(), moneyCreditDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(final String accountNumber, final MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitMoneyCommand(accountNumber, moneyDebitDTO.getDebitAmount(), moneyDebitDTO.getCurrency()));
    }
}
