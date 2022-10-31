package onboarding;

import java.util.List;

class Problem1 {
    public static int getPageMultiplication(int page) {        // page 각 자리수의 곱을 반환하는 메소드
        if (page / 100 != 0) {        // 100 <= page <= 400
            return (page / 100) * (page % 100 / 10) * (page % 10);
        }
        if (page / 10 != 0) {        // 10 <= page <= 99
            return (page / 10) * (page % 10);
        }
        return page;                 // 1 <= page <= 9
    }

    public static int getPageSum(int page) {        // page 각 자리수의 합을 반환하는 메소드
        return (page / 100) + (page % 100 / 10) + (page % 10);
    }

    public static int getMaxvalue(List<Integer> player) {        // 플레이어의 페이지 합, 곱 중에서 가장 큰 값을 반환하는 메소드
        int maxValue = 0;

        for(int i = 0; i < 2; i++) {
            maxValue = Math.max(maxValue, getPageSum(player.get(i)));
            maxValue = Math.max(maxValue, getPageMultiplication(player.get(i)));
        }

        return maxValue;
    }

    public static int playGame(List<Integer> pobi, List<Integer> crong) {        // 게임을 시작하는 메소드
        if (getMaxvalue(pobi) > getMaxvalue(crong)) {
            return 1;        // 포비의 승리
        }
        if (getMaxvalue(pobi) < getMaxvalue(crong)) {
            return 2;        // 크롱의 승리
        }
        return 0;            // 무승부
    }

    public static boolean hasPageException(List<Integer> pageList) {        // page 예외 사항이 존재하는 확인하는 메소드
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        if (leftPage < 1 && leftPage > 400 && rightPage < 1 && rightPage > 400) {        // page 범위 확인
            return true;
        }

        if (rightPage != leftPage + 1) {        // 왼쪽 페이지와 오른쪽 페이지가 인접한 페이지인지 확인
            return true;
        }

        if (leftPage % 2 == 0 || rightPage % 2 != 0) {        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수인지 확인
            return true;
        }

        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (hasPageException(pobi) || hasPageException(crong)) {
            return -1;    // 페이지 예외 발생
        }

        return playGame(pobi, crong);
    }
}