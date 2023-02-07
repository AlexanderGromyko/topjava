package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface Storage {
    public Integer getNewId();

    public void addMeal(Meal meal);

    public void deleteMeal(Integer id);

    public List<Meal> getAllMeals();

    public Meal getMeal(Integer id);
}