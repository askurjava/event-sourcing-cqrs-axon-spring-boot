package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.services.queries;

import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.entities.AccountQueryEntity;

import java.util.List;

/**
 * The interface Account query service.
 */
public interface AccountQueryService {
    /**
     * List events for account list.
     *
     * @param accountNumber the account number
     * @return the list
     */
    List<Object> listEventsForAccount(final String accountNumber);

    /**
     * Gets account.
     *
     * @param accountNumber the account number
     * @return the account
     */
    AccountQueryEntity getAccount(final String accountNumber);
}
