package level.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AllOneTest {
    AllOne allOne = new AllOne();
    @BeforeEach
    void setUp() {
    }

    @Test
    void allOneTests1() {
        allOne.inc("hello");
        allOne.inc("hello");
        Assertions.assertEquals("hello",allOne.getMaxKey());
        Assertions.assertEquals("hello", allOne.getMinKey());
        allOne.inc("leet");
        Assertions.assertEquals("hello",allOne.getMaxKey());
        Assertions.assertEquals("leet", allOne.getMinKey());
    }

    @Test
    void allOneTests2() {
        allOne.inc( "a");
        allOne.inc( "b");
        allOne.inc( "b");
        allOne.inc( "b");
        allOne.inc( "b");
        allOne.dec("b");
        allOne.dec("b");
        Assertions.assertEquals("b",allOne.getMaxKey());
        Assertions.assertEquals("a", allOne.getMinKey());
    }
}