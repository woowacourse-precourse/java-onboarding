package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    static final int[] numsToClap = new int[] {3, 6, 9} ;
    public static int solution(int number) {
        int answer = 0;

        for (int n = 1; n <= number; n++) {
            answer += calculateNumClap(n);
        }

        return answer;
    }

    private static int calculateNumClap(int n) {
        int result = 0;
        for (int num : splitNum(n)) {
            for (int numToClap : numsToClap) {
                if (num == numToClap) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }

    private static List<Integer> splitNum(int n) {
        ArrayList<Integer> splitedNums = new ArrayList<>();
        while (n != 0) {
            splitedNums.add(n % 10);
            n /= 10;
        }

        return splitedNums;
    }

}