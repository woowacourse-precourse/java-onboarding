package onboarding;

import java.util.List;

class Problem1 {

    // func : sum each digit
    private static int getSum(int n){
        int length = (int)Math.log10(n) + 1;
        int num = n;
        int res = 0;
        for (int i=length-1; i >= 0; i--){
            res += (int)(num / Math.pow(10,i));
            num = (int)(num % Math.pow(10,i));
        }
        return res;
    }
    // func : multiple each digit
    private static int getMulti(int n){
        int length = (int)Math.log10(n) + 1;
        int num = n;
        int res = 1;
        for (int i=length-1; i >= 0; i--){
            res *= (int)(num / Math.pow(10,i));
            num = (int)(num % Math.pow(10,i));
        }
        return res;
    }
    // func : Get max number on page number
    private static int getMaxNumPage(int n){
        return Math.max(getSum(n), getMulti(n));
    }
    // func : Get max number result between left and right page
    private static int getMaxNum(List<Integer> list){
        return Math.max(getMaxNumPage(list.get(0)), getMaxNumPage(list.get(1)));
    }

    // func : check list value are correct
    private static Boolean checkList(List<Integer> list){
        Boolean result = true;
        // left num should be odd, right num should be even, diff between left and right should be 1
        if (list.get(0) % 2 != 1 || list.get(1) % 2 != 0 || Math.abs(list.get(0) - list.get(1)) != 1){
            result = false;
        }
        return result;
    }

    // func : decide answer by compare two lists
    private static int getScore(List<Integer> pobi, List<Integer> crong){

        int res = 0;
        // if exception occured, return -1
        if  (!(checkList(pobi) && checkList(crong))) return -1;
        // if pobi wins, return 1
        if (getMaxNum(pobi) > getMaxNum(crong)) res = 1;
        // if cron wins, return 2
        else if(getMaxNum(pobi) < getMaxNum(crong)) res = 2;
        // if draws, return 0
        else if(getMaxNum(pobi) == getMaxNum(crong)) res = 0;

        return res;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = getScore(pobi,crong);
        return answer;
    }
}