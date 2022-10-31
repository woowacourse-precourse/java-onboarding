package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // pobi win = 1, crong win = 2, draw = 0, exception = -1
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /*
     주어진 숫자의 각 자리수의 더한 값과 곱한 값 중 큰 값을 반환
     */
    public static int calBigOfMulAndAdd(Integer number) {
        int a_hundred_digit_num = number / 100;
        int a_decimal_digit_num = (number % 100) / 10;
        int a_first_digit_num = (number % 100) % 10;
        int sum_of_digit = a_hundred_digit_num + a_decimal_digit_num +
            a_first_digit_num;
        int mul_of_digit = 0;
        if (a_hundred_digit_num == 0) {
            mul_of_digit = a_decimal_digit_num *
                a_first_digit_num;
        } else if (a_hundred_digit_num != 0) {
            mul_of_digit = a_hundred_digit_num * a_decimal_digit_num *
                a_first_digit_num;
        }

        int result = Math.max(sum_of_digit, mul_of_digit);
        return result;
    }

    /*
     주어진 사람이 펼친 두 페이지 번호의 숫자에 대한 결과를 비교하여 반환
     */
    public static int calSelfScore(List<Integer> person) {
        int left_page_num = person.get(0);
        int right_page_num = person.get(1);
        if ((right_page_num - left_page_num) != 1) {
            return -1;
        }

        int left_page_result = calBigOfMulAndAdd(left_page_num);
        int right_page_result = calBigOfMulAndAdd(right_page_num);
        int result = Math.max(left_page_result, right_page_result);
        return result;
    }

}