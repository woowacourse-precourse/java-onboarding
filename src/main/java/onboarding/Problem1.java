package onboarding;

import java.util.List;

class Problem1 {
    // 시작면이나 마지막면이 나오는 건 안 됨
    public static boolean isFirstOrLastPage(int page1, int page2) {
        return page1 != 1 && page2 != 400;
    }

    // 왼쪽 오른쪽 페이지 골라서 최대 점수 구하기
    public static int isMaxPage(List<Integer> page1, List<Integer> page2) {
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

}

/*
포비, 크롱 페이지 번호 게임 대결

조건
- 1 ~ 400 페이지까지 있음
- 왼쪽 홀수, 오른쪽 짝수
- 왼쪽 숫자의 각 자리 숫자끼리 더함 or 곱함 중에 높은 숫자
- 오른쪽 숫자의 각 자리 숫자끼리 더함 or 곱함 중에 높은 숫자
- 왼쪽 결과 오른쪽 결과 중에 높은 숫자
- 그 숫자를 포비랑 크롱이 비교
- 포비가 이기면 1, 크롱이 이기면 2, 무승부면 0, 예외는 -1
- 시작면이나 마지막면이 나오는 건 안 됨 (표지? or 1, 400?)


 */