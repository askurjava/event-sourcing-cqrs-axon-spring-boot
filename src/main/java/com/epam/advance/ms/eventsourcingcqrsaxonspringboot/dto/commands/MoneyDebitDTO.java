package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyDebitDTO {
    private double debitAmount;
    private String currency;
}
