package onboarding.problem1;

public class Calculator {

    // 각 자리수 덧셈 / 곱셈 값 동시에 비교
    public static int getEachNumber(int pageNumber) {
        int eachNumberBySum = 0;
        int eachNumberByMul = 1;

        /**
         * 공통 실행 코드 추출
         * else 키워드 제거
         * result 중복 제거할 것
         */
        while (pageNumber != 0 && pageNumber != 400) {

            eachNumberBySum += pageNumber % 10;
            eachNumberByMul *= pageNumber % 10;

            pageNumber /= 10;
        }

        int result = eachNumberBySum > eachNumberByMul ? eachNumberBySum : eachNumberByMul ;

        return result;
    }
}


