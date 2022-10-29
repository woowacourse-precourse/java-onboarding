package onboarding;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import org.junit.jupiter.api.Test;

class Problem1Test {

    @Test
    void 점수측정테스트() {

        //given
        int[] pages = {4, 81, 293};
        int[] realResult = {4, 9, 54};

        //when
        int[] results = new int[3];
        for (int i = 0; i < 3; i++) {
            results[i] = Problem1.getPageMaxPoint(pages[i]);
        }
        //then
        assertArrayEquals(realResult, results);
    }

    @Test
    void 유저점수테스트() {
        List<Integer> firstPages = new ArrayList<>(Arrays.asList(1, 2));

        assertThrows(InputMismatchException.class, () -> Problem1.getUserMaxPoint(firstPages));

        List<Integer> lastPages = new ArrayList<>(Arrays.asList(399, 400));
        assertThrows(InputMismatchException.class, () -> Problem1.getUserMaxPoint(lastPages));

        List<Integer> invalidPages = new ArrayList<>(Arrays.asList(3, 77));
        assertThrows(InputMismatchException.class, () -> Problem1.getUserMaxPoint(invalidPages));

        List<Integer> pages1 = new ArrayList<>(Arrays.asList(123, 124));

        assertEquals(8, Problem1.getUserMaxPoint(pages1));

        List<Integer> pages2 = new ArrayList<>(Arrays.asList(199, 200));

        assertEquals(81, Problem1.getUserMaxPoint(pages2));


    }

    @Test
    void 결과테스트() {
        List<Integer> user1 = new ArrayList<>(Arrays.asList(123, 124));
        List<Integer> user2 = new ArrayList<>(Arrays.asList(199, 200));
        List<Integer> user3 = new ArrayList<>(Arrays.asList(99,100));
        List<Integer> exceptinUser = new ArrayList<>(Arrays.asList(1, 2));

        assertEquals(2, Problem1.getResult(user1,user2));
        assertEquals(1, Problem1.getResult(user2,user1));
        assertEquals(0, Problem1.getResult(user3,user2));
        assertEquals(-1, Problem1.getResult(user1,exceptinUser));

    }
}