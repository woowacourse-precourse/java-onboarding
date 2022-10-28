package onboarding.problem1;

public class Calculator {

    public static int getEachNumber(int pageNumber) {
        int eachNumberBySum = 0; // 중복 x 지점
        int eachNumberByMul = 1; // 중복 x 지점
        int result = 0;

        // 리팩토링 : 공통 실행 코드 빼내기
        while (pageNumber != 0 && pageNumber != 400) {
            eachNumberBySum += pageNumber % 10;
            eachNumberByMul *= pageNumber % 10;

            pageNumber /= 10;
        }

        if (eachNumberBySum > eachNumberByMul) {
            result = eachNumberBySum;
        } else {
            result = eachNumberByMul;
        }
        return result;
    }
}


