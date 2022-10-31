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
    // func : decide answer by compare two lists
    private static int getScore(List<Integer> pobi, List<Integer> crong){
        int result = -1;
        if (getMaxNum(pobi) > getMaxNum(crong)) result = 1;
        else if(getMaxNum(pobi) < getMaxNum(crong)) result = 2;
        else if(getMaxNum(pobi) == getMaxNum(crong)) result = 0;
        return result;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = getScore(pobi,crong);
        return answer;
    }
}