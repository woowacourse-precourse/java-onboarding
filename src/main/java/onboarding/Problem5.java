package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        howMuchMax(money, answer);
        return answer;
    }

    private static void howMuchMax(int money, List<Integer> answer) {
        int[] arr = new int[9];
        int first = 50000;
        int hunnit = 10000;


        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) {
                arr[i] = money / first;
                money %= first;
                first /= 10;
            } else {
                arr[i] = money / hunnit;
                money %= hunnit;
                hunnit /= 10;
            }

            if (i == arr.length - 2) {
                arr[i + 1] = money;
            }

        }

        for (int i : arr) {
            answer.add(i);
        }

    }

}
