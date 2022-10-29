package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = numberCount(number);
        return answer;
    }

    public static int numberCount(int number) {
        int count = 0;
        while(number!=0) {
            if ((number%10 == 3) || (number%10 == 6) || (number%10 == 9)) count++;
            number /= 10;
        }
        return count;
    }
}
