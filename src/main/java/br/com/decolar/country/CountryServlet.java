package br.com.decolar.country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/country")
public class CountryServlet extends HttpServlet {

    private static CountryDAO countryDAO;

    @Deprecated
    CountryServlet() {
        CountryServlet.countryDAO = new CountryDAO();
    }

    CountryServlet(CountryDAO countryDAO) {
        CountryServlet.countryDAO = countryDAO;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/country/form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countryName = req.getParameter("name");
        Country country = new Country(countryName);
        countryDAO.save(country);
        req.setAttribute("countryName", countryName);
        req.getRequestDispatcher("/WEB-INF/views/country/created.jsp").forward(req, resp);
    }
}
