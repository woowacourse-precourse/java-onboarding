package onboarding;

import java.util.*;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;

        return answer;
    }

    public static List<Integer> breakNum(Integer page) {

        List<Integer> broken = new ArrayList<>();

        while(page > 0) {
            broken.add(page % 10);
            page /= 10;
        }

        return broken;
    }

}
