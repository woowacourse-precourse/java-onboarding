package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}

class Clap{
    private int number;
    private int sumClap;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10000;
    private static final int START_NUMBER=1;
    private static final String NOT_ALLOWED_UNDER_MIN_NUMBER = "number은 최소 1 입니다.";
    private static final String NOT_ALLOWED_OVER_MAX_NUMBER = "number은 최대 1000 입니다.";

    public Clap(){
        validateNumberRange();
    }

    private void validateNumberRange() {
        if (number < MIN_NUMBER) {
            throw new IllegalStateException(NOT_ALLOWED_UNDER_MIN_NUMBER);
        }
        if (number > MAX_NUMBER) {
            throw new IllegalStateException(NOT_ALLOWED_OVER_MAX_NUMBER);
        }
    }
}

class Number{
    private static final List<Integer> CLAP_NUMBER=List.of(3,6,9);
    private int clapCount;
    public int countClap(int specificNunber){
        while(specificNunber!=0){
            int remainder=specificNunber%10;
            if(CLAP_NUMBER.contains(remainder)){
                clapCount+=1;
            }
            specificNunber/=10;
        }
        return clapCount;
    }
}
