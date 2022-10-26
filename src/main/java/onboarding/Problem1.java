package onboarding;

import java.util.List;

/*
1. 예외사항 처리하기
2. 가장 큰 수 찾기
3. 점수 비교하기
 */

class Problem1 {

    private static boolean isLeftPageOdd(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) % 2 != 0 && crong.get(1) % 2 != 0)
            return true;
        return false;
    }

    private static boolean isValidScope(List<Integer> pobi, List<Integer> crong) {
        if ((1 < pobi.get(0) && pobi.get(1) < 400) && (1 < crong.get(0) && crong.get(1) < 400))
            return true;
        return false;
    }

    private static boolean isSeriesPage(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1).equals(pobi.get(0)+1) && crong.get(1).equals(crong.get(0)+1))
            return true;
        return false;
    }

    private static int pageFindMaxNum(int num) {
        int sumDigit = 0;
        int mulDigit = 1;
        String number = Integer.toString(num);
        for (int i = 0; i < number.length(); i ++) {
            sumDigit += Integer.parseInt(number.substring(i, i+1));
            mulDigit *= Integer.parseInt(number.substring(i, i+1));
        }
        return Math.max(sumDigit, mulDigit);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(isLeftPageOdd(pobi, crong) && !(isValidScope(pobi, crong))) && !(isSeriesPage(pobi, crong))) {
            answer = -1;
            return answer;
        }

        int pobiMaxNum = Math.max(pageFindMaxNum(pobi.get(0)), pageFindMaxNum(pobi.get(1)));
        int crongMaxNum = Math.max(pageFindMaxNum(crong.get(0)), pageFindMaxNum(crong.get(1)));

        if (pobiMaxNum > crongMaxNum) {
            answer = 1;
        } else if (pobiMaxNum < crongMaxNum) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }
}