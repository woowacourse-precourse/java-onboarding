package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = Bill(money);

        return answer;
    }
    public static List<Integer> Bill(int money){

        if( exceptionCheck(money)) return null;

        List<Integer> sol = new ArrayList<>();
        //바꿀 수 있는 화폐를 int 형 배열에 저장해둔다.
        int[] bill = new int[]{50000,10000,5000,1000,500,100,50,10,1};

        //각 화폐로 한번씩 나누어 그 몫이 그 화폐로 바꿀 수 있는 수이다.
        for(int i = 0 ; i < bill.length ; i++){
            //화폐로 나누어 그 몫을 리스트에 저장한다.
            sol.add(money/bill[i]);
            //돈에서 화폐로 변환한 만큼 돈을 줄인다.
            money = (money % bill[i]);
        }
        return sol;
    }
    public static boolean exceptionCheck(int money){
        //money는 1이상 1,000,000 이하인 자연수 이다.
        if(money < 1 || money > 1000000) return true;
        return false;
    }
}
