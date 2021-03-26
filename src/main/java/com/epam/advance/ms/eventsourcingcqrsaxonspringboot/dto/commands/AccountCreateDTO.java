package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateDTO {
    private double startingBalance;
    private String currency;
}
