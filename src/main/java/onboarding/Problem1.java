package onboarding;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



class Problem1 {
    static int score(List<Integer> p){
        int sum1 = 0, sum2=0;
        int maxscore = 0;
        int n1 = p.get(0);
        int n2 = p.get(1);
        int t_n1=n1;
        int t_n2=n2;

        while(t_n1>0){
            sum1+=t_n1%10;
            t_n1 /= 10;
        }
        while(t_n2>0){
            sum2+=t_n2%10;
            t_n2 /= 10;
        }

        maxscore = Math.max(sum1,sum2);
        t_n1=n1;
        t_n2=n2;
        int mul1=1, mul2=1;
        while(t_n1>0){
            mul1*=t_n1%10;
            t_n1 /= 10;
        }
        while(t_n2>0){
            mul2*=t_n2%10;
            t_n2 /= 10;
        }
        maxscore = Math.max(maxscore,mul2);
        maxscore = Math.max(maxscore,mul1);
        return maxscore;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        if(pobi.equals(List.of(1,2)) || pobi.equals(List.of(399,400))||crong.equals(List.of(1,2)) || crong.equals(List.of(399,400))){
            return -1;
        }else if (pobi.get(1)- pobi.get(0)!= 1 || crong.get(1)- crong.get(0)!= 1){
            return -1;
        }
        int pobiscore = score(pobi);
        int crongscore = score(crong);



        if(pobiscore==crongscore){    //무승부
            answer = 0;                                                         
        } else if (pobiscore>crongscore) {
            answer = 1;
        } else{
            answer = 2;
        }

        return answer;
    }
}