package onboarding.problem3;

import java.util.Set;

public class Game369 {

    private static final Set<Integer> clapNumbers = Set.of(3, 6, 9);

    private static int getClapCount(int number){
        int count = 0;
        while(number != 0){
            if(clapNumbers.contains(number%10)){
                count += 1;
            }
            number /= 10;
        }
        return count;
    }
}
