package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String[] numberArr = String.valueOf(i).split("");
            if (checkNumber(numberArr)) {
                answer += countClap(numberArr);
            }
        }

        return answer;
    }

    // 각 숫자에 3,6,9가 듣어가는지 확인하는 메서드
    static boolean checkNumber(String[] numberArr) {
        for (int i = 0; i < numberArr.length; i++) {
            if (numberArr[i].equals("3") || numberArr[i].equals("6") || numberArr[i].equals("9")) {
                return true;
            }
        }
        return false;
    }

    // 3,6,9의 개수만큼 손뼉 횟수를 증가시키는 메서드
    static int countClap(String[] numberArr) {
        int cnt = 0;
        for (int i = 0; i < numberArr.length; i++) {
            if (numberArr[i].equals("3") || numberArr[i].equals("6") || numberArr[i].equals("9")) {
                cnt++;
            }
        }
        return cnt;
    }
}
