package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();


        int cnt1=0;
//        System.out.println(money/50000);
        if(money/50000>=1){
            cnt1=money/50000;
            money-=cnt1*50000;
        }
        int cnt2=0;
        if(money/10000>=1){
            cnt2=money/10000;
            money-=cnt2*10000;
        }
        int cnt3=0;
        if(money/5000>=1){
            cnt3=money/5000;
            money-=cnt3*5000;
        }
        int cnt4=0;
        if(money/1000>=1){
            cnt4=money/1000;
            money-=cnt4*1000;
        }
        int cnt5=0;
        if(money/500>=1){
            cnt5=money/500;
            money-=cnt5*500;
        }
        int cnt6=0;
        if(money/100>=1){
            cnt6=money/100;
            money-=cnt6*100;
        }
        int cnt7=0;
        if(money/50>=1){
            cnt7=money/50;
            money-=cnt7*50;
        }
        int cnt8=0;
        if(money/10>=1){
            cnt8=money/10;
            money-=cnt8*10;
        }
        int cnt9=0;
        if(money/1>=1){
            cnt9=money/1;
            money-=cnt9*1;
        }
//        System.out.println(cnt1);
        answer=List.of(cnt1,cnt2,cnt3,cnt4,cnt5,cnt6,cnt7,cnt8,cnt9);

        return answer;
    }
//    public static void main(String[] args){
////        List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
//        System.out.println(Problem5.solution(6344));
////        System.out.println(answer1.get(0));
//    }
}
