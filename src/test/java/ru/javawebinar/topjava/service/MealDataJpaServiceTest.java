package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"datajpa", "postgres"})
public class MealDataJpaServiceTest extends AbstractMealServiceTest {
}