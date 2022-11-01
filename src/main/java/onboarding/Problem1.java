package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiPlusScore = plus(pobi.get(0));


        return answer;
    }

    // 각 자리의 숫자들 더한 값을 구하는 함수
    public static int plus(int num){
        int plus = (num / 100) + ((num / 10) % 10) + (num % 10);

        return plus;
    }
}