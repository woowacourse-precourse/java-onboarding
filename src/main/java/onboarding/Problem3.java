package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        // 예외 사항 체크
        if (checkInvalid(number)) {
            return -1;
        }

        List<Character> list = Arrays.asList('3', '6', '9');

        return countTotal(number, list);
    }

    // 제한 사항
    private static boolean checkInvalid(int num) {
        // number 는 1이상 10000 이하 자연수
        if (num < 1 || num > 10000) {
            return true;
        }
        return false;
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
