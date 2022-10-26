package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int incorrect = -1;

        //잘못된 입력
        if (pobi.get(0) == 1 || pobi.get(1) == 400 || crong.get(0) == 1 || crong.get(1) == 400) {
            // 시작 면이나 마지막 면이 나오지 않도록 한다. ex) 1,2 / 399, 400
            return incorrect;
        } else if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) {
            // 왼쪽 페이지는 홀수이다.
            return incorrect;
        } else if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            // 리스트는 연속된 숫자이다.
            return incorrect;
        }

        //조건 통과시 실행
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);
        if (pobiScore > crongScore) { // 포비 승 return 1
            answer = 1;
        } else if (pobiScore == crongScore) { //무승부 return 0
            answer = 0;
        } else answer = 2; // 크롱 승 return 2

        return answer;
    }

    public static int getScore(List<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (Integer quotient : list) { //list iter
            int remainder = 0; //나머지
            int sum = 0; //합
            int multi = 1; //곱
            while (quotient != 0) {
                remainder = quotient % 10;
                quotient = quotient / 10;
                sum += remainder; //자릿수의 합
                multi = multi * remainder; // 자릿수의 곱
            }
            max = Math.max(max, sum);
            max = Math.max(max, multi);
        }

        return max;
    }
}