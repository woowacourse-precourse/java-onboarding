package onboarding;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import org.junit.jupiter.api.Test;

class Problem1Test {

    Problem1 problem1 = new Problem1();

    @Test
    void 점수측정테스트() {

        //given
        int[] pages = {4, 81, 293};
        int[] realResult = {4, 9, 54};

        //when
        int[] results = new int[3];
        for (int i = 0; i < 3; i++) {

            results[i] = problem1.makePage(pages[i]).getPageMaxPoint();
        }
        //then
        assertArrayEquals(realResult, results);
    }

    @Test
    void 유저점수테스트() {
        List<Integer> firstPages = new ArrayList<>(Arrays.asList(1, 2));

        assertThrows(InputMismatchException.class, () -> problem1.makeUser(firstPages).maxPoint());

        List<Integer> lastPages = new ArrayList<>(Arrays.asList(399, 400));
        assertThrows(InputMismatchException.class, () -> problem1.makeUser(lastPages).maxPoint());

        List<Integer> invalidPages = new ArrayList<>(Arrays.asList(3, 77));
        assertThrows(InputMismatchException.class, () -> problem1.makeUser(invalidPages).maxPoint());

        List<Integer> pages1 = new ArrayList<>(Arrays.asList(123, 124));

        assertEquals(8, problem1.makeUser(pages1).maxPoint());

        List<Integer> pages2 = new ArrayList<>(Arrays.asList(199, 200));

        assertEquals(81, problem1.makeUser(pages2).maxPoint());


    }

    @Test
    void 결과테스트() {
        List<Integer> user1 = new ArrayList<>(Arrays.asList(123, 124));
        List<Integer> user2 = new ArrayList<>(Arrays.asList(199, 200));
        List<Integer> user3 = new ArrayList<>(Arrays.asList(99, 100));
        List<Integer> exceptinUser = new ArrayList<>(Arrays.asList(1, 2));

        assertEquals(2, Problem1.solution(user1, user2));
        assertEquals(1, Problem1.solution(user2, user1));
        assertEquals(0, Problem1.solution(user3, user2));
        assertEquals(-1, Problem1.solution(user1, exceptinUser));

    }
}