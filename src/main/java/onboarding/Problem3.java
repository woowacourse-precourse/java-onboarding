package onboarding;

import java.util.Arrays;
import java.util.function.Predicate;

public class Problem3 {
    public static int solution(int number) {
        int []dp =new int[number+1];
        for (int i = 3; i <dp.length ; i++) {
            dp[i]= getThreeCount(i)+getSixCount(i)+getNineCount(i);
        }
        return Arrays.stream(dp).sum();
    }

    private static int getNineCount(int number) {
        return getNumberCount(number,(x)->x==9);
    }

    private static int getSixCount(int number) {
        return getNumberCount(number,(x)->x==6);
    }

    private static int getThreeCount(int number) {
        return getNumberCount(number,(x)->x==3);
    }

    private static int getNumberCount(int number, Predicate<Integer> predicate) {
        int answer=0;
        while(number!=0){
            if(predicate.test(number%10))
                answer++;
            number/=10;
        }
        return answer;
    }
}
