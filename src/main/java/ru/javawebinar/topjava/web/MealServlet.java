package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.storage.InMemoryMealStorage;
import ru.javawebinar.topjava.storage.MealStorage;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final int CALORIES_PER_DAY = 2000;
    private static final Logger log = getLogger(MealServlet.class);
    private MealStorage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = new InMemoryMealStorage();
        InMemoryMealStorage.initStorage(storage);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            log.debug("redirect to meals");
            List<MealTo> mealsTo = MealsUtil.filteredByStreams(storage.getAll(), LocalTime.MIN, LocalTime.MAX, CALORIES_PER_DAY);
            request.setAttribute("meals", mealsTo);
            request.getRequestDispatcher("/WEB-INF/meals.jsp").forward(request, response);
            return;
        }
        Meal m;
        switch (action) {
            case "delete": {
                String idParameter = request.getParameter("id");
                Integer id = idParameter == null ? null : Integer.parseInt(idParameter);
                log.debug("redirect to delete" + id);
                storage.delete(id);
                response.sendRedirect("meals");
                return;
            }
            case "add": {
                log.debug("redirect to add");
                m = new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 0);
                break;
            }
            case "update": {
                String idParameter = request.getParameter("id");
                Integer id = idParameter == null ? null : Integer.parseInt(idParameter);
                log.debug("redirect to update" + id);
                m = storage.get(id);
                break;
            }
            default: {
                log.debug("redirect to meals (no action)");
                response.sendRedirect("meals");
                return;
            }
        }
        request.setAttribute("meal", m);
        request.setAttribute("action", action);
        request.getRequestDispatcher("WEB-INF/updateMeal.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String idParameter = request.getParameter("id");
        Integer id = idParameter.isEmpty() ? null : Integer.parseInt(idParameter);
        LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("DateTime"));
        String description = request.getParameter("Description");
        int calories = Integer.parseInt(request.getParameter("Calories"));
        log.debug("save of " + id + " " + dateTime + " " + description + " " + calories);
        if (request.getParameter("action").equals("add")) {
            storage.add(new Meal(id, dateTime, description, calories));
        } else storage.update(new Meal(id, dateTime, description, calories));
        response.sendRedirect("meals");
    }
}