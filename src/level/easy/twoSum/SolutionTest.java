package level.easy.twoSum;

import org.junit.jupiter.api.Assertions;

class SolutionTest {

    Solution s = new Solution();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void twoSum1() {
        int[] expected = {1,2};
        int[] response = s.twoSum(new int[]{3,2,4}, 6);
        Assertions.assertArrayEquals(expected,response);
    }

    @org.junit.jupiter.api.Test
    void twoSum2() {
        int[] expected = {0,1};
        int[] response = s.twoSum(new int[]{3,3}, 6);
        Assertions.assertArrayEquals(expected,response);
    }

    @org.junit.jupiter.api.Test
    void twoSum3() {
        int[] expected = {0,1};
        int[] response = s.twoSum(new int[]{2,7,11,15}, 9);
        Assertions.assertArrayEquals(expected,response);
    }
}