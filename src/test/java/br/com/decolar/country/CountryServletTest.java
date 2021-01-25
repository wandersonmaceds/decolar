package br.com.decolar.country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

class CountryServletTest {

    @Mock
    private CountryDAO countryDAO;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher requestDispatcher;

    private CountryServlet countryServlet;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        this.countryServlet = new CountryServlet(countryDAO);
    }

    @Test
    void country_servlet__must_create_a_country() throws ServletException, IOException {
        Country country = new Country("Brazil");

        when(request.getParameter("name")).thenReturn(country.getName());
        when(request.getRequestDispatcher("/WEB-INF/views/country/created.jsp")).thenReturn(requestDispatcher);

        this.countryServlet.doPost(request, response);

        verify(countryDAO, Mockito.times(1)).save(country);
        verify(request).setAttribute("countryName", country.getName());
    }

}