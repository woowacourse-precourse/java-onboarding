package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //  오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
        // 일 십 백 천
        // 일, 십 오십, 백 오백, 천 오천, 만 오만
        // 1. 나누기로 숫자 분리하기
        // 2. 분리한 숫자가 5이상이면 오x에 1추가 남은 금액을 입력
        // 3. 최대가 백만원이기때문에 오만 만원은 다르게 생각
        // 만약 10만얼마면 오만2, 20 오만 4, 100만원 20...
        // 12만원 오만 12/5 = 2 만 2, 26만원 26/5
        List<Integer> moneyTemp = new ArrayList<>();
        List<Integer> moneyList = new ArrayList<>();
        while(money>0){ // 967869
            moneyTemp.add(money%10); // 9 6 8 7 6 9
            money = money/10;
        } // 0 0 1 2 1 3 1 1 9
        // 96만원 => 90만원 , 5만원 1만원

        // 100만원일 경우 추가해서 쓰기

        for (int i =moneyTemp.size()-1; i>0; i--){
            int m =moneyTemp.get(i);
            if(m>=5) {
                moneyList.add(i + 2, 1);
                moneyList.add(i + 3, m%5);
            }else{
                moneyList.add(i + 2, 0);
                moneyList.add(i + 3, m);
            }
            }
        int count =0;
        if(moneyTemp.get(4)>=5) {moneyList.add(1, moneyTemp.get(4)%5); count++; }
        else{moneyList.add(1, moneyTemp.get(4));}

        if(moneyTemp.get(-1) >=5) moneyList.add(0, (moneyTemp.get(-1)*10)/5+count);



        return moneyList;
    }
}
