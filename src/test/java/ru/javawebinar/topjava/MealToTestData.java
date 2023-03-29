package ru.javawebinar.topjava;

import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.List;

import static ru.javawebinar.topjava.MealTestData.meals;

public class MealToTestData {

    public static final List<MealTo> sortedMealToList =  MealsUtil.getFilteredTos(meals, SecurityUtil.authUserCaloriesPerDay(), null, null);

    public static final MatcherFactory.Matcher<MealTo> mealToMatcher = MatcherFactory.usingIgnoringFieldsComparator(MealTo.class);
}
