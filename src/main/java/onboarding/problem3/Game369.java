package onboarding.problem3;

import java.util.Set;

public class Game369 {

    private static final Set<Integer> CLAP_NUMBERS = Set.of(3, 6, 9);

    public static int getTotalClapCount(int lastNumber){
        int count = 0;
        for(int i=1; i<=lastNumber; i++){
            count += getClapCount(i);
        }
        return count;
    }

    private static int getClapCount(int number){
        int count = 0;
        while(number != 0){
            if(CLAP_NUMBERS.contains(number%10)){
                count += 1;
            }
            number /= 10;
        }
        return count;
    }
}
