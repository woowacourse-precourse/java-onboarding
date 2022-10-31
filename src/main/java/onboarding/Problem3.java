package onboarding;

public class Problem3 {
    private static boolean isDigit369(int digit){
        return digit == 3 || digit == 6 || digit == 9;
    }
    private static int countClap(int num){
        int clap = 0;
        while(num != 0){
            int lastDigit = num % 10;
            if(isDigit369(lastDigit))
                clap += 1;
            num /= 10;
        }
        return clap;
    }
    public static int solution(int number) {
        int allClap = 0;
        for(int num = 1; num <= number; num++)
            allClap += countClap(num);
        return allClap;
    }
}
