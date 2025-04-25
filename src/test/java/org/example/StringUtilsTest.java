package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void reverse() {
        assertEquals("cbaa", StringUtils.reverse("abc"));
    }
}