package onboarding;

import java.util.List;

class Problem1 {

    // func : sum each digit
    private static int getSum(int n){
        int length = (int)Math.log10(n) + 1;
        int num = n;
        int res = 0;
        for (int i=0; i < length; i++){
            res += num % Math.pow(10,i+1);
            num /= Math.pow(10,i+1);
        }
        return res;
    }
    // func : multiple each digit
    private static int getMulti(int n){
        int length = (int)Math.log10(n) + 1;
        int num = n;
        int res = 1;
        for (int i=0; i < length; i++){
            res *= num % Math.pow(10,i+1);
            num /= Math.pow(10,i+1);
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
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}