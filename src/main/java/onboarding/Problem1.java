/*
 * 우테코 1주차 프리코스 미션 - 문제 1
 * [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM1.md]
 *
 * */
package onboarding;

import java.util.List;

/**
 * checkPage : 전달받은 페이지 번호의 예외사항 확인하는 메소드
 * maxNum : 각 페이지 번호의 각 자리 숫자를 모두 더하거나 곱해서 가장 큰 수를 구하는 메소드
 **/

class Problem1 {
    public static int checkPage (List<Integer> pages){
        if (pages.get(1) - pages.get(0) != 1) {
            return -1;          // 연속된 숫자가 아닐 경우 예외
        } else if (pages.get(0) < 0 || pages.get(0) > 400) {
            return -1;          // 왼쪽 페이지 기준, 책의 범위를 벗어날 경우 예외
        }
        return 0;
    }

    public static int maxNum (List<Integer> pages) {
        /* 예외 사항 처리 */
        if (checkPage(pages) == -1) {
            return -1;
        }

        int addVal = 0;
        int multiplyVal = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < pages.size(); i++) {
            int tmp = pages.get(i);

            while (tmp != 0) {
                addVal += tmp % 10;        // 각 자리 숫자 더해주기
                multiplyVal *= tmp % 10;   // 각 자리 숫자 곱해주기
                tmp /= 10;
            }

            /* 더한 값과 곱한 값 중 더 큰 수 선정 */
            if (addVal > multiplyVal) {
                if (max < addVal) {
                    max = addVal;
                }
            } else if (max < multiplyVal) {
                max = multiplyVal;
            }

            addVal = 0;
            multiplyVal = 1;
        }

        return max;
    }

    public static int solution (List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiNum = maxNum(pobi);
        int crongNum = maxNum(crong);

        if (pobiNum == -1 || crongNum == -1) {
            answer = -1;    //  예외
        }else if (pobiNum > crongNum) {
            answer = 1;     // pobi 승
        } else if (pobiNum < crongNum) {
            answer = 2;     // crong 승
        } else if(pobiNum == crongNum) {
            answer = 0;     // 무승부
        }

        return answer;
    }
}