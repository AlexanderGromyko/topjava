package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMealStorage implements MealStorage {
    private final AtomicInteger atomicInteger = new AtomicInteger();
    protected Map<Integer, Meal> storage = new ConcurrentHashMap<>();

    private Integer getNewId() {
        return atomicInteger.incrementAndGet();
    }

    @Override
    public void save(Meal meal) {
        meal.setId(meal.getId() == null ? getNewId() : meal.getId());
        storage.put(meal.getId(), meal);
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