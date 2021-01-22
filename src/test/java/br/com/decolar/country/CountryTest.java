package br.com.decolar.country;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void country__name_cannot_be_null_or_empty() {
        assertThrows(IllegalArgumentException.class, () -> new Country(null));
        assertThrows(IllegalArgumentException.class, () -> new Country(""));
    }

    @Test
    void country__must_be_created_with_a_valid_name() {
        var country = new Country("Brazil");
        assertEquals("Brazil", country.getName());
    }
}