package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int result = 0;

        int pobiPage1 = pobi.get(0);
        int pobiPage2 = pobi.get(1);
        List<Integer> pobiNum1 = new ArrayList<>();
        List<Integer> pobiNum2 = new ArrayList<>();
        int pobiPlusNumber1 = 0;
        int pobiPlusNumber2 = 0;
        int pobiMultipleNumber1 = 1;
        int pobiMultipleNumber2 = 1;
        List<Integer> pobiNumberList = new ArrayList<>();
        int pobiNumber;

        int crongPage1 = crong.get(0);
        int crongPage2 = crong.get(1);
        List<Integer> crongNum1 = new ArrayList<>();
        List<Integer> crongNum2 = new ArrayList<>();
        int crongPlusNumber1 = 0;
        int crongPlusNumber2 = 0;
        int crongMultipleNumber1 = 1;
        int crongMultipleNumber2 = 1;
        List<Integer> crongNumberList = new ArrayList<>();
        int crongNumber;

        int gameEnd = 0;

        /******************* 포비 책 페이지를 계산 *******************/
        // 첫 번째 페이지의 숫자를 한 자리씩 pobiNum1 배열에 추가하기
        while (pobiPage1 > 0) {
            pobiNum1.add(pobiPage1 % 10);
            pobiPage1 /= 10;
        }

        // 첫 번째 페이지의 숫자를 한 자리씩 pobiNum2 배열에 추가하기
        while (pobiPage2 > 0) {
            pobiNum2.add(pobiPage2 % 10);
            pobiPage2 /= 10;
        }


        // 덧셈, 곱셈 계산하기
        // 첫 번째 페이지 덧셈
        for (int i = 0; i < pobiNum1.size(); i++) {
            pobiPlusNumber1 += pobiNum1.get(i);
        }
        // 첫 번째 페이지 곱셈
        for (int i = 0; i < pobiNum1.size(); i++) {
            pobiMultipleNumber1 *= pobiNum1.get(i);
        }

        // 두 번째 페이지 덧셈
        for (int i = 0; i < pobiNum2.size(); i++) {
            pobiPlusNumber2 += pobiNum2.get(i);
        }
        // 두 번째 페이지 곱셈
        for (int i = 0; i < pobiNum2.size(); i++) {
            pobiMultipleNumber2 *= pobiNum2.get(i);
        }


        /******************* 크롱 책 페이지를 계산 *******************/
        // 첫 번째 페이지의 숫자를 한 자리씩 crongNum1 배열에 추가하기

        while (crongPage1 > 0) {
            crongNum1.add(crongPage1 % 10);
            crongPage1 /= 10;
        }

        // 첫 번째 페이지의 숫자를 한 자리씩 crongNum2 배열에 추가하기
        while (crongPage2 > 0) {
            crongNum2.add(crongPage2 % 10);
            crongPage2 /= 10;
        }

        // 덧셈, 곱셈 계산하기
        // 첫 번째 페이지 덧셈
        for (int i = 0; i < crongNum1.size(); i++) {
            crongPlusNumber1 += crongNum1.get(i);
        }
        // 첫 번째 페이지 곱셈
        for (int i = 0; i < crongNum1.size(); i++) {
            crongMultipleNumber1 *= crongNum1.get(i);
        }

        // 두 번째 페이지 덧셈
        for (int i = 0; i < crongNum2.size(); i++) {
            crongPlusNumber2 += crongNum2.get(i);
        }

        // 두 번째 페이지 곱셈
        for (int i = 0; i < crongNum2.size(); i++) {
            crongMultipleNumber2 *= crongNum2.get(i);
        }


        /******************* 계산된 값 배열에 추가하기 *******************/

        pobiNumberList.add(pobiPlusNumber1);
        pobiNumberList.add(pobiPlusNumber2);
        pobiNumberList.add(pobiMultipleNumber1);
        pobiNumberList.add(pobiMultipleNumber2);

        crongNumberList.add(crongPlusNumber1);
        crongNumberList.add(crongPlusNumber2);
        crongNumberList.add(crongMultipleNumber1);
        crongNumberList.add(crongMultipleNumber2);

        pobiNumber = Collections.max(pobiNumberList);
        crongNumber = Collections.max(crongNumberList);

        /******************* 비교하기 *******************/
        // 예외 사항 -1

        crongPage1 = crong.get(0);
        crongPage2 = crong.get(1);
        pobiPage1 = pobi.get(0);
        pobiPage2 = pobi.get(1);

        // 시작 페이지나 마지막 페이지가 나온 경우
        if (pobiPage1 == 1 || crongPage1 == 1 || pobiPage2 == 1 || crongPage2 == 1 ||
                pobiPage1 == 400 || crongPage1 == 400 || pobiPage2 == 400 || crongPage2 == 400) {
            gameEnd++;
            result = -1;
        }

        // 왼쪽 페이지 번호와 오른쪽 페이지 번호가 순서대로 들어있지 않는 경우
        if (pobiPage2 != pobiPage1 + 1 || crongPage2 != crongPage1 + 1) {
            gameEnd++;
            result = -1;
        }

        // 왼쪽 페이지가 짝수, 오른쪽 페이지가 홀수인 경우
        if (pobiPage1 % 2 == 0 || pobiPage2 % 2 != 0 || crongPage1 % 2 == 0 || crongPage2 % 2 != 0) {
            gameEnd++;
            result = -1;
        }

        // 포비 승 1, 크롱 승 2, 무승부 0

        if (pobiNumber > crongNumber && gameEnd == 0) {
            result = 1;
        }

        if (pobiNumber < crongNumber && gameEnd == 0) {
            result = 2;
        }

        if (pobiNumber == crongNumber && gameEnd == 0) {
            result = 0;
        }

        return result;
    }
}