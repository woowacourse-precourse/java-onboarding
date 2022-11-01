package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        int resultPobi = getScore(pobi);
        int resultCrong = getScore(crong);

        if (resultPobi == -1 || resultCrong == -1) {
            answer = -1;
        } else {
            if (resultPobi > resultCrong) {
                answer = 1;
            } else if (resultPobi < resultCrong) {
                answer = 2;
            } else {
                answer = 0;
            }
        }

        return answer;
    }

    /**
     * 플레이어의 최대 점수를 구하는 메서드
     *
     * @param player 현재 플레이어
     * @return 좌우 페이지중 최대 점수
     */
    public static int getScore(List<Integer> player) {

        if (!isValidList(player)) {
            return -1;
        } else {
            return Math.max(Math.max(getSum(player.get(0)), getProduct(player.get(0))), Math.max(getSum(player.get(1)), getProduct(player.get(1))));
        }
    }

    /**
     * 주어진 페이지의 각 자리 숫자의 합을 구하는 메서드
     *
     * @param page 주어진 페이지
     * @return 페이지의 각 자리 숫자의 합
     */
    public static int getSum(Integer page) {

        int ans = 0;

        if (page == null || page == 1) {
            return -1;

        } else {

            String str = String.valueOf(page);
            for (int i = 0; i < str.length(); i++) {
                ans += str.charAt(i) - '0';
            }

        }
        return ans;
    }

    /**
     * 주어진 페이지의 각 자리 숫자의 곱을 구하는 메서드
     *
     * @param page 주어진 페이지
     * @return 페이지의 각 자리 숫자의 곱
     */
    public static int getProduct(Integer page) {

        int ans = 1;

        if (page == null || page == 1) {
            return -1;
        } else {
            String str = String.valueOf(page);
            for (int i = 0; i < str.length(); i++) {
                ans *= str.charAt(i) - '0';
            }
        }
        return ans;
    }

    /**
     * 주어진 배열이 유효한 배열인지 판단하는 메서드
     *
     * @param list 주어진 페이지 배열
     * @return 유요한지 아닌지 판단하는 boolean 값
     */
    public static boolean isValidList(List<Integer> list) {

        if (list.get(0) >= list.get(1)) {
            return false;
        } else if (list.get(1) - list.get(0) != 1) {
            return false;
        } else if (list.get(0) == null || list.get(1) == null) {
            return false;
        } else return list.get(0) != 1 && list.get(1) != 400;
    }
}