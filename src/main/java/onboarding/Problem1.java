package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.size() != 2 || crong.size() != 2) return -1; // 길이 예외
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return -1; // 페이지 번호 예외

        int pobiNum = Math.max( // 포비의 점수
                Math.max(plus(pobi.get(0)), multiply(pobi.get(0))), // 왼쪽 페이지 번호의 최댓값
                Math.max(plus(pobi.get(1)), multiply(pobi.get(1)))); // 오른쪽 페이지 번호의 최댓값

        int crongNum = Math.max( // 크롱의 점수
                Math.max(plus(crong.get(0)), multiply(crong.get(0))), // 왼쪽 페이지 번호의 최댓값
                Math.max(plus(crong.get(1)), multiply(crong.get(1)))); // 오른쪽 페이지 번호의 최댓값

        if(pobiNum > crongNum) return 1;
        else if(pobiNum < crongNum) return 2;
        else return 0;
    }

    private static int plus(int num) { // 각 자리 숫자를 모두 더하기
        int answer = 0 ;
        while(num != 0) {
            answer += num % 10;
            num /= 10;
        }
        return answer;
    }

    private static int multiply(int num) { // 각 자리 숫자를 모두 곱하기
        int answer = 1 ;
        while(num != 0) {
            answer *= num % 10;
            num /= 10;
        }
        return answer;
    }
}