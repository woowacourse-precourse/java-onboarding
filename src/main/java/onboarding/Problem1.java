package onboarding;

import java.util.List;

class Problem1 {
    // 왼쪽 페에지가 홀수, 오른쪽 페이지가 짝수, 왼쪽과 오른쪽 페이지가 1 차이가 난다면 유효함
    static boolean validatePage(int left, int right) {
        return left % 2 == 1 && right % 2 == 0 && left + 1 == right;
    }

    static int getScore(int page) {
        int plusScore = 0;
        int multiScore = 1;

        // 각 자릿수의 덧셈과 나눗셈 결과 구하기
        while (page > 0) {
            plusScore += page % 10;
            multiScore *= page % 10;
            page /= 10;
        }
        return Math.max(plusScore, multiScore);
    }


    static int maxScore(int left, int right) {
        // 유효하지 않다면
        if (!validatePage(left, right)) {
            return -1;
        }
        // 유효하면 왼쪽과 오른쪽 값 중 큰 값 리턴
        return Math.max(getScore(left), getScore(right));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = maxScore(pobi.get(0), pobi.get(1));
        int crongScore = maxScore(crong.get(0), crong.get(1));

        // 예외상황
        if (pobiScore == -1 || crongScore == -1) {
            answer = -1;
        } else if (pobiScore == crongScore) {
            answer = 0;
        } else if (pobiScore > crongScore) {
            answer = 1;
        } else {
            answer = 2;
        }

        return answer;
    }

}