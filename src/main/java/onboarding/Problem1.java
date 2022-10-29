package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isNotValidPage(pobi)|| isNotValidPage(crong)) {
            return -1;
        }
        int LIST_SIZE = 2;
        int pobiMax = Integer.MIN_VALUE;
        int crongMax = Integer.MIN_VALUE;

        for (int i =0; i < LIST_SIZE; i++) {
            List<Integer> pobiPageDigit = getEachDigit(pobi.get(i));
            List<Integer> crongPageDigit = getEachDigit(crong.get(i));

            pobiMax = Math.max(pobiMax, Math.max(getAdditionTotal(pobiPageDigit), getMultiplicationTotal(pobiPageDigit)));
            crongMax = Math.max(crongMax, Math.max(getAdditionTotal(crongPageDigit), getMultiplicationTotal(crongPageDigit)));
        }

        if(pobiMax > crongMax) return 1;
        if(crongMax > pobiMax) return 2;
        return 0;
    }

    // 각 자리수를 구한다.
    public static List<Integer> getEachDigit(int page) {
        List<Integer> pageDigitList = new ArrayList<>();
        while(page > 0){
            pageDigitList.add(page % 10);
            page /= 10;
        }
        return pageDigitList;
    }

    // 각 자리수의 합을 구한다.
    public static int getAdditionTotal(List<Integer> pageDigitList) {
        int answer = 0;
        for (Integer digit : pageDigitList) {
            answer += digit;
        }
        return answer;
    }

    // 각 자리수의 곱을 구한다.
    public static int getMultiplicationTotal(List<Integer> pageDigitList) {
        int answer = 1;
        for (Integer digit : pageDigitList) {
            answer *= digit;
            if (answer == 0) {
                return 0;
            }
        }
        return answer;
    }

    // 예외 처리 체크
    public static boolean isNotValidPage(List<Integer> user) {
        int leftPage = user.get(0);
        int rightPage = user.get(1);
        boolean isLeftPageOdd = leftPage % 2 == 1;
        boolean isRightPageEven = rightPage % 2 == 0;
        final int firstPage = 1;
        final int lastPage = 400;
        return !isLeftPageOdd || !isRightPageEven || rightPage - leftPage != 1 || leftPage == firstPage || rightPage == lastPage;
    }
}