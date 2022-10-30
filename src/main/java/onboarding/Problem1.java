package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!listIsValid(pobi) || !listIsValid(crong)) {
            return -1;
        }

        int pobiResult = 0;    //포비의 점수
        int crongResult = 0;    //크롱의 점수

        if(getMax(pobi.get(0)) >= getMax(pobi.get(1))) {
            pobiResult = getMax(pobi.get(0));
        }
        if(getMax(pobi.get(0)) < getMax(pobi.get(1))) {
            pobiResult = getMax(pobi.get(1));
        }

        if(getMax(crong.get(0)) >= getMax(crong.get(1))) {
            crongResult = getMax(crong.get(0));
        }
        if(getMax(crong.get(0)) < getMax(crong.get(1))) {
            crongResult = getMax(crong.get(1));
        }

        //포비가 이긴 경우
        if(pobiResult > crongResult) {
            return 1;
        }
        //크롱이 이긴 경우
        if(pobiResult < crongResult) {
            return 2;
        }
        return 0;

    }

    /**
     * 리스트가 예외사항을 가지는지 체크 메서드(뒤에 정의한 여러 체크 메서드등을 포함하는 메서드)
     * 리스트가 올바른 값일때 true 반환, 예외사항을 가질때 false 반환
     */
    private static boolean listIsValid(List<Integer> integerList) {
        if(!sizeCheck(integerList)) {
            return false;
        }
        if(!leftValueCheck(integerList)) {
            return false;
        }
        if(!listValueCheck(integerList)) {
            return false;
        }
        return true;
    }

    /**
     * 리스트의 사이즈가 2인지 체크하는 메서드
     * 사이즈가 2이면 true 반환, 이외에는 false 반환
     */
    private static boolean sizeCheck(List<Integer> integerList) {
        return (integerList.size() == 2 ? true:false);
    }

    /**
     * 리스트의 왼쪽 페이지가 오른쪽 페이지보다 1만큼 작은지 체크 메서드
     * 올바른 값일때 true 반환, 이외에는 false 반환
     */
    public static boolean listValueCheck(List<Integer> integerList) {
        int result = integerList.get(1) - integerList.get(0);
        return (result == 1 ? true:false);
    }

    /**
     * 리스트의 왼쪽 페이지가 홀수인지 체크 메서드
     * 홀수일때 true 반환, 홀수가 아닐때 false 반환
     */
    private static boolean leftValueCheck(List<Integer> integerList) {
        Integer result = integerList.get(0);

        return (result % 2 == 1 ? true:false);
    }

    /**
     * 각자리 숫자합과 곱중 큰 수 반환 메서드
     */
    private static int getMax(Integer value) {
        int resultSum = getSum(value);
        int resultMultiple = getMultiple(value);

        return ((resultSum > resultMultiple)? resultSum:resultMultiple);
    }

    /**
     * 각자리 숫자합 반환 메서드
     */
    private static int getSum(Integer value) {
        int sumParameter1 = value / 100;    //첫번째 자릿수, 세자리 수가 안될때 0
        int sumParameter2 = (value - (sumParameter1 * 100)) / 10;   //두번쨰 자릿수, 두자리 수가 안될때 0
        int sumParameter3 = (value - ((sumParameter1 * 100) + (sumParameter2 * 10)));

        return (sumParameter1 + sumParameter2 + sumParameter3);
    }

    /**
     * 각자리 곱의 합 반환 메서드
     */
    private static int getMultiple(Integer value) {
        int multipleParameter1 = value / 100;    //첫번째 자릿수, 세자리 수가 안될때 0
        int multipleParameter2 = (value - (multipleParameter1 * 100)) / 10;   //두번쨰 자릿수, 두자리 수가 안되거나 0일때 0
        int multipleParameter3 = (value - ((multipleParameter1 * 100) + (multipleParameter2 * 10)));

        // 세자리 수 일때
        if(getDigits(value) == 3) {
            return (multipleParameter1 * multipleParameter2 * multipleParameter3);
        }
        // 두자리 수 일때
        if(getDigits(value) == 2) {
            return (multipleParameter2 * multipleParameter3);
        }
        // 한자리 수 일때
        return multipleParameter3;

    }

    /**
     * 몇 자리 수 인지 반환 메서드
     */
    private static int getDigits(Integer value) {
        // 세자리 수가 아닐때
        if(value / 100 == 0) {
            return getDigitsDetails(value);
        }
        return 3;
    }

    /**
     * 세 자릿수가 아닐때 자릿수 반환 메서드
     */
    private static int getDigitsDetails(Integer value) {
        // 한자리 수 일때
        if (value / 10 == 0) {
            return 1;
        }
        return 2;   //두자리 수 일때
    }


}