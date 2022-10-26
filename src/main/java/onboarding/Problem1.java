package onboarding;

import java.util.List;

class Problem1 {
    /*
        기능 요구 사항 목록
        1. 예외사항 확인 함수
        2. 자릿수 합과 곱 중 큰 값을 반환하는 함수
        3. solution (왼쪽·오른쪽 비교, 승자 선정)
    */

    // 예외사항 확인 함수
    private static boolean correctGiven(List<Integer> given) {
        // 연속적인 수가 주어졌는지 확인
        if (given.get(0) + 1 != given.get(1))
            return false;

        // 첫 면, 마지막 면이 주어졌는지 확인
        for (int i : given) {
            if ((i == 1) || (i == 400))
                return false;
        }

        return true;
    }

    // 자릿수 합과 곱 중 큰 값을 반환하는 함수
    private static int sumOrProduct(int number) {
        int addResult = 0;
        int multiplyResult = 1;

        String numString = Integer.toString(number);
        for (int i = 0; i < numString.length(); i++) {
            char digitChar = numString.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            addResult += digit;         // 덧셈
            multiplyResult *= digit;    // 곱셈
        }

        return Math.max(addResult, multiplyResult);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 페이지 변수 설정
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        // 예외사항 확인
        if (!correctGiven(pobi) || !correctGiven(crong))
            return -1;

        // 포비의 왼쪽 오른쪽 중 큰 값
        int pobiLeft = sumOrProduct(pobiLeftPage);
        int pobiRight = sumOrProduct(pobiRightPage);
        int pobiResult = Math.max(pobiLeft, pobiRight);

        // 크롱의 왼쪽 오른쪽 중 큰 값
        int crongLeft = sumOrProduct(crongLeftPage);
        int crongRight = sumOrProduct(crongRightPage);
        int crongResult = Math.max(crongLeft, crongRight);

        // 승자 선정
        if (pobiResult > crongResult)
            return 1;   // 포비 승
        else if (pobiResult < crongResult)
            return 2;   // 크롱 승
        else
            return 0;   // 무승부
    }
}