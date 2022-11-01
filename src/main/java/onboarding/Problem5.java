package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int UNIT[]={50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> solution(int money) {
        if(input_exception(money)) return Collections.emptyList();
        List<Integer> answer = getList(money);
        return answer;
    }

    private static List<Integer> getList(int money) {
        List<Integer> result=new ArrayList<>();

        for(int i=0;i<UNIT.length;i++){
            int num=money/UNIT[i];
            result.add(num);
            money-=num*UNIT[i];
        }

        return result;
    }

    private static boolean input_exception(int input){
        //true is 'exception excution'
        if(input<1||input>1000000) return true;
        return false;
    }
}
