package onboarding;

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
        String value = String.valueOf(number);
        Stream<Character> characterStream = value.chars().mapToObj(i->(char)i);
        return (int)characterStream.filter(i -> canMakeClap(i)).count();
    }

    private static boolean canMakeClap(char charater){
        if(charater=='3'){
            return true;
        }
        if(charater=='6'){
            return true;
        }
        if(charater=='9'){
            return true;
        }
        return false;
    }

}
