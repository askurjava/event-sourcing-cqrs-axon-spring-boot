package com.epam.advance.ms.eventsourcingcqrsaxonspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountQueryEntity {
    @Id
    private String id;
    private double accountBalance;
    private String currency;
    private String status;
}
