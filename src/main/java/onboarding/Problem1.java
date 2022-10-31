package onboarding;

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
        int answer = Integer.MAX_VALUE;
        int pobi_left = pobi.get(0);
        int pobi_right = pobi.get(1);
        int crong_left = crong.get(0);
        int crong_right = crong.get(1);

        if(exception_handling(pobi_left, pobi_right, crong_left, crong_right))
            return -1;

        return answer;
    }
}