package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"datajpa", "postgres"})
public class UserDataJpaServiceTest extends AbstractUserServiceTest {
}