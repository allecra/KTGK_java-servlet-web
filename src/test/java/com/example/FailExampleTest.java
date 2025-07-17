package com.example;

import org.junit.jupiter.api.Test;

public class FailExampleTest {
    // @Test
    public void testAlwaysFail() {
        org.junit.jupiter.api.Assertions.fail("win nè");
    }
}