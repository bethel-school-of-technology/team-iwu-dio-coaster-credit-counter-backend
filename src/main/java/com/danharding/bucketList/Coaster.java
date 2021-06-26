package com.danharding.bucketList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "bucketList")
public class Coaster {
    public @Id @GeneratedValue long id;
    public @NotBlank String coaster;
    public @NotBlank String park;

    public Coaster (@NotBlank String coaster, @NotBlank String park) {
        this.coaster = coaster;
        this.park = park;
    }

    public long getId() {
        return id;
    }

    public String getCoaster() {
        return coaster;
    }

    public String getPark() {
        return park;
    }
}
