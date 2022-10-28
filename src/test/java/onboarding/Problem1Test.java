package onboarding;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class Problem1Test {

    @Test
    void solutionTest(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int pobiPage = random.nextInt(197) * 2 + 1;
        int crongPage = random.nextInt(197) * 2 + 1;

        // pobi == crong
        List<Integer> pobi1 = new ArrayList<>(Arrays.asList(123,124));
        List<Integer> crong1 = new ArrayList<>(Arrays.asList(123,124));

        // pobi > crong
        List<Integer> pobi2 = new ArrayList<>(Arrays.asList(197,198));
        List<Integer> crong2 = new ArrayList<>(Arrays.asList(11,12));

        // pobi < crong
        List<Integer> pobi3 = new ArrayList<>(Arrays.asList(11,12));
        List<Integer> crong3 = new ArrayList<>(Arrays.asList(167,168));

        // exception
        List<Integer> pobi4 = new ArrayList<>(Arrays.asList(122,123));
        List<Integer> crong4 = new ArrayList<>(Arrays.asList(0,1));

        // random
        List<Integer> pobi5 = new ArrayList<>(Arrays.asList(pobiPage,pobiPage+1));
        List<Integer> crong5 = new ArrayList<>(Arrays.asList(crongPage,crongPage+1));

        System.out.println("pobi == crong => " + Problem1.solution(pobi1,crong1));
        System.out.println("pobi > crong => " + Problem1.solution(pobi2,crong2));
        System.out.println("pobi < crong => " + Problem1.solution(pobi3,crong3));
        System.out.println("exception Result => " + Problem1.solution(pobi4,crong4));
        System.out.println("random Result => " + Problem1.solution(pobi5,crong5));
    }
}