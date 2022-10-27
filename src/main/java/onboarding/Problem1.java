package onboarding;

import java.util.List;

/**
 * 기능목록
 * 1. 페이지는 1~400 페이지 중에 포함되어야 하고, 시작면(1페이지)나 마지막면(400페이지)가 나오지 않아야 하며,
 * 왼쪽이 홀수, 오른쪽이 짝수이고, 왼쪽과 오른쪽은 한페이지 차이가 나야한다. 이 외의 경우 예외상황 -1을 출력한다
 * 2. 각 자릿수를 더하는 메서드, 각 자릿수의 곲을 구하는 메서드를 포함한다.
 * 3. 포비와 크롱의 페이지에의 최대값을 구한다
 * 4. 포비가 이기는 경우 1, 크롱이 이기면2, 비기면 0을 리턴한다.
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외처리
        //== 기능목록1 ==//
        if (rangeException(pobi) || rangeException(crong)) return -1;

        return answer;
    }

    /**
     * @return 예외 상황이 발생하면 true 아니면 false
     */
    private static boolean rangeException(List<Integer> list) {
        //페이지는 1~400페이지 안에 있어야함
        if (list.get(0) <= 0 || list.get(1) <= 0) return true;
        if (list.get(0) > 400 || list.get(1) > 400) return true;
        //첫면 마지막면은 안된다.
        if (list.get(0) == 1) return true;
        if (list.get(1) == 400) return true;
        //왼쪽이 홀수 오른쪽이 짝수 여야한다.
        if (list.get(0) % 2 != 1) return true;
        if (list.get(1) % 2 != 0) return true;
        //두 페이지는 한페이지 차이가 나야함
        if (list.get(0) + 1 != list.get(1)) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}