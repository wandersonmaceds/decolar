package br.com.decolar.country;

import java.util.*;
import java.util.stream.Collectors;

class CountryDAO {
    private final Set<Country> dao;

    CountryDAO() {
        this.dao = new HashSet<>();
    }

    void save(Country country) {
        if(country == null) {
            throw new IllegalArgumentException("Country cannot be empty");
        }
        if(!this.dao.add(country)) {
          throw new RuntimeException("Country already on registers");
        }
    }

    public List<Country> list() {
        return this.dao
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }
}


