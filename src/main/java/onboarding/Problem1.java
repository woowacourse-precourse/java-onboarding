package onboarding;

import java.util.Collections;
import java.util.List;

class Problem1 {
    public static boolean exception_handling(int pobi_left, int pobi_right, int crong_left, int crong_right) {
        if((pobi_left % 2!= 1) || (pobi_right % 2 != 0) || (pobi_left + 1 != pobi_right)) {
            return true;
        }
        if((crong_left % 2!= 1) || (crong_right % 2 != 0) || (crong_left + 1 != crong_right)) {
            return true;
        }
        return false;
    }

    public static int add_each_digit(int num){
        int sum = 0;

        while(num / 10 != 0) {
            sum += num % 10;
            num /= 10;
        }
        sum += num % 10;

        return sum;
    }

    public static int mul_each_digit(int num) {
        int sum = 1;
        while(num / 10 != 0){
            sum *= num % 10;
            num /= 10;
        }
        sum *= num % 10;

        return sum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_left = pobi.get(0);
        int pobi_right = pobi.get(1);
        int crong_left = crong.get(0);
        int crong_right = crong.get(1);

        if(exception_handling(pobi_left, pobi_right, crong_left, crong_right))
            return -1;

        int pobi_left_each_sum = add_each_digit(pobi_left);
        int pobi_right_each_sum = add_each_digit(pobi_right);
        int pobi_left_each_mul = mul_each_digit(pobi_left);
        int pobi_right_each_mul = mul_each_digit(pobi_right);

        List<Integer> pobi_list = List.of(pobi_left_each_sum, pobi_right_each_sum, pobi_left_each_mul, pobi_right_each_mul);
        int pobi_max = Collections.max(pobi_list);


        int crong_left_each_sum = add_each_digit(crong_left);
        int crong_right_each_sum = add_each_digit(crong_right);
        int crong_left_each_mul = mul_each_digit(crong_left);
        int crong_right_each_mul = mul_each_digit(crong_right);

        List<Integer> crong_list = List.of(crong_left_each_sum, crong_right_each_sum, crong_left_each_mul, crong_right_each_mul);
        int crong_max = Collections.max(crong_list);

        int answer = 0;
        if(pobi_max > crong_max)
            answer = 1;
        else if (pobi_max < crong_max) {
            answer = 2;
        } else if (pobi_max == crong_max) {
            answer = 0;
        }

        return answer;
    }
}