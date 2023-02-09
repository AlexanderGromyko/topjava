package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMealStorage implements MealStorage {
    private final AtomicInteger counter = new AtomicInteger();
    private Map<Integer, Meal> storage = new ConcurrentHashMap<>();

    private int getNewId() {
        return counter.incrementAndGet();
    }

    public static void initStorage(MealStorage storage) {
        Arrays.asList(
                        new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                        new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                        new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                        new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                        new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                        new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                        new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410),
                        new Meal(LocalDateTime.of(2023, Month.FEBRUARY, 1, 9, 0), "Завтрак", 300),
                        new Meal(LocalDateTime.of(2023, Month.FEBRUARY, 1, 11, 0), "Второй завтрак", 250),
                        new Meal(LocalDateTime.of(2023, Month.FEBRUARY, 1, 14, 30), "Обед", 1000),
                        new Meal(LocalDateTime.of(2023, Month.FEBRUARY, 1, 19, 15), "Ужин", 850))
                .forEach(storage::add);
    }

    @Override
    public Meal add(Meal meal) {
        meal.setId(getNewId());
        storage.put(meal.getId(), meal);
        return meal;
    }

    @Override
    public Meal update(Meal meal) {
        storage.put(meal.getId(), meal);
        return meal;
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Meal get(int id) {
        return storage.get(id);
    }
}