package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] coin = {50000,10000,5000,1000,500,100,50,10,1};
        ArrayList<Integer> ans = new ArrayList<>();
        int[] num = new int[coin.length];

        for(int i=0;i< coin.length;i++){  //num 리스트에 사용한 동전 담기
            num[i] += money / coin[i];
            money %= coin[i];
        }
        for(int i=0;i< coin.length;i++) {
            ans.add(num[i]);
        }
        return ans;
    }
}
