package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public int calculatorMultiply(int page){
        int result = 1;
        String[] splitPage = Integer.toString(page).split("");

        for(String eachPage : splitPage){
            result *= Integer.parseInt(eachPage);
        }

        return result;
    }

    public int calculatorAdd(int page){
        int result = 0;
        String[] splitPage = Integer.toString(page).split("");

        for(String eachPage : splitPage){
            result += Integer.parseInt(eachPage);
        }

        return result;
    }

}