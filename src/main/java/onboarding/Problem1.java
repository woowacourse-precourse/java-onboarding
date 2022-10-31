package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight =crong.get(1);
        int answer = 0;

        if(getMax(pobiLeft) > getMax(crongLeft)){
            if(getMax(pobiRight) > getMax(crongRight)){answer = 1;}
            else{answer = -1;}
        }else if (getMax(pobiLeft) == getMax(crongLeft)){
            if(getMax(pobiRight)==getMax(crongRight)){answer =0;}
            else {answer = -1;}
        }else{
            if (getMax(pobiRight)<getMax(crongRight)){answer = 2;}
            else {answer = -1;}
        }

        return answer;
    }

    static int getMax(Integer a){
        int mul = 1;
        int sum = 0;
        List<Integer> arrNum = new ArrayList<>();
        while(a > 0){
            arrNum.add(a % 10);
            a /= 10;
        }
        for(int num : arrNum){
            mul *= num;
        }

        for(int num : arrNum){
            sum += num;
        }

        if(mul >= sum){return mul;}
        else {return sum;}

    }



}