package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong){
    int answer = Integer.MAX_VALUE;

    if (!Validation.isValidateInput(pobi) || !Validation.isValidateInput(crong)) {
        return -1;
    }

    return answer;
}

}
class Validation{
    static final int LIST_LENGTH = 2;
    static final int MAX_PAGE = 400;
    static final int MIN_PAGE = 1;

    static boolean isValidateInput(List<Integer> input){

        return !(input.size() != LIST_LENGTH
                || input.get(1) - input.get(0) != 1
                || input.get(1) >= MAX_PAGE
                || input.get(0) <= MIN_PAGE);
    }
}


class ScoreController{
    private static int sumDigits(int num){
        int result = 0;

        while (num != 0) {
            result += num%10;
            num /= 10;
        }
        return result;
    }

    private static int mulDigits(int num){
        int result = 1;

        while (num!=0) {
            result *= num%10;
            num /= 10;
        }
        return result;
    }

}
