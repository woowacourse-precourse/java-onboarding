package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] answer = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        while (money != 0) {
            if (money >= 50000) {
                money -= 50000;
                answer[0]++;
            } else if (money >= 10000) {
                money -= 10000;
                answer[1]++;
            } else if (money >= 5000) {
                money -= 5000;
                answer[2]++;
            } else if (money >= 1000) {
                money -= 1000;
                answer[3]++;
            } else if (money >= 500) {
                money -= 500;
                answer[4]++;
            } else if (money >= 100) {
                money -= 100;
                answer[5]++;
            } else if (money >= 50) {
                money -= 50;
                answer[6]++;
            } else if (money >= 10) {
                money -= 10;
                answer[7]++;
            } else if (money >= 1) {
                money -= 1;
                answer[8]++;
            }
        }

        List<Integer> count = Arrays.stream(answer).boxed().collect(Collectors.toList());
        return count;
    }
}
