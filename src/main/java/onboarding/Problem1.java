package onboarding;

import java.util.List;

class Problem1 {

    // 연속된 페이지인지 확인
    public static boolean checkPage(Integer a, Integer b) {
        boolean flag;

        if (b - a != 1) {
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }

    // 페이지의 각 자릿수를 덧셈
    public static int calSum(String s, Integer len) {
        int res = 0;

        for (int i = 0; i < len; i++) {
            res += Character.getNumericValue(s.charAt(i));
        }

        return res;
    }

    // 페이지의 각 자릿수를 곱셈
    public static int calMul(String s, Integer len) {
        int res = 1;

        for (int i = 0; i < len; i++) {
            res *= Character.getNumericValue(s.charAt(i));
        }

        return res;
    }

    // 두 개의 숫자 대소비교
    public static int compInt(Integer a, Integer b) {
        if (a > b) {
            return a;
        }
        else {
            return b;
        }
    }

    // List의 최대값 산출
    public static int calMax(List<Integer> pages) {
        int mySum, myMul, strLen;
        String tmpString;
        int res = 0;

        for(int i = 0; i < 2; i++) {
            tmpString = String.valueOf(pages.get(i));
            strLen = tmpString.length();
            mySum = calSum(tmpString, strLen);
            myMul = calMul(tmpString, strLen);
            res = compInt(res, compInt(mySum, myMul));
        }

        return res;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 페이지의 개수가 2가 아니고 연속된 페이지가 주어지지 않은 경우를 확인
        if (pobi.size() != 2 || crong.size() != 2) {
            return -1;
        }
        else if (checkPage(pobi.get(0), pobi.get(1)) || checkPage(crong.get(0), crong.get(1))) {
            return -1;
        }

        // pobi의 최대값 산출
        int pobiMax = calMax(pobi);
        //crong의 최대값 산출
        int crongMax = calMax(crong);

        // pobi의 최대값과 crong의 최대값을 비교하여 승자를 확인
        int res = compInt(pobiMax, crongMax);

        // 무승부 -> pobi -> crong 순으로 결과를 확인
        if (pobiMax == crongMax) {
            answer = 0;
        }
        else if (res == pobiMax) {
            answer = 1;
        }
        else {
            answer = 2;
        }

        return answer;
    }
}