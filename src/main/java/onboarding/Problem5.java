package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> wallet = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
        List<Integer> answer = new ArrayList<>();
        int cash;
        if (exception(money)) {
            for(int index=0; index<wallet.size(); index++) {
                cash = wallet.get(index);

                answer.add(money/cash);
                money %= cash;
            }
        }
        return answer;
    }
    private static boolean exception(int number) {
        if(number < 1 || number > 1000000){
            return false;
        }

        return true;
    }
}

