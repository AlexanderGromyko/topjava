package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );
        filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000).forEach(System.out::println);
        //filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000).forEach(System.out::println);
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with excess. Implement by cycles
        List<UserMealWithExcess> filteredList = new ArrayList<>();
        Map<LocalDate, Integer> dayCalories = new HashMap<>();
        meals.forEach(meal -> dayCalories.merge(meal.getDateTime().toLocalDate(), meal.getCalories(), (value, newValue) -> value + newValue)
        );
        meals.forEach(meal -> {
            if (timeInRange(meal.getTime(), startTime, endTime)) {
                filteredList.add(new UserMealWithExcess(meal, dayCalories.getOrDefault(meal.getDateTime().toLocalDate(), 0) > caloriesPerDay));
            }
        });
        return filteredList;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        return null;
    }

    private static boolean timeInRange(LocalTime mainTime, LocalTime startTime, LocalTime endTime) {
        return !mainTime.isBefore(startTime) && !mainTime.isAfter(endTime);
    }
}