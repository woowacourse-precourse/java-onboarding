package onboarding;

import java.util.List;

class Problem1 {


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        //pobi
        int resultPobi = 0;

        if (!isValidList(pobi)) {
            resultPobi = -1;
        } else {
            int leftPobi = Math.max(getSum(pobi.get(0)), getProduct(pobi.get(0)));
            int rightPobi = Math.max(getSum(pobi.get(1)), getProduct(pobi.get(1)));
            resultPobi = Math.max(leftPobi, rightPobi);
        }

        //crong
        int resultCrong = 0;

        if (!isValidList(crong)) {
            resultCrong = -1;
        } else {
            int leftCrong = Math.max(getSum(crong.get(0)), getProduct(crong.get(0)));
            int rightCrong = Math.max(getSum(crong.get(1)), getProduct(crong.get(1)));
            resultCrong = Math.max(leftCrong, rightCrong);
        }


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

        if (page == null|| page == 1) {
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

        //왼쪽 페이지가 오른쪽 페이지보다 더 큰 경우 ex) 23,10
        if (list.get(0) >= list.get(1)) {
            return false;
            //오른쪽 페이지가 왼쪽 페이지의 바로 다음 페이지가 아닌경우 ex) 10,12
        } else if (list.get(1) - list.get(0) != 1) {
            return false;
            //둘중 하나라도 null 인 경우 ex) null,10
        } else if (list.get(0) == null || list.get(1) == null) {
            return false;
            //첫번쨰 페이지거나 마지막 페이지인 경우
        } else if (list.get(0) == 1 || list.get(1) == 400) {
            return false;
        }

        return true;
    }
}