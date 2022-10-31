package onboarding;

import java.util.List;

class Problem1 {
    /**
     * 페이지 번호 게임
     *
     * @param pobi
     * @param crong
     * @return answer || -1 if exception
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(exception(pobi) || exception(crong))
            return -1;

        int max_pobi = game(pobi);
        int max_crong = game(crong);

        if (max_pobi > max_crong) answer = 1;
        else if (max_pobi < max_crong) answer = 2;
        else answer = 0;

        return answer;
    }

    /**
     * 왼쪽 페이지 연산 결과의 최댓값과 오른쪽 페이지 연산 결과의 최댓값 중 큰 값을 리턴
     * @param pages
     * @return MAX value
     */
    public static int game(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        return Math.max(calc(left), calc(right));
    }

    /**
     * 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구함
     * @param num
     * @return MAX value
     */
    public static int calc(int num) {
        int add = 0, multiply = 1;
        while(num != 0) {
            add += num % 10;
            multiply *= num % 10;
            num /= 10;
        }
        return Math.max(add, multiply);
    }

    /**
     * 예외처리
     * @param pages
     * @return 예외발생 시, true
     */
    public static boolean exception(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        if(pages.size() != 2) return true; // 배열 길이가 2가 아님
        if(left < 1 || left > 400 || right < 1 || right > 400) return true; // 페이지 번호 범위(1~400) 벗어남
        if(left > right) return true; // 왼쪽 페이지 번호가 오른쪽 페이지 번호보다 큼
        if(left % 2 != 1) return true; // 왼쪽 페이지 번호가 홀수값이 아님
        if(right % 2 != 0) return true; // 오른쪽 페이지 번호가 짝수값이 아님
        if(right - left != 1) return true; // 연속된 페이지 번호가 아님
        if(left == 1 || right == 400) return true; // 시작 면이나 마지막 면 제외

        return false;
    }
}