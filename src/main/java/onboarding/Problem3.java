package onboarding;

public class Problem3 {

    private static final int NUMBER_OF_DIGIT_DIVISION = 10;

    public static int solution(int number) {
        int answer = countClap(number);
        return answer;
    }


    private static int countClap(int number){
        int countClap = 0;
        for(int i=1;i<=number;i++){
            countClap += divideNumber(i);
        }
        return countClap;
    }

    private static int divideNumber(int number){
        int clap = 0;
        int dividedNumber = Integer.MIN_VALUE;
        while(number>0){
            dividedNumber = number % NUMBER_OF_DIGIT_DIVISION;
            if(confirmNumber(dividedNumber))
                clap++;
            number = number/NUMBER_OF_DIGIT_DIVISION;
        }
        return clap;
    }

    private static boolean confirmNumber(int dividedNumber){
        if(dividedNumber%3==0 && dividedNumber>0) return true;
        return false;
    }

}
