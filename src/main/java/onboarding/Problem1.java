package onboarding;

import java.util.List;

/*
1. 예외사항 처리하기
2. 가장 큰 수 찾기
3. 점수 비교하기
 */

class Problem1 {

    private static boolean isValidPage(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0) % 2 != 0 && crong.get(0) % 2 != 0;
    }

    private static boolean isValidScope(List<Integer> pobi, List<Integer> crong) {
        return (1 < pobi.get(0) && pobi.get(1) < 400) && (1 < crong.get(0) && crong.get(1) < 400);
    }

    private static boolean isSeriesPage(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(1).equals(pobi.get(0) + 1) && crong.get(1).equals(crong.get(0) + 1);
    }

    private static int getPageMax(int num) {
        int sumDigit = 0;
        int mulDigit = 1;
        String number = Integer.toString(num);
        for (int i = 0; i < number.length(); i ++) {
            int digit = Integer.parseInt(number.substring(i, i+1));
            sumDigit += digit;
            mulDigit *= digit;
        }
        return Math.max(sumDigit, mulDigit);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(isValidPage(pobi, crong) || !(isValidScope(pobi, crong))) || !(isSeriesPage(pobi, crong))) {
            answer = -1;
            return answer;
        }

        int pobiMaxNum = Math.max(getPageMax(pobi.get(0)), getPageMax(pobi.get(1)));
        int crongMaxNum = Math.max(getPageMax(crong.get(0)), getPageMax(crong.get(1)));

        if (pobiMaxNum > crongMaxNum) {
            answer = 1;
        }
        if (pobiMaxNum < crongMaxNum) {
            answer = 2;
        }
        if (pobiMaxNum == crongMaxNum) {
            answer = 0;
        }
        return answer;
    }
}