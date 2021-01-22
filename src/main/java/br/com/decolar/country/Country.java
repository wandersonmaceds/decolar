package br.com.decolar.country;

import java.util.Objects;

class Country {

    private String name;

    Country(String name) {
        setName(name);
    }

    private void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Country name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return getName().equals(country.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
