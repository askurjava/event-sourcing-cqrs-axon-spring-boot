package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.services.queries;

import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.entities.AccountQueryEntity;
import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.entities.repositories.AccountRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Account query service.
 */
@Service
public class AccountQueryServiceImpl implements AccountQueryService {

    private final EventStore eventStore;

//    private final QueryGateway queryGateway;

    private final AccountRepository accountRepository;

    /**
     * Instantiates a new Account query service.
     *
     * @param eventStore        the event store
     * @param accountRepository the account repository
     */
    public AccountQueryServiceImpl(final EventStore eventStore,
                                   final AccountRepository accountRepository) {
        this.eventStore = eventStore;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Object> listEventsForAccount(final String accountNumber) {
        return eventStore.readEvents(accountNumber)
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }

    @Override
    public AccountQueryEntity getAccount(String accountNumber) {
        return accountRepository.findById(accountNumber).get();
    }
}
