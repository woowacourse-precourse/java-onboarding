package onboarding;

import java.util.ArrayList;
import java.util.List;

/*

[기능 목록]
1. 두 수 중 더 큰값을 반환하는 메서드
2. 페이지 자릿수 합을 구하는 메서드
3. 페이지 자릿수 곱을 구하는 메서드
4. 자릿수의 합과 곱 둘 중 큰 값이 무엇인지 구하는 메서드
5. 포비의 최대 자릿수 값과 크롱의 최대 자릿수 값을 비교하여 요구사항에 맞춰 반환하는 메서드
6. 예외처리를 위한 메서드 (왼쪽페이지 - 오른쪽 페이지 가 -1 보다 큰 값이 나오는 경우는 잘못 펼친 것)

 */

class Problem1 {

    // 페이지 자릿수 합을 구하는 메서드
    // 왼쪽 페이지의 최댓값은 배제하고, 오른쪽 페이지의 최댓값만 구해서 최댓값으로 정할까 했지만
    // 왼쪽 페이지가 299, 오른쪽 페이지가 300 이면 왼쪽이 더 클 수 밖에 없다.
    // 그래서 전부 다 비교하기로 했다.
    public static int sumPlaceValue(List<Integer> pageList) {
        String leftPage = String.valueOf(pageList.get(0));
        int leftPageLength = leftPage.length();

        String rightPage = String.valueOf(pageList.get(1));
        int rightPageLength = rightPage.length();
        
        int sumLeftValue = 0;
        int sumRightValue = 0;

        // 왼쪽 페이지 자릿수 합
        for (int i = 0; i < leftPageLength; i++) {
            sumLeftValue += Integer.parseInt(String.valueOf(leftPage.charAt(i)));
        }

        // 오른쪽 페이지 자릿수 합
        for (int i = 0; i < rightPageLength; i++) {
            sumRightValue += Integer.parseInt(String.valueOf(rightPage.charAt(i)));
        }

        // 자릿수 합의 최댓값 리턴
        if (sumLeftValue > sumRightValue) {
            return sumLeftValue;
        } else if (sumLeftValue < sumRightValue) {
            return sumRightValue;
        }

        // 왼쪽, 오른쪽 페이지 자릿수 합의 값이 같으면 둘 중 아무거나 반환한다.
        return sumLeftValue;
    }

    // 페이지 자릿수 곱을 구하는 메서드
    // 마찬가지로 왼쪽 페이지, 오른쪽 페이지 모두 구한다.
    public static int multiplyPlaceValue(List<Integer> pageList) {
        String leftPage = String.valueOf(pageList.get(0));
        int leftPageLength = leftPage.length();

        String rightPage = String.valueOf(pageList.get(1));
        int rightPageLength = rightPage.length();

        int multiplyLeftValue = Integer.parseInt(String.valueOf(leftPage.charAt(0)));
        int multiplyRightValue = Integer.parseInt(String.valueOf(rightPage.charAt(0)));

        // 왼쪽 페이지 자릿수 곱
        for (int i = 1; i < leftPageLength; i++) {
            multiplyLeftValue *= Integer.parseInt(String.valueOf(leftPage.charAt(i)));
        }

        // 오른쪽 페이지 자릿수 곱
        for (int i = 1; i < rightPageLength; i++) {
            multiplyRightValue *= Integer.parseInt(String.valueOf(rightPage.charAt(i)));
        }

        // 자릿수 곱의 최댓값 리턴
        if (multiplyLeftValue > multiplyRightValue) {
            return multiplyLeftValue;
        } else if (multiplyLeftValue < multiplyRightValue) {
            return multiplyRightValue;
        }

        // 왼쪽, 오른쪽 페이지 자릿수 곱의 값이 같으면 둘 중 아무거나 반환한다.
        return multiplyLeftValue;
    }

    // 자릿수의 합과 곱 둘 중 큰 값이 무엇인지 구하는 메서드
    public static int compareWithSumVersusMultiply(int sumValue, int multiplyValue) {
        if (sumValue > multiplyValue) {
            return sumValue;
        } else if (sumValue < multiplyValue) {
            return multiplyValue;
        }

        // 만약 자릿수의 합과 곱의 크기가 같으면 아무거나 리턴한다. (예외처리 해야할 수도)
        return sumValue;
    }

    // 포비의 최대 자릿수 값과 크롱의 최대 자릿수 값을 비교하여
    // 요구사항에 맞춰 반환하기
    public static int pobiVersusCrong(int pobiValue, int crongValue) {
        if (crongValue == pobiValue) {
            return 0;
        }
        else if (crongValue < pobiValue) {
            return 1;
        }
        else if (crongValue > pobiValue) {
            return 2;
        }
        return -1;
    }
    
    // 예외처리를 위한 메서드
    public static boolean isException(List<Integer> pageList) {
        // 두 페이지 값을 뺏을 때 그 값이 1 이상 차이가 나면 잘못 펼친것이므로 예외
        if (pageList.get(0) - pageList.get(1) != -1) {
            return true;
        }
        return false;
    }

    // 기본 Solution 메서드
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외 조건이 아닐 때
        if (!isException(pobi) && !isException(crong)) {
            int pobiValue = compareWithSumVersusMultiply(
                    sumPlaceValue(pobi), multiplyPlaceValue(pobi));

            int crongValue = compareWithSumVersusMultiply(
                    sumPlaceValue(crong), multiplyPlaceValue(crong));

            return pobiVersusCrong(pobiValue, crongValue);
        }
        return -1;
    }

    public static void main(String[] args) {

        List<Integer> pobi = new ArrayList<>();
        pobi.add(97);
        pobi.add(98);

        List<Integer> pobi2 = new ArrayList<>();
        pobi2.add(131);
        pobi2.add(132);

        List<Integer> pobi3 = new ArrayList<>();
        pobi3.add(99);
        pobi3.add(102);

        List<Integer> crong = new ArrayList<>();
        crong.add(197);
        crong.add(198);

        List<Integer> crong2 = new ArrayList<>();
        crong2.add(211);
        crong2.add(212);

        List<Integer> crong3 = new ArrayList<>();
        crong2.add(211);
        crong2.add(212);

        System.out.println(solution(pobi, crong));
        System.out.println(solution(pobi2, crong2));
        System.out.println(solution(pobi3, crong3));
    }
}