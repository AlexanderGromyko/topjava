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
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

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
        Meal meal = service.get(userMeal1.getId(), USER_ID);
        assertMatch(meal, userMeal1);
    }

    @Test
    public void delete() {
        service.delete(userMeal2.getId(), USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(userMeal2.getId(), USER_ID));
    }

    @Test
    public void getBetweenInclusive() {
        List<Meal> all = service.getBetweenInclusive(startDate, endDate, USER_ID);
        assertMatch(all, userMeal3, userMeal2);
    }

    @Test
    public void getAll() {
        List<Meal> all = service.getAll(ADMIN_ID);
        assertMatch(all, adminMeal3, adminMeal2, adminMeal1);
    }

    @Test
    public void update() {
        Meal updated = getUpdatedMealBelongsToUser();
        service.update(updated, USER_ID);
        assertMatch(service.get(updated.getId(), USER_ID), getUpdatedMealBelongsToUser());
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

    @Test
    public void getForWrongUser() {
        assertThrows(NotFoundException.class, () -> service.get(userMeal1.getId(), ADMIN_ID));
    }

    @Test
    public void deleteForWrongUser() {
        assertThrows(NotFoundException.class, () -> service.delete(userMeal2.getId(), ADMIN_ID));
    }

    @Test
    public void updateForWrongUser() {
        assertThrows(NotFoundException.class, () -> service.update(userMeal1, ADMIN_ID));
    }

    @Test
    public void duplicateMealCreate() {
        Meal newMeal = getNew();
        newMeal.setDateTime(userMeal1.getDateTime());
        assertThrows(DataAccessException.class, () -> service.create(newMeal, USER_ID));
    }

    @Test
    public void getNotExistsMeal() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_EXISTS_MEAL_ID, USER_ID));
    }

    @Test
    public void deleteNotExistsMeal() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_EXISTS_MEAL_ID, USER_ID));
    }

    @Test
    public void getBetweenInclusiveEmptyBoarders() {
        List<Meal> all = service.getBetweenInclusive(null, null, ADMIN_ID);
        assertMatch(all, adminMeal3, adminMeal2, adminMeal1);
    }
}