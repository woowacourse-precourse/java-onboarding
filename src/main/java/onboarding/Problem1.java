package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        /**
         * 포비의 기본 값 받기
         */
        String pobi1 = "" + pobi.get(0);
        String pobi2 = "" + pobi.get(1);

        int pobiLeft1 = 0;
        int pobiLeft2 = 1;

        int pobiLeftMax = 0;

        int pobiRight1 = 0;
        int pobiRight2 = 1;

        int pobiRightMax = 0;

        int pobiRealMax = 0;

        /**
         * 포비의 왼쪽 최댓값
         */
        for (int i = 0; i < pobi1.length(); i++) {
            pobiLeft1 += pobi1.charAt(i) - 48;
            pobiLeft2 *= pobi1.charAt(i) - 48;
        }

        if (pobiLeft1 >= pobiLeft2) {
            pobiLeftMax = pobiLeft1;
        }

        if (pobiLeft1 < pobiLeft2) {
            pobiLeftMax = pobiLeft2;
        }

        /**
         * 포비의 오른쪽 최댓값
         */
        for (int i = 0; i < pobi2.length(); i++) {
            pobiRight1 += pobi2.charAt(i) - 48;
            pobiRight2 *= pobi2.charAt(i) - 48;
        }

        if (pobiRight1 >= pobiRight2) {
            pobiRightMax = pobiRight1;
        }

        if (pobiRight1 < pobiRight2) {
            pobiRightMax = pobiRight2;
        }

        /**
         * 포비의 왼쪽 오른쪽 비교해서 최댓값
         */
        if (pobiLeftMax >= pobiRightMax) {
            pobiRealMax = pobiLeftMax;
        }

        if (pobiLeftMax < pobiRightMax) {
            pobiRealMax = pobiRightMax;
        }

        /**
         * 크롱의 기본 값 받기
         */

        String crong1 = "" + crong.get(0);
        String crong2 = "" + crong.get(1);

        int crongLeft1 = 0;
        int crongLeft2 = 1;

        int crongRight1 = 0;
        int crongRight2 = 1;

        int crongLeftMax = 0;

        int crongRightMax = 0;

        int crongRealMax = 0;

        /**
         * 크롱의 왼쪽 최댓값
         */
        for (int i = 0; i < crong1.length(); i++) {
            crongLeft1 += crong1.charAt(i) - 48;
            crongLeft2 *= crong1.charAt(i) - 48;
        }

        if (crongLeft1 >= crongLeft2) {
            crongLeftMax = crongLeft1;
        }

        if (crongLeft1 < crongLeft2) {
            crongLeftMax = crongLeft2;
        }

        /**
         * 크롱의 오른쪽 최댓값
         */
        for (int i = 0; i < crong2.length(); i++) {
            crongRight1 += crong2.charAt(i) - 48;
            crongRight2 *= crong2.charAt(i) - 48;
        }

        if (crongRight1 >= crongRight1) {
            crongRightMax = crongRight1;
        }

        if (crongRight1 < crongRight2) {
            crongRightMax = crongRight2;
        }

        /**
         * 크롱의 왼쪽 오른쪽 비교해서 최댓값
         */
        if (crongLeftMax >= crongRightMax) {
            crongRealMax = crongLeftMax;
        }

        if (crongLeftMax < crongRightMax) {
            crongRealMax = crongRightMax;
        }

        /**
         * 포비 크롱 비교
         */
        if (pobiRealMax > crongRealMax) {
            answer = 1;
            System.out.println("crongRealMax = " + crongRealMax);
        }

        if (pobiRealMax == crongRealMax) {
            answer = 0;
            System.out.println("crongRealMax = " + crongRealMax);
        }

        if (pobiRealMax < crongRealMax) {
            answer = 2;
            System.out.println("crongRealMax = " + crongRealMax);
        }

        /**
         * 예외처리
         */
        if (pobi.size() > 2 || crong.size() > 2) {
            answer = -1;
        }

        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            answer = -1;
        }

        if (pobi.get(0) == 1 || pobi.get(0) == 399) {
            answer = -1;
        }

        if (crong.get(0) == 1 || crong.get(0) == 399) {
            answer = -1;
        }

        return answer;
    }
}