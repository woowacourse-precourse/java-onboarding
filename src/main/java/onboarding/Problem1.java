package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //1. 펼친 페이지 번호 두 개를 받으면 계산해서 최댓값을 반환하는 기능
    int maxScore(List<Integer> scores){
        int ans = Integer.MIN_VALUE;
        for (int i:scores){
            int add = 0, multi = 1;
            while(i>0){
                add+=(i%10);
                multi*=(i%10);
                add/=10;
                multi/=10;
            }
            ans = Integer.max(ans, Integer.max(add, multi);
        }
        return ans;
    }

    boolean valid(List<Integer> scores) {
        int first = scores.get(0);
        int second = scores.get(1);
        //페이지가 어긋나거나, 첫 페이지 또는 마지막 페이지를 펼친 경우
        if (first+ 1 != second || first == 1 || second == 400) return false;
        else return false;

    }
}