package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.entities.repositories;

import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.entities.AccountQueryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Account repository.
 */
@Repository
public interface AccountRepository extends CrudRepository<AccountQueryEntity, String> {
}
