package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.web.meal.MealRestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@WebServlet
public class MealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);
    private ConfigurableApplicationContext appCtx;

    @Override
    public void init() {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
    }

    @Override
    public void destroy() {
        appCtx.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        Meal meal = new Meal(id.isEmpty() ? null : Integer.valueOf(id),
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));
        log.info(meal.isNew() ? "Create {}" : "Update {}", meal);
        MealRestController mealRestController = appCtx.getBean(MealRestController.class);
        if (meal.isNew()) {
            mealRestController.create(meal);
        } else mealRestController.update(meal, meal.getId());
        response.sendRedirect("meals");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        MealRestController mealRestController = appCtx.getBean(MealRestController.class);

        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                log.info("Delete id={}", id);
                mealRestController.delete(id);
                response.sendRedirect("meals");
                break;
            case "create":
            case "update":
                final Meal meal = "create".equals(action) ?
                        new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 1000) :
                        mealRestController.get(getId(request));
                request.setAttribute("meal", meal);
                request.getRequestDispatcher("/mealForm.jsp").forward(request, response);
                break;
            case "all":
            default:
                log.info("getAll");
                String startDateParameter = request.getParameter("startDate");
                LocalDate startDate = startDateParameter != null && !startDateParameter.isEmpty() ? LocalDate.parse(startDateParameter) : LocalDate.MIN;
                String startTimeParameter = request.getParameter("startTime");
                LocalTime startTime = startTimeParameter != null && !startTimeParameter.isEmpty() ? LocalTime.parse(startTimeParameter) : LocalTime.MIN;
                String endDateParameter = request.getParameter("endDate");
                LocalDate endDate = endDateParameter != null && !endDateParameter.isEmpty() ? LocalDate.parse(endDateParameter) : LocalDate.MAX;
                String endTimeParameter = request.getParameter("endTime");
                LocalTime endTime = endTimeParameter != null && !endTimeParameter.isEmpty() ? LocalTime.parse(endTimeParameter) : LocalTime.MAX;
                request.setAttribute("meals", mealRestController.getAll(startDate, startTime, endDate, endTime));
                request.getRequestDispatcher("/meals.jsp").forward(request, response);
                break;
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
