package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        List<Integer> pobiPage = new ArrayList<>(pobi);
        List<Integer> crongPage = new ArrayList<>(crong);

        // 포비 왼쪽 페이지, 오른쪽 페이지, 최대값
        int pLeft = getMax(pobiPage.get(0));
        int pRight = getMax(pobiPage.get(1));
        int pMax = Math.max(pLeft, pRight);

        // 크롱 왼쪽 페이지, 오른쪽 페이지, 최대값
        int cLeft = getMax(crongPage.get(0));
        int cRight= getMax(crongPage.get(1));
        int cMax = Math.max(cLeft, cRight);

        // 포비와 크롱의 점수 비교
        if (pMax > cMax) {
            answer = 1;
        } else if (pMax < cMax) {
            answer = 2;
        } else {
            answer = 0;
        }

        // 왼쪽 페이지가 짝수, 시작 페이지와 끝 페이지, 연속 페이지가 아닐 때 return -1
        if (pobiPage.get(0) % 2 == 0 || crongPage.get(0) % 2 == 0 ||
                pobiPage.get(0) == 1 || crongPage.get(1) == 400 ||
                pobiPage.get(0) + 1 != pobiPage.get(1) || crongPage.get(0) + 1 != crongPage.get(1)) {
            answer = -1;
        }

        // System.out.println("pLeft = " + pLeft + " pRight = " + pRight + " pMax = " + pMax);
        // System.out.println("cLeft = " + cLeft + " cRight = " + cRight + " cMax = " + cMax );

        return answer;
    }

    /* 각 페이지 최대값 계산 */
    private static int getMax(int page) {
        int hundreds = (page / 100);    // 백의 자리
        int tens = (page % 100) / 10;   // 십의 자리
        int units = (page % 10);        // 일의 자리

        int sum = hundreds + tens + units;  // 합한 값
        int mul = hundreds * tens * units;  // 곱한 값

        // 백의 자리가 0이면 십의 자리와 일의 자리 곱셈
        if (hundreds == 0) {
            mul = tens * units;
        }

        return Math.max(sum, mul); // 비교 후 최대값 return
    }
}