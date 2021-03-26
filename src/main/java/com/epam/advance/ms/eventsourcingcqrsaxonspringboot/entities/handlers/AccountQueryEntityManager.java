package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.entities.handlers;

import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.aggregates.AccountAggregate;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.entities.AccountQueryEntity;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.entities.repositories.AccountRepository;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.events.BaseEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The type Account query entity manager.
 */
@Component
public class AccountQueryEntityManager {

    private final AccountRepository accountRepository;

    private final EventSourcingRepository<AccountAggregate> accountAggregateEventSourcingRepository;

    /**
     * Instantiates a new Account query entity manager.
     *
     * @param accountRepository                       the account repository
     * @param accountAggregateEventSourcingRepository the account aggregate event sourcing repository
     */
    public AccountQueryEntityManager(final AccountRepository accountRepository,
                                     @Qualifier("accountAggregateEventSourcingRepository") final EventSourcingRepository<AccountAggregate> accountAggregateEventSourcingRepository) {
        this.accountRepository = accountRepository;
        this.accountAggregateEventSourcingRepository = accountAggregateEventSourcingRepository;
    }

    /**
     * On.
     *
     * @param event the event
     */
    @EventSourcingHandler
    void on(BaseEvent event) {
        persistAccount(buildQueryAccount(getAccountFromEvent(event)));
    }


    private AccountAggregate getAccountFromEvent(BaseEvent event) {
        return accountAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
    }

    private AccountQueryEntity findExistingOrCreateQueryAccount(String id) {
        return accountRepository.findById(id).isPresent() ? accountRepository.findById(id).get() : new AccountQueryEntity();
    }

    private AccountQueryEntity buildQueryAccount(AccountAggregate accountAggregate) {
        AccountQueryEntity accountQueryEntity = findExistingOrCreateQueryAccount(accountAggregate.getId());

        accountQueryEntity.setId(accountAggregate.getId());
        accountQueryEntity.setAccountBalance(accountAggregate.getAccountBalance());
        accountQueryEntity.setCurrency(accountAggregate.getCurrency());
        accountQueryEntity.setStatus(accountAggregate.getStatus());

        return accountQueryEntity;
    }

    private void persistAccount(AccountQueryEntity accountQueryEntity) {
        accountRepository.save(accountQueryEntity);
    }
}
