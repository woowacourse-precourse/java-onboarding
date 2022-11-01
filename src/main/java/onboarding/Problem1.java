package onboarding;

import java.util.List;

class Problem1 {
    private static int calculate(int num){
        int plus;
        int multiply;
        int tmp;
        int result;

        plus = 0;
        multiply = 1;
        while (num > 0){
            tmp = num % 10;
            plus += tmp % 10;
            multiply *= tmp;
            num = num / 10;
        }
        result = Math.max(plus, multiply);
        return result;
    }
    private static int calculate(int left, int right){
        int answer;

        answer = Math.max(calculate(left), calculate(right));
        return answer;
    }
    private static boolean check(int left, int right){
        if (right - left != 1)
            return false;
        if (left == 1 || right == 400)
            return false;
        if (left % 2 != 1 || right % 2 != 0)
            return false;
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        answer = -1;
        if (check(pobi.get(0), pobi.get(1)) && check(crong.get(0), crong.get(1))) {
            int pobi_answer;
            int crong_answer;

            pobi_answer = calculate(pobi.get(0), pobi.get(1));
            crong_answer = calculate(crong.get(0), crong.get(1));
            if (pobi_answer > crong_answer)
                answer = 1;
            else if (pobi_answer == crong_answer)
                answer = 0;
            else
                answer = 2;
        }
        return answer;
    }
}