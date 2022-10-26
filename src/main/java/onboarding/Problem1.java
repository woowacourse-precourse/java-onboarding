package onboarding;

import java.util.List;

class Problem1 {

    /**
     * 기능 목록
     * 1. 페이지 번호의 각 자리 숫자 모두 더하기
     * 2. 페이지 번호의 각 자리 숫자 모두 곱하기
     * 3. 숫자 비교 후 큰 수 구하기
     * 4. 점수 비교 후 게임 승자 결정
     * 5. 예외 사항
     */

    /**
     * 1. 페이지 번호의 각 자리 숫자 모두 더하기
     * @param page : 페이지 번호
     * @return : 페이지 각 자릿수 더한 값
     */
    static int add(Integer page){
        int sum = 0;
        while(page != 0){
            sum += (page % 10);
            page /= 10;
        }

        return sum;
    }

    /**
     * 2. 페이지 번호의 각 자리 숫자 모두 곱하기
     * @param page : 페이지 번호
     * @return : 페이지 각 자릿수 곱한 값
     */
    static int multiply(Integer page){
        int sum = 1;
        while(page != 0){
            sum *= (page % 10);
            page /= 10;
        }

        return sum;
    }

    /**
     * 3. 숫자 비교 후 큰 수 구하기
     * @param a : 타켓 a
     * @param b : 타겟 b
     * @return : 큰 값
     */
    static int compare(Integer a, Integer b){
        return a > b ? a : b;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}