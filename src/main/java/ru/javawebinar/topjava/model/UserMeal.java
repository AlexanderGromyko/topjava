package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class UserMeal implements Comparable<UserMeal>{
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    public UserMeal(LocalDateTime dateTime, String description, int calories) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, calories, description);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append(dateTime.toString());
        str.append(" Calories: " + calories);
        str.append(" Description: " + description);
        return str.toString();
    }

    @Override
    public int compareTo(UserMeal userMeal) {
        if (!dateTime.equals(userMeal.dateTime)) {
            return dateTime.compareTo(userMeal.dateTime);
        }
        if (calories != userMeal.calories) {
            return calories - userMeal.calories;
        }
        return description.compareTo(description);
    }
}
