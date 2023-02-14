package ru.javawebinar.topjava.repository.inmemory;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class InMemoryMealRepository implements MealRepository {
    private final Map<Integer, Map<Integer, Meal>> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.meals1.forEach(m -> save(m, 1));
        MealsUtil.meals2.forEach(m -> save(m, 2));
    }

    @Override
    public Meal save(Meal meal, int userId) {
        Map<Integer, Meal> usersMeals = repository.computeIfAbsent(userId, id -> new ConcurrentHashMap<>());
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            usersMeals.put(meal.getId(), meal);
            return meal;
        }
        return usersMeals.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
    }

    @Override
    public boolean delete(int id, int userId) {
        Map<Integer, Meal> usersMeals = repository.get(userId);
        return usersMeals != null && usersMeals.remove(id) != null;
    }

    @Override
    public Meal get(int id, int userId) {
        Map<Integer, Meal> usersMeals = repository.get(userId);
        return usersMeals == null ? null : usersMeals.get(id);
    }

    @Override
    public List<Meal> getAll(int userId) {
        return filterByPredicate(repository.get(userId),
                m -> true);
    }

    @Override
    public List<Meal> getAllFiltered(int userId, LocalDate startDate, LocalDate endDate) {
        return filterByPredicate(repository.get(userId),
                m -> DateTimeUtil.isBetweenHalfOpen(m.getDate(), startDate, endDate));
    }

    private static List<Meal> filterByPredicate(Map<Integer, Meal> usersMeals, Predicate<Meal> filter) {
        if (usersMeals == null) {
            return Collections.emptyList();
        }
        return usersMeals.values().stream()
                .filter(filter)
                .sorted(Comparator.comparing(Meal::getDateTime).reversed())
                .collect(Collectors.toList());
    }
}