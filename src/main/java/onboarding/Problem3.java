package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        List<Character> list = Arrays.asList('3', '6', '9');

        return countTotal(number, list);
    }

    // 1부터 number 까지 총 3,6,9 개수 세는 함수
    private static int countTotal(Integer num, List<Character> list) {
        int total = 0;

        // 1부터 number 까지 3,6,9 횟수 세기
        for (int k = 1; k <= num; k++) {
            total += count369(k, list);
        }
        return total;
    }

    // 각 자릿수에 들어있는 3,6,9 개수 세는 함수
    private static int count369(int k, List<Character> list) {
        Integer num = k;
        String strNum = num.toString();
        int count = 0;

        for (int i=0;i<strNum.length();i++) {
            if (list.contains(strNum.charAt(i))) {
                count += 1;
            }
        }
        return count;
    }
}
