/**
* 클래스 이름
* - 문제 1
*
* 버전정보
 * - jdk-11.0.17
*
* 날짜
* - 2022-10-31
*
*/

package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try{
            /* 예외 처리 */
            processException(pobi, crong);

            // pobi와 crong 각자 가질 수 있는 가장 큰 수 뽑기
            int pobiMaxResult = getMaxResult(pobi);
            int crongMaxResult = getMaxResult(crong);

            // 포비승리
            if(pobiMaxResult>crongMaxResult) return 1;
            // 크롱승리
            else if (pobiMaxResult<crongMaxResult) return 2;
            // 무승부
            else return 0;
        } catch (Exception exception){
            return -1;
        }
    }

    private static void processException(List<Integer> pobi, List<Integer> crong) throws Exception {
        // 책 페이지가 연속되지 않은 경우
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            throw new Exception();
        }
        // 왼쪽페이지가 홀수가 아닌 경우
        if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) {
            throw new Exception();
        }
        // 번호가 범위안에 안들어갈 경우
        if (pobi.get(0) < 1 || pobi.get(1) > 400) {
            throw new Exception();
        }
        // 번호가 범위안에 안들어갈 경우
        if (crong.get(0) < 1 || crong.get(1) > 400) {
            throw new Exception();
        }
    }

    // 가장 큰 수 구하는 메소드 (규칙 2, 3, 4)
    private static int getMaxResult(List<Integer> person) {
        int result = 0;

        for (Integer num : person) {
            int sum = sumNumberOfDigits(num);
            int mul = mulNumberOfDigits(num);
            result = Math.max(result, sum);
            result = Math.max(result, mul);
        }
        return result;
    }

    // 각 자리수 모두 더하는 메소드
    private static int sumNumberOfDigits(Integer number) {
        int result = 0;
        while(number != 0){
            result += number % 10;
            number /= 10;
        }
        return result;
    }
    // 각 자리수 모두 곱하는 메소드
    private static int mulNumberOfDigits(Integer number) {
        int result = 1;
        while(number != 0){
            result *= number % 10;
            number /= 10;
        }
        return result;
    }
}