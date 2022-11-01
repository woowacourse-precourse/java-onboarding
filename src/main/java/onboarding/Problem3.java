package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int result = 0;

        for(int num= 1; num <= number; num++){
            result += countCheck(num);
        }
        return result;
    }

    public static int countCheck(int num){
        int count = 0;

        while(num!=0){
            if(num % 10 == 3|| num % 10 == 6|| num % 10 == 9)
                count++;
            num /= 10;
        }
        return count;
    }
}