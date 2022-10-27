package onboarding;

import java.util.ArrayList;
import java.util.List;

/** 기능 목록
 * method 1 : 각 자리 숫자 합 반환
 * method 2 : 각 자리 숫자 곱 반환
 * method 3 : 곱과 합 중 가장 큰 값 반환
 * method 4 : 숫자를 각 자리의 수의 배열로 반환
 * method 5 : 예외 상황 체크
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    public static int numSum(int num) {

    }

    public static int numMulti(int num) {

    }

    public static int maxResult(int num){

    }

    public static List<Integer> numToDigits(int num){
        List<Integer> output = new ArrayList<>();
        while (num != 0) {
            output.add(num % 10);
            num = num/10;
        }
        return output;
    }

    public static boolean checkValid(List<Integer> pobi, List<Integer> crong) { // 각 배열의 길이, 페이지 번호 확인

    }

}