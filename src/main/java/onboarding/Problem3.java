package onboarding;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {

    private static Set<Integer> specificNumberSet;
    public static int solution(int number) {
        int answer = 0;
        setByGameRule();
        for (int i = 1; i <= number ; i++) {

            int tmpNum = i;
            answer += count369(tmpNum);
        }

        return answer;
    }

    private static void setByGameRule() {
        specificNumberSet = new HashSet<>();
        specificNumberSet.add(3);
        specificNumberSet.add(6);
        specificNumberSet.add(9);
    }

    // ex. 334
    // return 2
    private static int count369(int number) {
        int count = 0;
        while(number > 0) {
            count = updateCount(number, count);
            number /= 10;
        }
        return count;
    }

    private static int updateCount(int number, int count) {
        if (specificNumberSet.contains(number % 10)) {
            count++;
        }
        return count;
    }
}
