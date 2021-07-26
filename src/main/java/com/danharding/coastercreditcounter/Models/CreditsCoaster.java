package com.danharding.coastercreditcounter.Models;

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

    public CreditsCoaster() {
        
    }

    public CreditsCoaster (@NotBlank String coaster, @NotBlank String park) {
        this.coaster = coaster;
        this.park = park;
    }

    public long getId() {
        return id;
    }

    public String getCoaster() {
        return coaster;
    }

    public void setCoaster (String coaster) {
        this.coaster = coaster;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }
}
