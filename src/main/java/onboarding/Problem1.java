package onboarding;

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

    public static int SumOfDigit(int page){
        int result = 0;
        while(page != 0){
            result += page % 10;
            page /= 10;
        }
        return result;
    }

    public static int MultiplicationOfDigit(int page){
        int result = 1;
        while(page != 0){
            result *= page % 10;
            page /= 10;
        }
        return result;
    }

    public static int JudgeResult(int pobi_score, int crong_score){
        if(pobi_score > crong_score) return 1;
        else if(pobi_score == crong_score) return 0;
        else return 2;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        boolean pobi_valid = isValidInput(pobi);
        if(!pobi_valid) return -1;
        boolean crong_valid = isValidInput(crong);
        if(!crong_valid) return -1;

        int pobi_leftpageMaxValue = Math.max(SumOfDigit(pobi.get(0)), MultiplicationOfDigit(pobi.get(0)));
        int pobi_rightpageMaxValue = Math.max(SumOfDigit(pobi.get(1)), MultiplicationOfDigit(pobi.get(1)));
        int pobi_score = Math.max(pobi_leftpageMaxValue,pobi_rightpageMaxValue);

        int crong_leftpageMaxValue = Math.max(SumOfDigit(crong.get(0)), MultiplicationOfDigit(crong.get(0)));
        int crong_rightpageMaxValue = Math.max(SumOfDigit(crong.get(1)), MultiplicationOfDigit(crong.get(1)));
        int crong_score = Math.max(crong_leftpageMaxValue,crong_rightpageMaxValue);

        answer = JudgeResult(pobi_score, crong_score);
        return answer;
    }
}