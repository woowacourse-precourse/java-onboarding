package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 십만원을 생각해야하는건지 아님 오만원으로 계산해야하는지..? 이건 내일돌려보고 생ㄲ하기
        List<Integer> moneyTemp = new ArrayList<>();
        List<Integer> moneyList = new ArrayList<>();


//        while(money>0){ // 50237
//            moneyList.add(money%10); // 7 3 2 0 5
//            money = money/10;
//
//        }
//
//        moneyTemp.add(moneyList.get(0)); // 일의 자리는 그냥 넣기
//        for(int i =1; i<moneyList.size();i++) {
//            int m = moneyList.get(i);
//            if(m<5) { // 5가 안넘으면
//                moneyTemp.add(m);
//                moneyTemp.add(0);}
//            else {//8 -> 1...3
//                moneyTemp.add(m%5);
//                moneyTemp.add(m/5);
//            }
//        }
//        moneyList.clear();
//        for(int i =moneyTemp.size()-1; i>-1;i--) {
//            moneyList.add(moneyTemp.get(i));
//        }
        return moneyList;
    }
}
