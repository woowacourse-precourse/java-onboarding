package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MIN_VALUE;

        if (isError(pobi) || isError(crong))
            return -1;

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore == crongScore)
            answer = 0;
        else if (pobiScore > crongScore)
            answer = 1;
        else if (pobiScore < crongScore)
            answer = 2;

        return answer;
    }

    static boolean isError(List<Integer> list) {
        if (list.get(0) == 1 || list.get(1) == 400)
            return true;
        if (list.get(0) % 2 == 0)
            return true;
        if (list.get(1) - list.get(0) != 1)
            return true;
        return false;
    }

    static int getScore(List<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (Integer quotient : list) { //list iter
            int remainder = 0; //나머지
            int sum = 0; //합
            int multiply = 1; //곱
            while (quotient != 0) {
                remainder = quotient % 10;
                quotient = quotient / 10;
                sum += remainder; //자릿수의 합
                multiply = multiply * remainder; // 자릿수의 곱
            }
            max = Math.max(max, sum);
            max = Math.max(max, multiply);
        }

        return max;
    }
}