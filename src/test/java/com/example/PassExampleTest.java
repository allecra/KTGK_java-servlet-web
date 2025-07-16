package com.example;

import org.junit.jupiter.api.Test;

public class PassExampleTest {
    @Test
    public void testAlwaysPass() {
        org.junit.jupiter.api.Assertions.assertTrue(true, "Test này luôn luôn pass");
    }
}