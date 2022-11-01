package onboarding;

import javax.swing.plaf.IconUIResource;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!valid(pobi)) return -1;
        if(!valid(crong)) return -1;

        int player1 = maxScore(pobi);
        int player2 = maxScore(crong);
        int answer = Integer.MAX_VALUE;

        if(player1==player2) answer = 0;
        else if(player1>player2) answer = 1;
        else answer = 2;
        return answer;
    }

    //1. 펼친 페이지 번호 두 개를 받으면 계산해서 최댓값을 반환하는 기능
    static int maxScore(List<Integer> scores){
        int ans = Integer.MIN_VALUE;
        for (int i:scores){
            int add = 0, multi = 1;
            while(i>0){
                add+=(i%10);
                multi*=(i%10);
                i /= 10;
            }
            ans = Integer.max(ans, Integer.max(add, multi));
        }
        return ans;
    }

    //예외처리
    static boolean valid(List<Integer> scores) {
        int first = scores.get(0);
        int second = scores.get(1);
        //페이지가 어긋나거나, 첫 페이지 또는 마지막 페이지를 펼친 경우
        if(first+1 != second || first == 1 || second == 400)return false;
        else return true;
    }
}