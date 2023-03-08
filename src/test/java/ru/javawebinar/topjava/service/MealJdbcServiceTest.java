package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"jdbc", "postgres"})
public class MealJdbcServiceTest extends AbstractMealServiceTest {
}