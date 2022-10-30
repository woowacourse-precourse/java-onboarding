package onboarding;

import java.util.List;

class Problem1 {
    public static boolean isAvailable(List<Integer> list){
        if (list.size() != 2) {
            return false;
        } else if (list.get(0) <= 1 || list.get(1) >= 400) {
            return false;
        } else if (list.get(0) % 2 != 1) {
            return false;
        } else if (list.get(1) - list.get(0) != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static int getScore(int num){
        int plus = 0;
        int multiply = 1;

        while (num > 0){
            int temp = num % 10;
            plus += temp;
            multiply *= temp;
            num /= 10;
        }

        if (plus >= multiply) {
            return plus;
        } else {
            return multiply;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}