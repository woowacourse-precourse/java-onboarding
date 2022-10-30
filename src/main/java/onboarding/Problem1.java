package onboarding;

import java.util.List;

class Problem1 {
    /** n의 각 자릿수의 합/곱 중 최대값 구하기 */
    public static int getMaxValueBetweenSumAndMul(int n) {
        int sumValue = 0;                       // 각 자릿수의 합 결과값
        int mulValue = 1;                       // 각 자릿수의 곱 결과값

        while (0 < n) {                         // -> n의 모든 자릿수를 계산할 때까지
            sumValue += n % 10;                 // 가장 오른쪽 자릿수의 숫자 합셈
            mulValue *= n % 10;                 // 가장 오른쪽 자릿수의 숫자 곱셈
            n /= 10;                            // n을 10으로 나눈 몫으로 갱신
        }

        return Math.max(sumValue, mulValue);    // 각 자릿수의 합/곱 중 가장 큰 수 return
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /* 제한사항
         * 1) 페이지 번호가 1부터 시작되는 400페이지의 책이다.
         * 2) 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수여야 한다.
         * 3) 시작면이나 마지막 면이 나오도록 책을 펼치지 않는다.
         */
        int answer = Integer.MAX_VALUE;
        int pobiLeftPage = pobi.get(0);         // Pobi Left Page
        int pobiRightPage = pobi.get(1);        // Pobi Right Page
        int crongLeftPage = crong.get(0);       // Crong Left Page
        int crongRightPage = crong.get(1);      // Crong Right Page
        try {
            if ((1 <= pobiLeftPage && pobiLeftPage <= 400) &&               // Pobi, Left Page의 범위가 1 ~ 400 이고
                    (1 <= pobiRightPage && pobiRightPage <= 400) &&         // Pobi, Right Page의 범위가 1 ~ 400 이고
                    (1 <= crongLeftPage && crongLeftPage <= 400) &&         // Crong, Left Page의 범위가 1 ~ 400 이고
                    (1 <= crongRightPage && crongRightPage <= 400)) {       // Crong, Right Page의 범위가 1 ~ 400 이면,
                if ((pobiLeftPage % 2 == 1 && pobiRightPage % 2 == 0) &&            // Pobi, Left Page가 홀수, Right Page가 짝수이고
                        (crongLeftPage % 2 == 1 && crongRightPage % 2 == 0)) {      // Crong, Left Page가 홀수, Right Page가 짝수이면,
                    if ((pobiLeftPage < pobiRightPage) &&                           // Pobi, Left Page < Pobi Right Page 이고
                            (crongLeftPage < crongRightPage) &&                     // Crong, Left Page < Crong Right Page 이고
                            (Math.abs(pobiLeftPage - pobiRightPage) == 1) &&        // Pobi, Left Page와 Right Page가 연속된 숫자이고
                            (Math.abs(crongLeftPage - crongRightPage) == 1)) {      // Crong, Left Page와 Right Page가 연속된 숫자이면
                        int pobiMaxValueLeft = getMaxValueBetweenSumAndMul(pobi.get(0));            // Pobi, 왼쪽 페이지 각 자릿수의 합/곱 중 최대값
                        int pobiMaxValueRight = getMaxValueBetweenSumAndMul(pobi.get(1));           // Pobi, 오른쪽 페이지 각 자릿수의 합/곱 중 최대값
                        int crongMaxValueLeft = getMaxValueBetweenSumAndMul(crong.get(0));          // Crong, 왼쪽 페이지 각 자릿수의 합/곱 중 최대값
                        int crongMaxValueRight = getMaxValueBetweenSumAndMul(crong.get(1));         // Crong, 오른쪽 페이지 각 자릿수의 합/곱 중 최대값

                        int pobiMaxValue = Math.max(pobiMaxValueLeft, pobiMaxValueRight);           // Pobi, 왼쪽/오른쪽 페이지의 각 자릿수의 합/곱 중 최대값
                        int crongMaxValue = Math.max(crongMaxValueLeft, crongMaxValueRight);        // Crong, 왼쪽/오른쪽 페이지의 각 자릿수의 합/곱 중 최대값

                        if (pobiMaxValue == crongMaxValue) {            // 무승부이면
                            answer = 0;                                 // answer = 0;
                        } else if (pobiMaxValue > crongMaxValue) {      // 포비가 이긴다면
                            answer = 1;                                 // answer = 1;
                        } else if (pobiMaxValue < crongMaxValue) {      // 크롱이 이긴다면
                            answer = 2;                                 // answer = 2;
                        }
                    }
                }
            }
        } catch (Exception e) {     // 시작면이나 마지막면 등이 null 등의 값으로 입력되는 등 오류가 발생한다면
            answer = -1;            // answer = -1;
        } finally {
            if (answer == Integer.MAX_VALUE) {      // 그 외 예외사항에 의해 answer 값이 갱신되지 않았다면
                answer = -1;                        // answer = -1;
            }
        }

        return answer;
    }
}