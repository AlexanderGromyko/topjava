package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.storage.InMemoryStorage;
import ru.javawebinar.topjava.storage.Storage;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final int CALORIES_PER_DAY = 2000;
    private static final LocalTime START_TIME = LocalTime.MIN;
    private static final LocalTime END_TIME = LocalTime.MAX;
    private static final Logger log = getLogger(MealServlet.class);
    private Storage storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Integer id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");
        if (action == null) {
            log.debug("redirect to meals");
            List<MealTo> mealsTo = MealsUtil.filteredByStreams(storage.getAllMeals(), START_TIME, END_TIME, CALORIES_PER_DAY);
            request.setAttribute("meals", mealsTo);
            request.getRequestDispatcher("/WEB-INF/meals.jsp").forward(request, response);
            return;
        }
        Meal m;
        switch (action) {
            case "delete":
                storage.deleteMeal(id);
                response.sendRedirect("meals");
                return;
            case "add":
                m = new Meal(storage.getNewId(), LocalDateTime.now().withSecond(0).withNano(0), "", 0);
                break;
            case "update":
                m = storage.getMeal(id);
                break;
            default:
                throw new IllegalArgumentException("Actioon " + action + "is illegal");
        }
        request.setAttribute("meal", m);
        request.getRequestDispatcher(("WEB-INF/update.jsp")).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("DateTime"));
        String description = request.getParameter("Description");
        int calories = Integer.parseInt(request.getParameter("Calories"));
        storage.addMeal(new Meal(id, dateTime, description, calories));
        response.sendRedirect("meals");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = new InMemoryStorage();
        MealsUtil.initStorage(storage);
    }
}