package onboarding;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(testException(pobi) || testException(crong)){
            return -1;
        }

        int score_pobi = calcScore(pobi);
        int score_crong = calcScore(crong);

        if(score_pobi > score_crong)
            return 1;
        else if(score_pobi == score_crong)
            return 0;
        else
            return 2;
    }
    public static boolean testException(List<Integer> x){
        //페이지의 범위를 넘어설 경우
        if(x.get(0) < 1 || x.get(1) > 400)
            return true;

        //시작면이나 마지막 면이 포함된 경우
        if(x.get(0) == 1 || x.get(1) == 400)
            return true;

        //왼쪽 페이지가 짝수인경우
        if(x.get(0) % 2 == 0)
            return true;

        //연속된 페이지가 아닌 경우
        if(x.get(0) + 1 != x.get(1))
            return true;

        //예외가 아님
        return false;
    }
    public static int calcScore(List<Integer> x){
        //자릿수 리스트
        List<Integer> digitList_left = new ArrayList<>();
        List<Integer> digitList_right = new ArrayList<>();

        //자릿수 구하기
        int targ = x.get(0);
        for(int i=10;targ * 10 >= i;i*=10){
            digitList_left.add(targ%i/(i/10));
        }
        targ = x.get(1);
        for(int i=10;targ * 10 >= i;i*=10){
            digitList_right.add(targ%i/(i/10));
        }
        //자릿수 합,곱 구하기
        int val_left_add = 0,val_left_mul = 1;
        int val_right_add = 0,val_right_mul = 1;
        for(int i : digitList_left){
            val_left_add += i;
            val_left_mul *= i;
        }
        for(int i : digitList_right){
            val_right_add += i;
            val_right_mul *= i;
        }
        //가장 큰것 반환
        return Collections.max(
                new ArrayList<Integer>(
                        Arrays.asList(
                                val_left_add,
                                val_left_mul,
                                val_right_add,
                                val_right_mul))
        );
    }

}