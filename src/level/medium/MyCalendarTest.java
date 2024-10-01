package level.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCalendarTest {

    @Test
    void bookTest1() {
        MyCalendarI myCalendarI = new MyCalendarI();
        Assertions.assertAll(
                ()-> assertTrue(myCalendarI.book(10, 15)),
                ()-> assertTrue(myCalendarI.book(5, 7)),
                ()-> assertTrue(myCalendarI.book(30, 50)),
                ()-> assertFalse(myCalendarI.book(6, 9)),
                ()-> assertTrue(myCalendarI.book(7, 10)));
    }

    @Test
    void bookTest2() {
        MyCalendarI myCalendarI = new MyCalendarI();
        Assertions.assertAll(
                () -> assertTrue(myCalendarI.book(10, 20)),
                () -> assertFalse(myCalendarI.book(15, 25)),
                () -> assertTrue(myCalendarI.book(20, 30)),
                () -> assertTrue(myCalendarI.book(2, 8)),
                () -> assertTrue(myCalendarI.book(40, 60)),
                () -> assertFalse(myCalendarI.book(50, 90)));
    }
}