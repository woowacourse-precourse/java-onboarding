package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
            int answer = Integer.MAX_VALUE;
            return answer;
    }

    private static boolean check(List<Integer> list) {
        if(list.get(1)-list.get(0)==1)return true;
        else return false;
    }

    private static int calcalateMax(List<Integer> list) {
        int left= list.get(0);
        int right= list.get(1);
        int sumMax= Math.max(numSum(left),numSum(right));
        int multiMax = Math.max(numMulti(left),numMulti(right));
        int max = Math.max(sumMax, multiMax);
        return max;
    }
    private static int numSum(int i){

    }
    private static int numMulti(int i){

    }
}