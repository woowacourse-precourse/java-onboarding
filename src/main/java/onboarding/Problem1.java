/**
 * 왼쪽, 오른쪽 각각 조건에 맞춰 큰 수를 구한 후 가장 큰 수로 대결한다.
 * 포비 : 1, 크롱 : 2, 무승부 : 0, 예외사항 : -1
 * 에외사항)
 *  1. 책 왼쪽, 오른쪽 페이지 차이 > 1
 *  2. 페이지 왼쪽이 1 or 페이지 오른쪽 400
 *  3. 페이지 왼쪽이 짝수 or 페이지 오른쪽 홀수
 *  4. 페이지 왼쪽 숫자 >= 페이지 오른쪽 숫자
 */

package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(isPossible(pobi) && isPossible(crong)){
            answer = compare(pobi, crong);
        }
        else{
            answer = -1;
        }

        return answer;
    }

    // 기능 요구사항 2,3 - plus, multiply, calculate_max

    // 페이지 숫자를 더한다.
    static int plus(int num){
        int result = 0; // 더한 결과 값
        String string_num = String.valueOf(num); // 각 자리를 계산하기 위한 string형 변환
        for (int i = 0; i < string_num.length(); i++) {
            result += Character.getNumericValue(string_num.charAt(i));
        }

        return result;
    }

    // 페이지 숫자를 곱한다.
    static int multiply(int num){
        int result = 1; // 곱한 결과 값
        String string_num = String.valueOf(num); // 각 자리를 계산하기 위한 string형 변환
        for (int i = 0; i < string_num.length(); i++) {
            result *= Character.getNumericValue(string_num.charAt(i));
        }

        return result;
    }

    // list 안의 숫자들로 조합할 수 있는 합, 곱 중 가장 큰 수를 구한다.
    static int calculate_max(List<Integer> list){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int result1 = plus(list.get(i));
            int result2 = multiply(list.get(i));
            max = Math.max(max, Math.max(result1, result2));
        }

        return max;
    }

    // 기능 요구사항 5
    // 비교해 승자를 가린다.
    static int compare(List<Integer> list1, List<Integer> list2){
        int max_1 = calculate_max(list1); // list1에서 나올 수 있는 가장 최대값
        int max_2 = calculate_max(list2); // list2에서 나올 수 있는 가장 최대값

        if(max_1 == max_2){
            return 0;
        }
        else if (max_1 > max_2) {
            return 1;
        }
        else {
            return 2;
        }
    }

    // 에외사항
    static boolean isPossible(List<Integer> list){
        // flag가 false라면 예외사항이다.
        boolean flag = true;

        //  1. 책 왼쪽, 오른쪽 페이지 차이 > 1
        if(Math.abs(list.get(0) - list.get(1)) > 1){
            flag = false;
        }
        //  2. 페이지 왼쪽이 1 or 페이지 오른쪽 400
        if(list.get(0) == 1 || list.get(1) == 400){
            flag = false;
        }
        //  3. 페이지 왼쪽이 짝수 or 페이지 오른쪽 홀수
        if((list.get(0) % 2 == 0) || (list.get(1) % 2 == 1)){
            flag = false;
        }
        //  4. 페이지 왼쪽 숫자 >= 페이지 오른쪽 숫자
        if(list.get(0) >= list.get(1)){
            flag = false;
        }

        return flag;
    }
}