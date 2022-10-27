package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    // 1. 5만원, 만원, 5천원, 천원, 오백원, 백원, 오십원, 십원, 일원 동전 enum 으로 리팩토링
    public enum Won{
        FIFTY_THOUSAND_WON(50000),
        TEN_THOUSAND_WON(10000),
        FIVE_THOUSAND_WON(5000),
        ONE_THOUSAND_WON(1000),
        FIVE_HUNDRED_WON(500),
        ONE_HUNDRED_WON(100),
        FIFTY_WON(50),
        TEN_WON(10),
        ONE_WON(1);
        final private int num;

        private Won(int num){
            this.num = num;
        }
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = List.of(0,0,0,0,0,0,0,0,0);

        ArrayList<Integer> arrayList = new ArrayList<>(answer);

//        3. 출금한 돈에서 지갑에 담은 돈 빼기 => 출금해야할 남아있는 돈 만들기
        int arrayIdx =0;
        for (Won value : Won.values()) {
            money -= value.num * getCoin(money, value.num, arrayIdx, arrayList);
            arrayIdx++;
        }

        return arrayList;
    }

//    2. 지갑에 최대한 담을 수 있는 갯수 구하기 (지갑이 최대한 가볍도록 큰 값의 지폐부터 담아야 함)
    private static int getCoin(int money, int won,int idx, ArrayList<Integer> arrayList) {
        int i=1000000/won;
        for(;i>=0;i--){
            if(money -won*i>=0){
                arrayList.set(idx,i);
                break;
            }
        }
        return i;
    }

}
