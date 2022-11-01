package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        //50000, 10000, 5000, 1000, 500, 100, 50, 10, 1;
        ArrayList<Integer> JPY_CoinList = new ArrayList<>();

        JPY_CoinList.add(50000);
        JPY_CoinList.add(10000);
        JPY_CoinList.add(5000);

        JPY_CoinList.add(1000);
        JPY_CoinList.add(500);
        JPY_CoinList.add(100);

        JPY_CoinList.add(50);
        JPY_CoinList.add(10);
        JPY_CoinList.add(1);

        answer = minimum_Coin(money,JPY_CoinList);
        return answer;

    }


    public static List<Integer> minimum_Coin(int value, ArrayList<Integer> JPY_CoinList){

        List<Integer> ans = new ArrayList<>(Collections.emptyList());
        int residue = value;
        int k=0;
        for(int i = 0; i < JPY_CoinList.size();i++){
            k=(int)residue/JPY_CoinList.get(i);
            ans.add(k);
            residue -= k*JPY_CoinList.get(i);
        }
        return ans;
    }


}
