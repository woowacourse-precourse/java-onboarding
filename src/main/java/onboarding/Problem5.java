package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        Integer[] result ={0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] price = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        while (money>0){
            for (int i=0;i<9;i++){
                result[i] = money/price[i];
                money%=price[i];
            }
        }
        List<Integer> answer = new ArrayList<>(Arrays.asList(result));
        return answer;
    }
}
