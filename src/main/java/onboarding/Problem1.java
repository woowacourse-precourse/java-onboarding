package onboarding;

import java.util.*;


public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax = 0;
        int crongMax = 0;
        int temp = 0;

        for (int i = 0; i < 2; i++) {
            int num = pobi.get(i);
            while (num > 0) {
                temp += num % 10;
                num = num / 10;
            }
            if (temp > pobiMax) pobiMax = temp;
        }

        for (int i = 0; i < 2; i++) {
            int num = crong.get(i);
            while (num > 0) {
                temp += num % 10;
                num = num / 10;
            }
            if (temp > crongMax) crongMax = temp;
        }

        if (pobiMax > crongMax) answer = 0;
        else if (pobiMax < crongMax) answer = 1;
        else answer = -1;

        return answer;
    }
}