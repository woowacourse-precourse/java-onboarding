package onboarding;

import java.util.*;


class Problem1 {
    public static int get_sum(int num){
        return get_digitList(num).stream().mapToInt(Integer::intValue).sum();
    }
    public static int get_prod(int num) {
        return get_digitList(num).stream().reduce(1,(a,b) -> a*b);
    }
    public static int get_max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }
    public static int compare_max(List<Integer> digit_ls) {


    }
    public static List<Integer> get_digitList(int num){




    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        return answer;
    }
}