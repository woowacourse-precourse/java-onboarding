package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem1UnitTest {

    @Test
    public void firstMethod() {
        System.out.println("ver 1");

        long start = System.nanoTime();
        int k = Problem1.calculatePageScoreV1(143);
        long end = System.nanoTime();
        System.out.println("score : "+k);
        System.out.println("processing time : "+(end - start));

    }

    @Test
    public void secondMethod() {
        System.out.println("ver 2");

        long start = System.nanoTime();
        int k = Problem1.calculatePageScoreV2(143);
        long end = System.nanoTime();
        System.out.println("score : "+k);
        System.out.println("processing time : "+(end - start));
    }

    @Test
    public void identifyExceptionTest() {
        List<Integer> test1 = new ArrayList<>();
        test1.add(101);
        test1.add(102);

        List<Integer> test2 = new ArrayList<>();
        test2.add(211);
        test2.add(212);

        Assertions.assertThat(Problem1.solution(test1, test2)).isEqualTo(2);
    }

}
