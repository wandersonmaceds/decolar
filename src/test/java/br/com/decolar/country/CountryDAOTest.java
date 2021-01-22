package br.com.decolar.country;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryDAOTest {

    @Test
    void country_dao__must_save_a_valid_country() {
        Country country = new Country("Brazil");
        CountryDAO countryDAO = new CountryDAO();
        countryDAO.save(country);

        assertEquals(1, countryDAO.list().size());
        assertEquals(country, countryDAO.list().get(0));
    }

    @Test
    void country_dao__must_save_many_valid_countries() {
        Country brazil = new Country("Brazil");
        Country china = new Country("China");

        CountryDAO countryDAO = new CountryDAO();
        countryDAO.save(brazil);
        countryDAO.save(china);

        List<Country> countries = countryDAO.list();

        assertEquals(2, countries.size());
        assertTrue(countries.contains(brazil));
        assertTrue(countries.contains(china));
    }

    @Test
    void country_dao__must_not_save_duplicated_countries() {
        Country brazil = new Country("Brazil");
        Country brasil = new Country("Brazil");

        CountryDAO countryDAO = new CountryDAO();
        countryDAO.save(brazil);

        assertEquals(1, countryDAO.list().size());
        assertEquals(brazil, countryDAO.list().get(0));
        assertThrows(RuntimeException.class, () -> countryDAO.save(brasil));
    }

    @Test
    void country_dao__must_not_save_invalid_country() {
        assertThrows(IllegalArgumentException.class, () -> new CountryDAO().save(null));
    }
}