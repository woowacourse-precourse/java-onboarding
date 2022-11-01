package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 길이, 페이지 번호 예외
        if (pobi.size() != 2 || crong.size() != 2) return -1;
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return -1;

        int pobiNum = Math.max( // 포비의 점수
                Math.max(sum(pobi.get(0)), mul(pobi.get(0))), // 왼쪽 페이지 번호의 최댓값
                Math.max(sum(pobi.get(1)), mul(pobi.get(1)))  // 오른쪽 페이지 번호의 최댓값
        );

        int crongNum = Math.max( // 크롱의 점수
                Math.max(sum(crong.get(0)), mul(crong.get(0))), // 왼쪽 페이지 번호의 최댓값
                Math.max(sum(crong.get(1)), mul(crong.get(1)))  // 오른쪽 페이지 번호의 최댓값
        );

        if (pobiNum > crongNum) {
            return 1;
        }
        else if (pobiNum < crongNum) {
            return 2;
        }
        else {
            return 0;
        }
    }

    private static int sum(int num) { // 덧셈
        int answer = 0;
        while (num != 0) {
            answer += num % 10;
            num /= 10;
        }
        return answer;
    }

    private static int mul(int num) { // 곱셈
        int answer = 1;
        while (num != 0) {
            answer *= num % 10;
            num /= 10;
        }
        return answer;
    }
}