package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Problem1 {

    public static void main(String[] args){

        System.out.println(solution(List.of(97,98),List.of(197,198)));
        System.out.println(solution(List.of(131,132),List.of(211,212)));
        System.out.println(solution(List.of(99,102),List.of(211,212)));
    }



    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        if(PageException(pobi) || PageException(crong)){
            return -1;
        }

        int pobi_MaxVal = getUser_MaxVal(pobi);
        int crong_MaxVal = getUser_MaxVal(crong);

        answer = WinnerCheck(pobi_MaxVal,crong_MaxVal);

        return answer;
    }

    public static boolean PageException(List<Integer> page) {

        boolean IsPageError = false;

        if (page.get(1) % 2 != 0 || page.get(0) + 1 != page.get(1)) {
            IsPageError = true;
        }

        if (page.get(0) < 0 || page.get(1) < 0 || page.get(0) >= 1000 || page.get(1) >= 1000) {
            IsPageError = true;
        }

        return IsPageError;
    }

    public static int getUser_MaxVal(List<Integer> pages) {
        int leftMaxValue = getMax_Val_Page(pages.get(0));
        int rightMaxValue = getMax_Val_Page(pages.get(1));

        int User_max = leftMaxValue >= rightMaxValue ? leftMaxValue : rightMaxValue;
        return User_max;
    }

    public static int getMax_Val_Page(int page_Num){
        String PageTypeOfString = String.valueOf(page_Num);

        int Page_Sum = get_Sum_Page(PageTypeOfString);
        int Page_Mul = get_Mul_Page(PageTypeOfString);

        int max = 0;
        max = Page_Sum >= Page_Mul ? Page_Sum : Page_Mul;

        return max;
    }

    public static int WinnerCheck(int pobi_result, int crong_result){
        if (pobi_result == crong_result) {
            return 0;
        }

        return pobi_result > crong_result ? 1 : 2;
    }

    private static int get_Sum_Page(String PageTypeOfString) {
        int sum = 0;

        for (int i = 0; i < PageTypeOfString.length(); i++) {
            int temp = PageTypeOfString.charAt(i) - '0';
            sum += temp;
        }
        return sum;
    }

    public static int get_Mul_Page(String PageTypeOfString) {
        int mul = 1;

        for (int i = 0; i < PageTypeOfString.length(); i++) {
            int temp = PageTypeOfString.charAt(i) - '0';
            mul *= temp;
        }
        return mul;
    }

}