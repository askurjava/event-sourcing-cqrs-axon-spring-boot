package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.events;

import com.epam.advance.ms.eventsourcingcqrsaxonspringboot.aggregates.Status;

public class AccountActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
