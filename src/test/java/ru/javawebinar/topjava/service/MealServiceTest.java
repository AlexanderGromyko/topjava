package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static ru.javawebinar.topjava.MealTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {
    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal meal = service.get(user_meal1.getId(), USER_ID);
        assertMatch(meal, user_meal1);
    }

    @Test
    public void delete() {
        service.delete(user_meal2.getId(), USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(user_meal2.getId(), USER_ID));
    }

    @Test
    public void getBetweenInclusive() {
        List<Meal> all = service.getBetweenInclusive(startDate, endDate, USER_ID);
        assertMatch(all, user_meal3, user_meal2);
    }

    public void getAll() {
        List<Meal> all = service.getAll(ADMIN_ID);
        assertMatch(all, admin_meal3, admin_meal2, admin_meal1);
    }

    @Test
    public void update() {
        Meal created = getNew();
        created.setId(user_meal1.getId());
        Meal newMeal = getNew();
        newMeal.setId(user_meal1.getId());
        service.update(created, USER_ID);
        assertMatch(newMeal, service.get(created.getId(), USER_ID));
    }

    @Test
    public void create() {
        Meal created = service.create(getNew(), USER_ID);
        Integer newId = created.getId();
        Meal newMeal = getNew();
        newMeal.setId(newId);
        assertMatch(created, newMeal);
        assertMatch(service.get(newId, USER_ID), newMeal);
    }

    public void getForWrongUser() {
        assertThrows(NotFoundException.class, () -> service.get(user_meal1.getId(), ADMIN_ID));
    }

    @Test
    public void deleteForWrongUser() {
        assertThrows(NotFoundException.class, () -> service.delete(user_meal2.getId(), ADMIN_ID));
    }

    @Test
    public void updateForWrongUser() {
        assertThrows(NotFoundException.class, () -> service.update(user_meal1, ADMIN_ID));
    }

    @Test
    public void duplicateMealCreate() {
        Meal newMeal = getNew();
        newMeal.setDateTime(user_meal1.getDateTime());
        assertThrows(DataAccessException.class, () -> service.create(newMeal, USER_ID));
    }
}