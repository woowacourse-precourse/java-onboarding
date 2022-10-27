package onboarding;

import java.util.Optional;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(!checkValidation(number)){
            return -1;
        }
        answer=getAmountOfClap(number);
        return answer;
    }

    private static boolean checkValidation(int number){
        if(1<number && number<10000){
            return true;
        }
        return false;
    }

    private static int getAmountOfClap(int number){
        int totalClap = 0;
        for(int i=1; i<number+1; i++){
            totalClap+=getClapOfNumber(i);
        }
        return totalClap;
    }

    private static int getClapOfNumber(int number){
        int result = 0;
        String value = String.valueOf(number);
        Stream<Character> characterStream = value.chars().mapToObj(i->(char)i);
        result=(int)characterStream.filter(i -> canMakeClap(i)).count();
        return result;
    }

}
