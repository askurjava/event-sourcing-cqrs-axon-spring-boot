package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.dto.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyCreditDTO {
    private double creditAmount;
    private String currency;
}
