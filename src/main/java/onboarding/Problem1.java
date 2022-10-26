package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 가장 큰 수를 구하는 기능을 하는 함수
    public static int getMaxNumber (Integer leftPageNum, Integer rightPageNum) {
        int leftPageMaxNum = calcMax(getSumPageNum(leftPageNum), getMultiplyPageNum(leftPageNum));
        int rightPageMaxNum = calcMax(getSumPageNum(leftPageNum), getMultiplyPageNum(leftPageNum));

        return calcMax(leftPageMaxNum, rightPageMaxNum);
    }

    // 페이지 번호의 각 자리 숫자를 모두 더하는 기능을 하는 함수
    public static int getSumPageNum(Integer pageNum){
        int sum = 0;
        while (pageNum > 0) {
            sum += pageNum % 10;
            pageNum /= 10;
        }
        return sum;
    }

    // 페이지 번호의 각 자리 숫자를 모두 곱하는 기능을 하는 함수
    public static int getMultiplyPageNum(Integer pageNum) {
        int mul = 1;
        while (pageNum > 0) {
            mul *= pageNum % 10;
            pageNum /= 10;
        }
        return mul;
    }

    // 두 수 중 큰 수를 반환하는 기능을 하는 함수
    public static int calcMax(Integer num1, Integer num2) {
        return Math.max(num1, num2);
    }
}