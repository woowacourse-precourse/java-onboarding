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

    public static int getScore(List<Integer> player) {

        if (!isValidList(player)) {
            return -1;
        } else {
            return Math.max(Math.max(getSum(player.get(0)), getProduct(player.get(0))), Math.max(getSum(player.get(1)), getProduct(player.get(1))));
        }
    }

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