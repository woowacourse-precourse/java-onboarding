package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiPlusScore = Math.max(plus(pobi.get(0)), plus(pobi.get(1)));
        int pobiMultiplyScore = Math.max(multiply(pobi.get(0)), multiply(pobi.get(1)));

        int crongPlusScore = Math.max(plus(crong.get(0)), plus(crong.get(1)));
        int crongMultiplyScore = Math.max(multiply(crong.get(0)), multiply(crong.get(1)));

        int pobiScore = Math.max(pobiPlusScore, pobiMultiplyScore);
        int crongScore = Math.max(crongPlusScore, crongMultiplyScore);

        return answer;
    }

    // 각 자리의 숫자를 더한 값을 구하는 함수
    public static int plus(int num){
        int plus = (num / 100) + ((num / 10) % 10) + (num % 10);

        return plus;
    }

    // 각 자리의 숫자를 곱한 값을 구하는 함수
    public static int multiply(int num){
        int multiply = 0;

        if ((num / 100) == 0){
            multiply = ((num / 10) % 10) * (num % 10);
        } else {
            multiply = (num / 100) * ((num / 10) % 10) * (num % 10);
        }

        return multiply;
    }
}