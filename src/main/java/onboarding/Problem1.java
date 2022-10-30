package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int max(int n) {
        int addSum = 0;
        int multSum = 0;
        String pageNum = Integer.toString(n);

        for(int i=0; i<pageNum.length(); i++){
            addSum += Integer.parseInt(pageNum.substring(i, i+1));
            multSum *= Integer.parseInt(pageNum.substring(i, i+1));
        }

        if (multSum >= addSum){
            return multSum;
        } else {
            return addSum;
        }
    }

    private static int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        else {
            return b;
        }
    }
}