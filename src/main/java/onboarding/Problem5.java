package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        int newmoney;

        int[] moneytype = {50000,10000,5000,1000,500,100,50,10,1};

        //List<Integer> answer = Collections.emptyList();

        for(int i=0;i<moneytype.length;i++){
            newmoney=money/moneytype[i];
            list.add(newmoney);
            money=money-newmoney*moneytype[i];

        }


        System.out.println(list);

        return list;
    }
}
