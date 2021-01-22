package br.com.decolar.country;

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
}
