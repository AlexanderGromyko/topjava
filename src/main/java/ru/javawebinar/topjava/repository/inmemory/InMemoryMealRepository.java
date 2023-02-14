package ru.javawebinar.topjava.repository.inmemory;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryMealRepository implements MealRepository {
    private final Map<Integer, Map<Integer, Meal>> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        // another part of meal with userId = 2
        MealsUtil.meals.forEach(m -> {
                    if (LocalDate.of(2023, 2, 1).compareTo(m.getDate()) > 0) {
                        save(m, 1);
                    } else save(m, 2);
                }
        );
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (!repository.containsKey(userId)) {
            repository.put(userId, new ConcurrentHashMap<>());
        }
        Map<Integer, Meal> usersMeals = repository.get(userId);
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            usersMeals.put(meal.getId(), meal);
            return meal;
        }
        Meal oldMeal = get(meal.getId(), userId);
        if (oldMeal != null) {
            // handle case: update, but not present in storage
            return usersMeals.computeIfPresent(meal.getId(), (id, old) -> meal);
        } else return null;
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
        Map<Integer, Meal> usersMeals = repository.get(userId);
        if (usersMeals == null) {
            return Collections.emptyList();
        }
        return usersMeals.values().stream()
                .sorted(Comparator.comparing(Meal::getDateTime).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Meal> getAllFiltered(int userId, LocalDate startDate, LocalDate endDate) {
        Map<Integer, Meal> usersMeals = repository.get(userId);
        if (usersMeals == null) {
            return Collections.emptyList();
        }
        return usersMeals.values().stream()
                .filter(m -> DateTimeUtil.isBetweenHalfOpen(m.getDate(), startDate, endDate))
                .sorted(Comparator.comparing(Meal::getDateTime).reversed())
                .collect(Collectors.toList());
    }
}