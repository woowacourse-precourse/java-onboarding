package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (errorHandling(pobi) == false) return -1;
        if (errorHandling(crong) == false) return -1;

        int pobiResult = compareLeftRightPage(pobi);
        int crongResult = compareLeftRightPage(crong);

        if (pobiResult > crongResult) answer = 1; // pobi is winner
        else if (pobiResult < crongResult) answer = 2; // crong is winner
        else answer = 0; // tie

        return answer;
    }

    public static boolean errorHandling(List<Integer> who){
        int left = who.get(0);
        int right = who.get(1);

        if (left%2==1 && left+1==right && 0<left && right<401) return true;
        else return false;
    }
    public static String[] integerToStringList(int num){
        String strNum = Integer.toString(num);
        return strNum.split("");
    }
    public static int summationPage(int pageNumber){
        int result = 0;
        String[] arrNumOfPage = integerToStringList(pageNumber);
        for (String strNum : arrNumOfPage){
            result += Integer.valueOf(strNum);
        }
        return result;
    }
    public static int multiplicationPage(int pageNumber){
        int result = 1;
        String[] arrNumOfPage = integerToStringList(pageNumber);
        for (String strNum : arrNumOfPage){
            result *= Integer.valueOf(strNum);
        }
        return result;
    }
    public static int compareLeftRightPage(List<Integer> who){
        int result = Integer.MIN_VALUE;

        int leftPage = who.get(0);
        int rightPage = who.get(1);

        int[] candidate = new int[4];
        candidate[0] = summationPage(leftPage);
        candidate[1] = multiplicationPage(leftPage);
        candidate[2] = summationPage(rightPage);
        candidate[3] = multiplicationPage(rightPage);

        for (int candy : candidate) result = (candy > result) ? candy : result;

        return result;
    }
}