package onboarding;

import java.util.ArrayList;
import java.util.List;

import org.objenesis.strategy.SingleInstantiatorStrategy;

class Problem1 {
    int findMaxScore(List<Integer> player){
        //int[] scores = new int[] {0,0,0,0};
        int sum;
        int mul;
        int max_score = 0;

        for(int i = 0; i<2; i++){
        // 2페이지에 대해 반복
            int hund = player.get(i)/100;
            int dec = player.get(i)/10;
            int single = player.get(i) % 10;
            sum = hund + dec + single;
            mul = hund * dec * single;

            if (sum > mul){
                if(sum > max_score){
                    max_score = sum;
                }
            }
            else{
                if(mul > max_score){
                    max_score = mul;
                }
            }

            //scores[i*2] = sum;
            //scores[i*2+1] = sum;
        }
        
        return max_score;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();
        int answer = Integer.MAX_VALUE;

        // 1. 연속적인 값인지 판단
        if ((pobi.get(1) - pobi.get(0))*(crong.get(1) - crong.get(0)) != 1){
            // pobi, crong 두 리스트 값 들 중 하나라도 연속적이지 않으면 return -1
            return -1;
        }

        int pobi_score = problem1.findMaxScore(pobi);
        int crong_score = problem1.findMaxScore(crong);

        if (pobi_score > crong_score){
            answer = 1;
        }
        if (pobi_score < crong_score){
            answer = 2;
        }
        if (pobi_score == crong_score){
            answer = 0;
        }
        else{
            answer = -1;
        }

        return answer;
    }
}