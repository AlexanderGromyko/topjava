package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryStorage implements Storage {
    private final AtomicInteger atomicInteger = new AtomicInteger();
    protected Map<Integer,Meal> storage = new ConcurrentHashMap<>();

    public Integer getNewId() {
        return atomicInteger.incrementAndGet();
    }

    @Override
    public void addMeal(Meal meal) {
        storage.put(meal.getId(), meal);
    }

    @Override
    public void deleteMeal(Integer id) {
        storage.remove(id);
    }

    @Override
    public List<Meal> getAllMeals() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Meal getMeal(Integer id) {
        return storage.get(id);
    }
}