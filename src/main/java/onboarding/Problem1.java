package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* 1. 결과 비교를 위한 변수 생성.
* 2. pobi와 crong의 index에 접근해서 index 값 잘라서 더하기, 곱하기 후 1번에서 생성한 변수에 저장.
* 3. 값 비교 후 answer에 요구 사항 조건에 따라 값 저장.
* 4. 예외 사항
* */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiSumLeft = 0;
        int pobiMulLeft = 1;
        int pobiSumRight = 0;
        int pobiMulRight = 1;
        int pobiCompareLeft = 0;
        int pobiCompareRight = 0;
        int pobiResult = 0;

        int crongSumLeft = 0;
        int crongMulLeft = 1;
        int crongSumRight = 0;
        int crongMulRight = 1;
        int crongCompareLeft = 0;
        int crongCompareRight = 0;
        int crongResult = 0;

        int answer = Integer.MAX_VALUE;

        if ((pobi.get(1) - pobi.get(0)) >= 2) {
            answer = answer + Integer.MIN_VALUE; // 예외 사항
            return answer;
        }
        if ((crong.get(1) - crong.get(0)) >= 2) {
            answer = answer + Integer.MIN_VALUE; // 예외 사항
            return answer;
        }

        for (int i = 0; i < pobi.size(); i++) {
            String getPobiIndex = Integer.toString(pobi.get(i));
            for (int j = 0; j < getPobiIndex.length(); j++) {
                int pobiTemp = Character.getNumericValue(getPobiIndex.charAt(j));
                if (i == 0) {
                    pobiSumLeft += pobiTemp;
                    pobiMulLeft *= pobiTemp;
                } else {
                    pobiSumRight += pobiTemp;
                    pobiMulRight *= pobiTemp;
                }
            }
        }

        for (int i = 0; i < crong.size(); i++) {
            String getCrongIndex = Integer.toString(crong.get(i));
            for (int j = 0; j < getCrongIndex.length(); j++) {
                int crongTemp = Character.getNumericValue(getCrongIndex.charAt(j));
                if (i == 0) {
                    crongSumLeft += crongTemp;
                    crongMulLeft *= crongTemp;
                } else {
                    crongSumRight += crongTemp;
                    crongMulRight *= crongTemp;
                }
            }
        }

        pobiCompareLeft = Math.max(pobiSumLeft, pobiMulLeft);
        pobiCompareRight = Math.max(pobiSumRight, pobiMulRight);

        crongCompareLeft = Math.max(crongSumLeft, crongMulLeft);
        crongCompareRight = Math.max(crongSumRight, crongMulRight);

        pobiResult = Math.max(pobiCompareLeft, pobiCompareRight);
        crongResult = Math.max(crongCompareLeft, crongCompareRight);

        if (pobiResult == crongResult) {
            answer = answer - Integer.MAX_VALUE; // 무승부
        } else if (pobiResult > crongResult) {
            answer = answer - Integer.MIN_VALUE + 2; // 포비 승
        } else {
            answer = answer - Integer.MIN_VALUE + 3; // 크롱 승
        }

        return answer;
    }
}