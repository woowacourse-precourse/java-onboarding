package onboarding;

/*
 - 지폐가 가장 적도록
 - 오만원, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원
 - 금액이 큰 순서대로 리스트 / 배열에 담아 리턴

 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList();

        ArrayList<Integer> billList = new ArrayList<Integer>(List.of(50000,10000,5000,1000,500,100,50,10,1));

        for(int i=0; i<9; i++){
            int cash = billList.get(i);
            if(money/cash>0);
            billList.set(i,money/cash);
            money = money % cash;

        }



        return billList;
    }






}
