package onboarding;

import java.awt.*;
import java.util.List;

class Problem1 {

    // 각 자릿수 모두 더하는 함수
    public static int add(int number) {
        int addResult = 0;
        String numberToString = Integer.toString(number);

        for(int i = 0; i < numberToString.length(); i++) {
            char temp = numberToString.charAt(i);
            addResult += Character.getNumericValue(temp);
        }


        return addResult;
    }

    // 각 자릿수 모두 곱하는 함수
    public static int multi(int number) {
        int multiResult = 1;
        String numberToString = Integer.toString(number);

        for(int i = 0; i < numberToString.length(); i++) {
            char temp = numberToString.charAt(i);
            multiResult *= Character.getNumericValue(temp);
        }

        return multiResult;
    }

    // 예외처리 함수
    public static boolean checkExcept(List<Integer> list) {
        if (list.get(0) % 2 == 0) {                     // 왼쪽 페이지가 짝수일 경우
            return false;
        }
        if (list.get(0)+1 != list.get(1)) {             // 오른쪽 페이지가 왼쪽 페이지 +1이 아닐 경우
            return false;
        }
        if (list.get(0) == 1 || list.get(1) == 400) {   // 시작 면이나 마지막 면을 펼칠 경우
            return false;
        }
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!checkExcept(pobi)) {
            answer = -1;
        } else if (!checkExcept(crong)) {
            answer = -1;
        } else {
            int pobiLeftNumber = Math.max(add(pobi.get(0)), multi(pobi.get(0)));
            int pobiRightNumber = Math.max(add(pobi.get(1)), multi(pobi.get(1)));
            int pobiNumber = Math.max(pobiLeftNumber, pobiRightNumber);

            int crongLeftNumber = Math.max(add(crong.get(0)), multi(crong.get(0)));
            int crongRightNumber = Math.max(add(crong.get(1)), multi(crong.get(1)));
            int crongNumber = Math.max(crongLeftNumber, crongRightNumber);

            if (pobiNumber > crongNumber) {
                answer = 1;
            } else if (pobiNumber < crongNumber) {
                answer = 2;
            } else {
                answer = 0;
            }
        }

       return answer;
    }
}
