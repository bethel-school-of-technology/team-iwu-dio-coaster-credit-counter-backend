package com.danharding.finalproject.credits;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "credits")
public class CreditsCoaster {
    public @Id @GeneratedValue long id;
    public @NotBlank String coaster;
    public @NotBlank String park;

    public CreditsCoaster (@NotBlank String coaster, @NotBlank String park) {
        this.coaster = coaster;
        this.park = park;
    }

    public long getId() {
        return id;
    }

    public long setId() {
        return id;
    }

    public String getCoaster() {
        return coaster;
    }

    public String setCoaster () {
        return coaster;
    }

    public String getPark() {
        return park;
    }

    public String setPark() {
        return park;
    }
}
