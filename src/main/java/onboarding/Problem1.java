package onboarding;

import java.util.List;

class Problem1 {

    // 두수 중 더 큰 값을 반환하는 메서드
    // 같은 값이면 첫 번째 파라미터를 반환한다.
    public static int whichIsMaxValue(int value1, int value2) {
        if (value1 > value2) {
            return value1;
        } else if (value1 < value2) {
            return value2;
        }
        return value1;
    }

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
        // 왼쪽, 오른쪽 페이지 자릿수 합의 값이 같으면 둘 중 아무거나 반환한다.
        return whichIsMaxValue(sumLeftValue, sumRightValue);
    }

    // 페이지 자릿수 곱을 구하는 메서드
    // 마찬가지로 왼쪽 페이지, 오른쪽 페이지 모두 구한다.
    public static int multiplyPlaceValue(List<Integer> pageList) {
        String leftPage = String.valueOf(pageList.get(0));
        int leftPageLength = leftPage.length();

        String rightPage = String.valueOf(pageList.get(1));
        int rightPageLength = rightPage.length();

        // 곱셈을 위한 변수의 초기값은 0으로 초기화 시 곱셈 연산이 적용되지 않으므로 자릿수 맨 앞의 수를 지정한다.
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

        // 왼쪽, 오른쪽 페이지 자릿수 곱의 값이 같으면 둘 중 아무거나 반환한다.
        return whichIsMaxValue(multiplyLeftValue, multiplyRightValue);
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
}