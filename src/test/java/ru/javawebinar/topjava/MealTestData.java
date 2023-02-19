package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;

import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_ID = START_SEQ;

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.of(2023, 2, 20, 10, 0), "Завтрак", 1500);
    }

}
