package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {
    @Nested
    class ErrorTest{
        @Test
        public void firstPageTest(){
            List<Integer> pobi = List.of(1, 2);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        public void endPageTest(){
            List<Integer> pobi = List.of(11, 12);
            List<Integer> crong = List.of(399, 400);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        public void pageSizeIsNotTwoTest(){
            List<Integer> pobi = List.of(11, 12,13);
            List<Integer> crong = List.of(11,13,13);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }
    @Nested
    class DrawTest{
        @Test
        public void samePageTest(){
            List<Integer> pobi = List.of(11, 12);
            List<Integer> crong = List.of(11,12);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        public void sameScoreTest(){
            List<Integer> pobi = List.of(111, 112);
            List<Integer> crong = List.of(3,4);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }
}