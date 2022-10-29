package onboarding;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Problem1Test {

    @Test
    void 점수측정테스트() {

        //given
        int[] pages = {4,81,293};
        int[] realResult = {4,9,54};

        //when
        int[] results = new int[3];
        for (int i = 0; i < 3; i++) {
            results[i] = Problem1.getPageMaxPoint(pages[i]);
        }
        //then
        assertArrayEquals(realResult, results);
    }
}