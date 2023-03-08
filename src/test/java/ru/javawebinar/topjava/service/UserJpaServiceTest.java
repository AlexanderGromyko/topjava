package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"jpa", "postgres"})
public class UserJpaServiceTest extends AbstractUserServiceTest {
}