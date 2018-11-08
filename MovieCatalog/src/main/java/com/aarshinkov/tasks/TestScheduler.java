package com.aarshinkov.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("testScheduler")
public class TestScheduler {

    private Logger log = LoggerFactory.getLogger(getClass());

    public void testTask() {
        log.debug("testTask begin --");
        log.debug("End testTask");
    }
}
