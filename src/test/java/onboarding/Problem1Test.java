package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {
    Problem1 problem1;

    @BeforeEach
    void setUp() {
        problem1 = new Problem1();
    }

    @Test
    @DisplayName("결과가 잘 나오는지 확인")
    void solutionTest(){
        assertEquals(0, problem1.solution(new ArrayList<>(List.of(97, 98)), new ArrayList<>(List.of(197, 198))));
        assertEquals(1, problem1.solution(new ArrayList<>(List.of(131, 132)), new ArrayList<>(List.of(211, 212))));
        assertEquals(-1, problem1.solution(new ArrayList<>(List.of(99, 102)), new ArrayList<>(List.of(211, 212))));
    }
}