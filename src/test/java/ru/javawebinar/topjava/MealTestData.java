package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final Meal userMeal1 = new Meal(START_SEQ + 3, LocalDateTime.of(2023, 2, 18, 9, 30), "Завтрак", 1000);
    public static final Meal userMeal2 = new Meal(START_SEQ + 4, LocalDateTime.of(2023, 2, 19, 14, 15), "Обед", 1200);
    public static final Meal userMeal3 = new Meal(START_SEQ + 5, LocalDateTime.of(2023, 2, 19, 18, 50), "Ужин", 400);
    public static final Meal adminMeal1 = new Meal(START_SEQ + 6, LocalDateTime.of(2023, 2, 20, 10, 0), "Завтрак", 700);
    public static final Meal adminMeal2 = new Meal(START_SEQ + 7, LocalDateTime.of(2023, 2, 20, 13, 0), "Обед", 1500);
    public static final Meal adminMeal3 = new Meal(START_SEQ + 8, LocalDateTime.of(2023, 2, 20, 19, 0), "Ужин", 150);
    public static final LocalDate START_DATE = LocalDate.of(2023, 2, 19);
    public static final LocalDate END_DATE = LocalDate.of(2023, 2, 19);
    public static final int NOT_EXISTS_MEAL_ID = START_SEQ + 1000;

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.of(2023, 2, 21, 10, 0), "Завтрак", 1500);
    }

    public static Meal getUpdatedMealBelongsToUser() {
        Meal updated = new Meal(userMeal1);
        updated.setDateTime(LocalDateTime.of(2111, 1, 1, 1, 1));
        updated.setDescription("UpdatedName");
        updated.setCalories(999);
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}