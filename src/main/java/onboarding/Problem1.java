package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        String pobi1 = ""+pobi.get(0);
        String pobi2 = ""+pobi.get(1);

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
        for (int i=0; i<pobi1.length(); i++) {
            pobiLeft1 += pobi1.charAt(i)-48;
            pobiLeft2 *= pobi1.charAt(i)-48;
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
        for (int i=0; i<pobi2.length(); i++) {
            pobiRight1 += pobi2.charAt(i)-48;
            pobiRight2 *= pobi2.charAt(i)-48;
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

        String crong1 = ""+crong.get(0);
        String crong2 = ""+crong.get(1);

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
        for (int i=0; i<crong1.length(); i++) {
            crongLeft1 += crong1.charAt(i)-48;
            crongLeft2 *= crong1.charAt(i)-48;
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
        for (int i=0; i<crong2.length(); i++) {
            crongRight1 += crong2.charAt(i)-48;
            crongRight2 *= crong2.charAt(i)-48;
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

        if (pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) {
            answer = -1;
        }

        if (pobi.get(0) ==1 || pobi.get(0) == 399) {
            answer = -1;
        }

        if (crong.get(0) == 1 || crong.get(0) == 399) {
            answer = -1;
        }

        return answer;

        /**int pobiMax1 = 0;
        int pobiMax1_1 = 1;

        int pobiMax2 = 0;
        int pobiMax2_2 = 1;

        int pobiLeftMax = 0;
        int pobiRightMax = 0;

        int pobiRealMax = 0;
        ////////////////////////////////////////////////////
        int crongMax1 = 0;
        int crongMax1_1 = 1;

        int crongMax2 = 0;
        int crongMax2_2 = 1;

        int crongLeftMax = 0;
        int crongRightMax = 0;

        int crongRealMax = 0;


        String num1 = (int)((Math.random()*400)+1)+"";
        System.out.println("num1 = " + num1);
        System.out.println("num1 = " + num1.length());

        ////////////////////////////////////
        if (pobiLeftMax >= pobiRightMax) {
            pobiRealMax = pobiLeftMax;
        }

        if (pobiLeftMax < pobiRightMax) {
            pobiRealMax = pobiRightMax;
        }

        for (int i=0; i<num1.length(); i++) {
            pobiMax1 += num1.charAt(i)-48;
            pobiMax1_1 *= num1.charAt(i)-48;
            System.out.println("num1.charAt(i) = " + num1.charAt(i));
        }
        System.out.println("pobiMax1 = " + pobiMax1);
        System.out.println("pobiMax1_1 = " + pobiMax1_1);
        if (pobiMax1>=pobiMax1_1) {
            pobiLeftMax = pobiMax1;
        }
        if (pobiMax1<pobiMax1_1) {
            pobiLeftMax = pobiMax1_1;
        }

        System.out.println("pobiLeftMax = " + pobiLeftMax);


        //오른쪽 페이지 구하는 거임 +1해야 된다
        int num1_1 = Integer.parseInt(num1) +1;
        String num2 = ""+num1_1;
        System.out.println("num1_1 = " + num1_1);
        System.out.println("num2 = " + num2);
        System.out.println("num2 = " + num2.length());
        for (int i=0; i<num2.length(); i++) {
            pobiMax2 += num2.charAt(i)-48;
            pobiMax2_2 *= num2.charAt(i)-48;
            System.out.println("num2.charAt(i) = " + num2.charAt(i));
        }
        System.out.println("pobiMax2 = " + pobiMax2);
        System.out.println("pobiMax2_2 = " + pobiMax2_2);

        if (pobiMax2 >= pobiMax2_2) {
            pobiRightMax = pobiMax2;
        }
        if (pobiMax2 < pobiMax2_2) {
            pobiRightMax = pobiMax2_2;
        }

        System.out.println("pobiRightMax = " + pobiRightMax);

        if (pobiLeftMax >= pobiRightMax) {
            pobiRealMax = pobiLeftMax;
        }

        if (pobiLeftMax < pobiRightMax) {
            pobiRealMax = pobiRightMax;
        }

        System.out.println("pobiRealMax = " + pobiRealMax);

        String num3 = (int)((Math.random()*400)+1)+"";
        for (int i=0; i<num3.length(); i++) {
            crongMax1 += num3.charAt(i)-48;
            crongMax1_1 *= num3.charAt(i)-48;
        }
        if (crongMax1>=crongMax1_1) {
            crongLeftMax = crongMax1;
        }
        if (crongMax1<crongMax1_1) {
            crongLeftMax = crongMax1_1;
        }
        /////////////////////////
        int num3_3 = Integer.parseInt(num3) +1;
        String num4 = ""+num3_3;

        for (int i=0; i<num4.length(); i++) {
            crongMax2 += num4.charAt(i)-48;
            crongMax2_2 *= num4.charAt(i)-48;
        }

        if (crongMax2 >= crongMax2_2) {
            crongRightMax = crongMax2;
        }
        if (crongMax2 < crongMax2_2) {
            crongRightMax = crongMax2_2;
        }

        if (crongLeftMax >= crongRightMax) {
            crongRealMax = crongLeftMax;
        }

        if (crongLeftMax < crongRightMax) {
            crongRealMax = crongRightMax;
        }

        //answer
        int answer = 0;
        if (pobiRealMax > crongRealMax) {
            answer = 1;
        }
        if (pobiRealMax == crongRealMax) {
            answer = 0;
        }
        if (pobiRealMax < crongRealMax) {
            answer = -1;
        }*/
    }
}