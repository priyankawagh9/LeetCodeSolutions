package level.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCalendarTest {

    @Test
    void bookTest1() {
        MyCalendar1 myCalendar1 = new MyCalendar1();
        Assertions.assertAll(
                ()-> assertTrue(myCalendar1.book(10, 15)),
                ()-> assertTrue(myCalendar1.book(5, 7)),
                ()-> assertTrue(myCalendar1.book(30, 50)),
                ()-> assertFalse(myCalendar1.book(6, 9)),
                ()-> assertTrue(myCalendar1.book(7, 10)));
    }

    @Test
    void bookTest2() {
        MyCalendar1 myCalendar1 = new MyCalendar1();
        Assertions.assertAll(
                () -> assertTrue(myCalendar1.book(10, 20)),
                () -> assertFalse(myCalendar1.book(15, 25)),
                () -> assertTrue(myCalendar1.book(20, 30)),
                () -> assertTrue(myCalendar1.book(2, 8)),
                () -> assertTrue(myCalendar1.book(40, 60)),
                () -> assertFalse(myCalendar1.book(50, 90)));
    }
}