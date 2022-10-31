package onboarding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

class Problem1 {
    public static boolean isValidInput(List<Integer> arr){
        int left = arr.get(0);
        int right = arr.get(1);
        if(left < 1 || left > 400) return false;
        if(right < 1 || right > 400) return false;

        if(left % 2 == 0) return false;
        if(right % 2 != 0) return false;

        if(right - left != 1) return false;

        return true;
    }

    public static int SumOfDigit(int value){
        int result = 0;
        while(value != 0){
            result += value % 10;
            value /= 10;
        }
        return result;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        boolean pobi_valid = isValidInput(pobi);
        if(!pobi_valid) return -1;
        boolean crong_valid = isValidInput(crong);
        if(!crong_valid) return -1;


        return answer;
    }
}