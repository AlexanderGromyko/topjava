package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final Meal meal1 = new Meal(100003, LocalDateTime.of(2023, 2, 19, 9, 30), "Завтрак", 1000);
    public static final Meal meal2 = new Meal(100004, LocalDateTime.of(2023, 2, 19, 14, 15), "Обед", 1200);
    public static final Meal meal3 = new Meal(100005, LocalDateTime.of(2023, 2, 19, 18, 50), "Ужин", 400);
    public static final Meal meal4 = new Meal(100006, LocalDateTime.of(2023, 2, 20, 10, 0), "Завтрак", 700);
    public static final Meal meal5 = new Meal(100007, LocalDateTime.of(2023, 2, 20, 13, 0), "Обед", 1500);
    public static final Meal meal6 = new Meal(100008, LocalDateTime.of(2023, 2, 20, 19, 0), "Ужин", 150);
    public static final LocalDate startDate = LocalDate.of(2023, 2, 19);
    public static final LocalDate endDate = LocalDate.of(2023, 2, 19);

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.of(2023, 2, 21, 10, 0), "Завтрак", 1500);
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields("registered", "roles").isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparatorIgnoringFields("registered", "roles").isEqualTo(expected);
    }
}