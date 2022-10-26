package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int calculatorMultiply(int page){
        int result = 1;
        String[] splitPage = Integer.toString(page).split("");

        for(String eachPage : splitPage){
            result *= Integer.parseInt(eachPage);
        }

        return result;
    }

    public static int calculatorAdd(int page){
        int result = 0;
        String[] splitPage = Integer.toString(page).split("");

        for(String eachPage : splitPage){
            result += Integer.parseInt(eachPage);
        }

        return result;
    }

    public static int compareMultiplyAndAdd(int pages){
        int addResult = calculatorAdd(pages);
        int multiplyResult = calculatorMultiply(pages);

        return Math.max(addResult, multiplyResult);
    }

}