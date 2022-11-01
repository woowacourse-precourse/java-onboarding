package onboarding;

import java.util.*;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;

        for(int i = 1; i <= number;i++) {

            answer += clapCnt(breakNum(i));
        }

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

    public static int clapCnt(List<Integer> broken) {

        int cnt = 0;

        for(int i : broken) {

            if (i == 3 || i == 6 || i == 9) {
                cnt++;
            }
        }

        return cnt;
    }

}
