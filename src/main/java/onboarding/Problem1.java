package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (error_handling(pobi) == false) return -1;
        if (error_handling(crong) == false) return -1;

        int pobi_result = compare_left_right(pobi);
        int crong_result = compare_left_right(crong);

        if (pobi_result>crong_result) answer=1;
        else if (pobi_result<crong_result) answer=2;
        else answer=0;

        return answer;
    }

    public static boolean error_handling(List<Integer> who){
        int left = who.get(0);
        int right = who.get(1);

        if (left%2==1 && left+1==right && 0<left && right<401) return true;
        else return false;
    }
    public static String[] int2intList(int page_number){
        String strNum = Integer.toString(page_number);
        return strNum.split("");
    }
    public static int page_summation(int page_number){
        int result = 0;
        String[] arrNum = int2intList(page_number);
        for (String str : arrNum){
            result += Integer.valueOf(str);
        }
        return result;
    }
    public static int page_muliplication(int page_number){
        int result = 1;
        String[] arrNum = int2intList(page_number);
        for (String str : arrNum){
            result *= Integer.valueOf(str);
        }
        return result;
    }
    public static int compare_left_right(List<Integer> who){
        int result = Integer.MIN_VALUE;

        int left_page = who.get(0);
        int right_page = who.get(1);

        int[] candidate = new int[4];
        candidate[0] = page_summation(left_page);
        candidate[1] = page_muliplication(left_page);
        candidate[2] = page_summation(right_page);
        candidate[3] = page_muliplication(right_page);

        for (int candy : candidate) result = (candy > result) ? candy : result;

        return result;
    }
}