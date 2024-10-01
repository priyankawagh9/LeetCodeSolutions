package level.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalendarTwoTest {

    MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
    @BeforeEach
    void setUp() {
    }

    @Test
    void book() {
        Assertions.assertAll(
                () -> assertTrue(myCalendarTwo.book(10,20)),
                () -> assertTrue(myCalendarTwo.book(50,60)),
                () -> assertTrue(myCalendarTwo.book(10,40)),
                () -> assertFalse(myCalendarTwo.book(5,15)),
                () -> assertTrue(myCalendarTwo.book(5,10)),
                () -> assertFalse(myCalendarTwo.book(25,55))
        );
    }
}