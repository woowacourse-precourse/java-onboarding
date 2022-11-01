package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        Game.validateOutOfRange(number);
        ArrayList<Integer> dp = Game.initGame();
        for (int i = 2; i <= number; i++) {
            dp.add(i, dp.get(i-1) + Game.countContainThree(i));
        }
        return dp.get(number);
    }
}

class Game{
    private static final String OUT_OF_RANGE = "1이상 10000이하를 입력해 주세요";
    static ArrayList<Integer> initGame(){
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0, 0);
        dp.add(1,0);
        return dp;
    }
    public static void validateOutOfRange(int number) {
        if(number < 1 || number > 10000)
            throw new IllegalArgumentException(OUT_OF_RANGE);
    }
    static int countContainThree(int number){
        int cnt = 0;
        while(number != 0){
            int rest = number % 10;
            if(rest/3 != 0 && (rest % 3) == 0) cnt++;
            number /= 10;
        }
        return cnt;
    }
}
