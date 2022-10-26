package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    //예외경우 확인하는 메서드
    private static boolean isAble(int numL,int numR){
        if(numL+1==numR){
            return true;
        }
        return false;
    }
    //숫자 1개의 최대값 구하는 메서드
    private static int findMax(List<Integer> nums) {
        List<Integer>m=new ArrayList<>();
        int numL=nums.get(0);
        int sumL=0;
        int mulL=1;

        int numR=nums.get(1);
        int sumR=0;
        int mulR=1;

        while(numL!=0){
        int k=numL%10;
        sumL+=k;
        mulL*=k;
        numL/=10;
        }
        m.add(sumL);
        m.add(mulL);
        while(numR!=0){
            int k=numR%10;
            sumR+=k;
            mulR*=k;
            numR/=10;
        }
        m.add(sumR);
        m.add(mulR);
        Collections.sort(m,Collections.reverseOrder());
        return m.get(0);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //예외 처리
        if(isAble(pobi.get(0),pobi.get(1))==false||isAble(crong.get(0),crong.get(1))==false){
            return -1;
        }
        if(findMax(pobi)>findMax(crong)){
            return 1;
        }
        if(findMax(pobi)<findMax(crong)){
            return 2;
        }
        return 0;
    }

}