package onboarding;

import java.util.List;

class Problem1 {

    private boolean checkException(List<Integer> pobi, List<Integer> crong) {

        if (pobi.get(1) - pobi.get(0) != 1) {
            return false;
        }

        if (crong.get(1) - crong.get(0) != 1) {
            return false;
        }

        if ((pobi.get(0) == 1) || (crong.get(0) == 1)) {
            return false;
        }

        if ((pobi.get(1) == 400) || (crong.get(1) == 400) {
            return false;
        }

        return true;
    }

    private int plusPage(Integer page) {

        int num = 0;
        String page_str = Integer.toString(page);

        for (int i = 0; i < page_str.length(); i++){
            num += Integer.parseInt(page_str.substring(i, i+1));
        }

        return num;
    }

    private int multiplyPage(Integer page) {

        int num = 1;
        String page_str = Integer.toString(page);

        for(int i = 0; i < page_str.length(); i++){
            num *= Integer.parseInt(page_str.substring(i, i+1));
        }

        return num;
    }

    private int compareNum(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        int leftMax;
        int rightMax;
        int pobiMaxNum;
        int crongMaxNum;

        if (!checkException(pobi, crong)) {
            return -1;
        }

        leftMax = compareNum(plusPage(pobi.get(0)), multiplyPage(pobi.get(0)));
        rightMax = compareNum(plusPage(pobi.get(1)), multiplyPage(pobi.get(1)));
        pobiMaxNum = compareNum(leftMax, rightMax);

        leftMax = compareNum(plusPage(crong.get(0)), multiplyPage(crong.get(0)));
        rightMax = compareNum(plusPage(crong.get(1)), multiplyPage(crong.get(1)));
        crongMaxNum = compareNum(leftMax, rightMax);

        if (pobiMaxNum < crongMaxNum) {
            answer = 2;
        } else (pobiMaxNum > crongMaxNum) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}