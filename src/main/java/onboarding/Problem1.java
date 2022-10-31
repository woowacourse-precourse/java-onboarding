package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 pb1 = new Problem1();
        if(pb1.isNotValidPage(pobi)|| pb1.isNotValidPage(crong)) {
            return -1;
        }
        int LIST_SIZE = 2;
        int pobiMax = Integer.MIN_VALUE;
        int crongMax = Integer.MIN_VALUE;

        for (int i =0; i < LIST_SIZE; i++) {
            List<Integer> pobiPageDigit = pb1.getEachDigit(pobi.get(i));
            List<Integer> crongPageDigit = pb1.getEachDigit(crong.get(i));
            pobiMax = pb1.getMaximumValue(pobiPageDigit);
            crongMax = pb1.getMaximumValue(crongPageDigit);
        }

        if(pobiMax > crongMax) return 1;
        if(crongMax > pobiMax) return 2;
        return 0;
    }

    // 각 자리수를 구한다.
    public List<Integer> getEachDigit(int page) {
        List<Integer> pageDigitList = new ArrayList<>();
        while(page > 0){
            pageDigitList.add(page % 10);
            page /= 10;
        }
        return pageDigitList;
    }

    // 각 자리수의 합을 구한다.
    public int getAdditionTotal(List<Integer> pageDigitList) {
        int answer = 0;
        for (Integer digit : pageDigitList) {
            answer += digit;
        }
        return answer;
    }

    // 각 자리수의 곱을 구한다.
    public int getMultiplicationTotal(List<Integer> pageDigitList) {
        int answer = 1;
        for (Integer digit : pageDigitList) {
            answer *= digit;
            if (answer == 0) {
                return 0;
            }
        }
        return answer;
    }
    // 합과 곱 중 최댓값을 구한다.
    public int getMaximumValue(List<Integer> pageDigit) {
        int additionValue = getAdditionTotal(pageDigit);
        int multiplicationValue = getMultiplicationTotal(pageDigit);
        return Math.max(additionValue, multiplicationValue);
    }

    // 예외 처리 체크
    public boolean isNotValidPage(List<Integer> user) {
        int leftPage = user.get(0);
        int rightPage = user.get(1);
        boolean isLeftPageOdd = leftPage % 2 == 1;
        boolean isRightPageEven = rightPage % 2 == 0;
        final int firstPage = 1;
        final int lastPage = 400;
        return !isLeftPageOdd || !isRightPageEven || rightPage - leftPage != 1 || leftPage == firstPage || rightPage == lastPage;
    }
}