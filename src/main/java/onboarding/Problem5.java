package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    // 1. 5만원, 만원, 5천원, 천원, 오백원, 백원, 오십원, 십원, 일원 동전 상수 생성
    public static final int FIFTY_THOUSAND_WON=50000;
    public static final int TEN_THOUSAND_WON=10000;
    public static final int FIVE_THOUSAND_WON=5000;
    public static final int ONE_THOUSAND_WON=1000;
    public static final int FIVE_HUNDRED_WON=500;
    public static final int ONE_HUNDRED_WON=100;
    public static final int FIFTY_WON=50;
    public static final int TEN_WON=10;
    public static final int ONE_WON=1;

    public static List<Integer> solution(int money) {
        List<Integer> answer = List.of(0,0,0,0,0,0,0,0,0);

        ArrayList<Integer> arrayList = new ArrayList<>(answer);


//        3. 출금한 돈에서 지갑에 담은 돈 빼기 => 출금해야할 남아있는 돈 만들기
        money -= FIFTY_THOUSAND_WON * getCoin(money, FIFTY_THOUSAND_WON, 0, arrayList);
        money -= TEN_THOUSAND_WON * getCoin(money, TEN_THOUSAND_WON, 1, arrayList);
        money -= FIVE_THOUSAND_WON * getCoin(money, FIVE_THOUSAND_WON, 2, arrayList);
        money -= ONE_THOUSAND_WON * getCoin(money, ONE_THOUSAND_WON, 3, arrayList);
        money -= FIVE_HUNDRED_WON * getCoin(money, FIVE_HUNDRED_WON, 4, arrayList);
        money -= ONE_HUNDRED_WON * getCoin(money, ONE_HUNDRED_WON, 5, arrayList);
        money -= FIFTY_WON * getCoin(money, FIFTY_WON, 6, arrayList);
        money -= TEN_WON * getCoin(money, TEN_WON, 7, arrayList);
        money -= ONE_WON * getCoin(money, ONE_WON, 8, arrayList);

        return arrayList;
    }

    //        2. 지갑에 최대한 담을 수 있는 갯수 구하기 (지갑이 최대한 가볍도록 큰 값의 지폐부터 담아야 함)
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
