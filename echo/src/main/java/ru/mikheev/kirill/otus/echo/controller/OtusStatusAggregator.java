package ru.mikheev.kirill.otus.echo.controller;

import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.actuate.health.StatusAggregator;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component()
public class OtusStatusAggregator implements StatusAggregator {

    private static final Status OK_STATUS = new Status("OK");

    @Override
    public Status getAggregateStatus(Set<Status> statuses) {
        if (statuses.stream().allMatch(status -> Status.UP.equals(status))) {
            return OK_STATUS;
        } else {
            return Status.DOWN;
        }
    }
}
