package com.loanchocon;

// import org.junit.jupiter.api.Test;

public class FailExampleTest {
    // @Test
    public void testAlwaysFail() {
        org.junit.jupiter.api.Assertions.fail("Test này luôn luôn fail để kiểm tra CI/CD");
    }
}